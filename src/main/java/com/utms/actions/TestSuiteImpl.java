package com.utms.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import com.utms.Interfaces.IPerformAction;
import com.utms.Interfaces.ITestCase;
import com.utms.Interfaces.ITestSuite;
import com.utms.entity.AutoTestCase;
import com.utms.entity.ExeConfig;
import com.utms.entity.ExeConfigRefOsRefBrowser;
import com.utms.entity.ExeRun;
import com.utms.entity.RefOsRefBrowser;
import com.utms.entity.ScreenShotDetails;
import com.utms.entity.TestCaseResults;
import com.utms.entity.TestStepResults;
import com.utms.exceptions.TestCaseFailedException;
import com.utms.exceptions.TestStepFailedException;
import com.utms.repo.ExeRunRepository;
import com.utms.resources.Parameters;
import com.utms.util.PropWithinClasspath;

/**
 * Created by sudheer on 30/5/15.
 */

@Component
public class TestSuiteImpl implements ITestSuite, Runnable {

	private ExeRunRepository exeRunRepository = null;
	private IPerformAction performAction = null;
	private ExeConfig exeConfig = null;
	private List<ExeConfigRefOsRefBrowser> listOfConfigs = null;


	
	
	
	public void invokeTestSuite(ExeConfig exeConfig) {

		this.exeConfig = exeConfig;
		listOfConfigs = new ArrayList<ExeConfigRefOsRefBrowser>();
		listOfConfigs.addAll(exeConfig.getExeConfigRefOsRefBrowsers());
		
//		System.out.println("Step1 : "+listOfConfigs+"  "+ listOfConfigs.size());
		
		for (int i = 0; i < listOfConfigs.size(); i++) {

			Thread thread = new Thread(this);
			thread.start();
		}

	}

	private DesiredCapabilities getDesiredCapability(String browserName,
			String browserVersion, String osName) {
		return new DesiredCapabilities(browserName, "",
				Platform.fromString(osName));
	}
	
	private DesiredCapabilities getDesiredCapability(RefOsRefBrowser osAndBrowser){
		return getDesiredCapability(osAndBrowser
				.getRefBrowser().getName().toLowerCase(), "", osAndBrowser
				.getRefOperatingSystem().getName().toLowerCase());
	}	

	public void execute(ExeConfigRefOsRefBrowser exeConfigRefOsRefBrowser) {

		// Get the test cases from the db
		Set<AutoTestCase> autoTestCases = exeConfig.getAutoTestCases();

//		System.out.println("All Auto Test Cases: "+autoTestCases);
		
		DesiredCapabilities capabilities = getDesiredCapability(exeConfigRefOsRefBrowser.getRefOsRefBrowser());
		
		Properties properties = PropWithinClasspath.getProperties("dev/config.properties");
//		System.out.println(properties+"    "+Boolean.valueOf(properties.getProperty("ISREMOTE").trim())+"*****"+properties.getProperty("ISREMOTE")+"*****");
		WebDriver driver = com.utms.util.DriverFactory.getDriverInstance(
				capabilities,  Boolean.valueOf(properties.getProperty("ISREMOTE").trim()));

		setScreenShotDetails(exeConfig, capabilities);

		performAction.setDriver(driver);

		
		ITestCase testCase = new TestCaseImpl();

		Set<TestCaseResults> allTestCaseResults = new HashSet<TestCaseResults>();

		ExeRun exeRun = new ExeRun(exeConfigRefOsRefBrowser,new Date(),null,null);

		TestCaseResults testCaseResults = null;

		try {
			performAction.execute(Action.getActionTypeByString("openurl"),
					"temp", exeConfig.getRefUrl().getUrl());
		} catch (TestStepFailedException e1) {
			System.out.println( e1.getMessage());
			return;
		} catch (IllegalArgumentException iae) {
			System.out.println( iae.getMessage());
			return;
		}
		
		for (AutoTestCase autoTestCase : autoTestCases) {

//			System.out.println("Auto Test Case: "+autoTestCase);
			testCaseResults = new TestCaseResults();

			ScreenShotDetails.setTestCaseName(autoTestCase.getName());

			testCaseResults.setAutoTestCase(autoTestCase);
			testCaseResults.setStartDateTime(new Date());

			Set<TestStepResults> testStepResults = null;
			try {
				// This is a test case
				testStepResults = testCase.execute(autoTestCase, performAction);
				testCaseResults.setResult(Parameters.PASSED);

			} catch (TestCaseFailedException e) {
				testCaseResults.setResult(Parameters.FAILED);
				testCaseResults.setErrorReason(e.getMessage());
				testCaseResults.setExeRun(exeRun);

			} finally {

				testCaseResults.setEndDateTime(new Date());
				testCaseResults.setTestStepResultses(testStepResults);
				allTestCaseResults.add(testCaseResults);
			}
		}

//		System.out.println("Results : " + allTestCaseResults);
		exeRun.setTestCaseResultses(allTestCaseResults);
		exeRun.setEndDateTime(new Date());
		//exeRunRepository.save(exeRun);
		// return report;
		try {
			performAction.execute(Action.getActionTypeByString("closebrowser"),
					"temp", "");
			performAction.execute(Action.getActionTypeByString("closedriver"),
					"temp", "");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void setScreenShotDetails(ExeConfig exeConfig,
			DesiredCapabilities capabilities) {

		ScreenShotDetails.setBrowserName(capabilities.getBrowserName());
		ScreenShotDetails.setConfigName(exeConfig.getName());
		ScreenShotDetails.setProjectName(exeConfig.getProject().getName());
		ScreenShotDetails.setScrShotDirWithTimeStamp(new SimpleDateFormat(
				"MMddyy").format(new Date()));

	}

	public void setPerformAction(IPerformAction performAction) {

		this.performAction = performAction;
	}

	@Override
	public void run() {
		//TODO:  See how we handle crashes
		ExeConfigRefOsRefBrowser exeConfigRefOsRefBrowser = listOfConfigs.remove(0);
		execute(exeConfigRefOsRefBrowser);
	}

	public void setExeRunRepository(ExeRunRepository exeRunRepository) {
		this.exeRunRepository = exeRunRepository;
	}
}
