package com.utms.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
import com.utms.repo.AutoTestCaseResultsRepository;
import com.utms.repo.AutoTestStepResultsRepository;
import com.utms.repo.ExeRunRepository;
import com.utms.resources.Parameters;
import com.utms.util.PropWithinClasspath;

/**
 * Created by sudheer on 30/5/15.
 */

@Component
public class TestSuiteImpl implements ITestSuite, Runnable {

	private AutoTestCaseResultsRepository autoTestCaseResultsRepository;
	private AutoTestStepResultsRepository autoTestStepResultsRepository;
	private ExeRunRepository exeRunRepository = null;
	private IPerformAction performAction = null;
	private ExeConfig exeConfig = null;
	private ExeConfigRefOsRefBrowser exeConfigRefOsRefBrowser = null;

	/*
	 * public void invokeTestSuite(ExeConfig exeConfig) {
	 * 
	 * this.exeConfig = exeConfig; listOfConfigs = new
	 * ArrayList<ExeConfigRefOsRefBrowser>();
	 * listOfConfigs.addAll(exeConfig.getExeConfigRefOsRefBrowsers());
	 * 
	 * // System.out.println("Step1 : "+listOfConfigs+"  "+ //
	 * listOfConfigs.size());
	 * 
	 * for (int i = 0; i < listOfConfigs.size(); i++) {
	 * 
	 * Thread thread = new Thread(this); thread.start(); }
	 * 
	 * }
	 */
	private DesiredCapabilities getDesiredCapability(String browserName,
			String browserVersion, String osName) {
		synchronized (this) {
			return new DesiredCapabilities(browserName, "",
					Platform.fromString(osName));
		}

	}

	private DesiredCapabilities getDesiredCapability(
			RefOsRefBrowser osAndBrowser) {
		synchronized (osAndBrowser) {
			return getDesiredCapability(osAndBrowser.getRefBrowser().getName()
					.toLowerCase(), "", osAndBrowser.getRefOperatingSystem()
					.getName().toLowerCase());
		}

	}

	public void execute() {

		// Get the test cases from the db
		Set<AutoTestCase> autoTestCases = exeConfig.getAutoTestCases();

		// System.out.println("All Auto Test Cases: " + autoTestCases.size());

		Date startTime = new Date();
		Date endTime = null;
		DesiredCapabilities capabilities = getDesiredCapability(exeConfigRefOsRefBrowser
				.getRefOsRefBrowser());

		Properties properties = new PropWithinClasspath()
				.getProperties("dev/config.properties");
		// System.out.println(properties+"    "+Boolean.valueOf(properties.getProperty("ISREMOTE").trim())+"*****"+properties.getProperty("ISREMOTE")+"*****");

		WebDriver driver = com.utms.util.DriverFactory.getDriverInstance(
				capabilities,
				Boolean.valueOf(properties.getProperty("ISREMOTE").trim()));

		ScreenShotDetails screenShotDetails = getScreenShotDetails(
				capabilities.getBrowserName(), exeConfig.getName(), exeConfig
						.getProject().getName());

		performAction.setDriver(driver);

		ITestCase testCase = new TestCaseImpl();

		Set<TestCaseResults> allTestCaseResults = new HashSet<TestCaseResults>();

		ExeRun exeRun = new ExeRun(exeConfigRefOsRefBrowser, new Date(), null,
				null);

		TestCaseResults testCaseResults = null;

		try {
			performAction.execute(Action.getActionTypeByString("openurl"),
					"temp", exeConfig.getRefUrl().getUrl());
		} catch (TestStepFailedException e1) {
			System.out.println(e1.getMessage());
			return;
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
			return;
		}

		Set<TestStepResults> testStepResults = null;
		for (AutoTestCase autoTestCase : autoTestCases) {

			System.out.println("Auto Test Case: " + autoTestCase.getId());
			testCaseResults = new TestCaseResults();

			screenShotDetails.setTestCaseName(autoTestCase.getName());

			testCaseResults.setAutoTestCase(autoTestCase);
			testCaseResults.setStartDateTime(new Date());

			try {
				// This is a test case
				testStepResults = testCase.execute(autoTestCase, performAction,
						testCaseResults, screenShotDetails);
				testCaseResults.setResult(Parameters.PASSED);

			} catch (TestCaseFailedException e) {
				testCaseResults.setResult(Parameters.FAILED);
				testCaseResults.setErrorReason(e.getMessage());

			} finally {
				testCaseResults.setExeRun(exeRun);
				testCaseResults.setEndDateTime(new Date());
				testCaseResults.setTestStepResultses(testStepResults);
				allTestCaseResults.add(testCaseResults);
			}
		}

		// System.out.println("Results : " + allTestCaseResults);
		exeRun.setTestCaseResultses(allTestCaseResults);
		exeRun.setEndDateTime(new Date());
		persistExeRun(exeRun, allTestCaseResults);

		try {

			performAction.execute(Action.getActionTypeByString("closebrowser"),
					"temp", "");
			performAction.execute(Action.getActionTypeByString("closedriver"),
					"temp", "");
			endTime = new Date();
			System.out.println("Total time taken is : "
					+ (endTime.getTime() - startTime.getTime()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Transactional
	private void persistExeRun(ExeRun exeRun,
			Set<TestCaseResults> allTestCaseResults) {

		exeRunRepository.save(exeRun);
		autoTestCaseResultsRepository.save(allTestCaseResults);
		for (TestCaseResults testCaseResults1 : allTestCaseResults) {
			autoTestStepResultsRepository.save(testCaseResults1
					.getTestStepResultses());
		}

	}

	private ScreenShotDetails getScreenShotDetails(String browserName,
			String configName, String projectName) {
		ScreenShotDetails screenShotDetails = new ScreenShotDetails();
		synchronized (screenShotDetails) {

			screenShotDetails.setBrowserName(browserName);
			screenShotDetails.setConfigName(configName);
			screenShotDetails.setProjectName(projectName);
			screenShotDetails.setScrShotDirWithTimeStamp(new SimpleDateFormat(
					"MMddyy").format(new Date()));
		}

		return screenShotDetails;

	}

	public void setPerformAction(IPerformAction performAction) {

		this.performAction = performAction;
	}

	@Override
	public void run() {

		execute();
	}

	public void setExeRunRepository(ExeRunRepository exeRunRepository) {
		this.exeRunRepository = exeRunRepository;
	}

	public void setAutoTestCaseResultsRepository(
			AutoTestCaseResultsRepository autoTestCaseResultsRepository) {
		this.autoTestCaseResultsRepository = autoTestCaseResultsRepository;
	}

	public void setAutoTestStepResultsRepository(
			AutoTestStepResultsRepository autoTestStepResultsRepository) {
		this.autoTestStepResultsRepository = autoTestStepResultsRepository;
	}

	public void setExeConfig(ExeConfig exeConfig) {
		this.exeConfig = exeConfig;
	}

	public void setExeConfigRefOsRefBrowser(
			ExeConfigRefOsRefBrowser exeConfigRefOsRefBrowser) {
		this.exeConfigRefOsRefBrowser = exeConfigRefOsRefBrowser;
	}
}
