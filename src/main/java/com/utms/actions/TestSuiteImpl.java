package com.utms.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import com.utms.entity.RefOsRefBrowser;
import com.utms.entity.ScreenShotDetails;
import com.utms.entity.TestCaseResults;
import com.utms.entity.TestStepResults;
import com.utms.resources.Parameters;

/**
 * Created by sudheer on 30/5/15.
 */
@Component
public class TestSuiteImpl implements ITestSuite, Runnable {

	private IPerformAction performAction = null;
	private ExeConfig exeConfig = null;
	private List<ExeConfigRefOsRefBrowser> listOfConfigs = null;

	public void invokeTestSuite(ExeConfig exeConfig) {

		this.exeConfig = exeConfig;

		listOfConfigs = new ArrayList<ExeConfigRefOsRefBrowser>();

		listOfConfigs.addAll(exeConfig.getExeConfigRefOsRefBrowsers());

		for (int i = 0; i < listOfConfigs.size(); i++) {

			TestSuiteImpl testSuite = new TestSuiteImpl();
			Thread thread = new Thread(testSuite);
			thread.start();
		}

	}

	private DesiredCapabilities getCapability(String browserName,
			String browserVersion, String osName) {
		return new DesiredCapabilities(browserName, "",
				Platform.fromString(osName));
	}

	public void execute(ExeConfigRefOsRefBrowser exeConfigRefOsRefBrowser) {

		// Get the test cases from the db
		Set<AutoTestCase> autoTestCases = exeConfig.getAutoTestCases();

		// FIXME: for now assuming there is only one browser and os per suite
		// need to discuss
		RefOsRefBrowser osAndBrowser = exeConfigRefOsRefBrowser
				.getRefOsRefBrowser();
		DesiredCapabilities capabilities = getCapability(osAndBrowser
				.getRefBrowser().getName(), "", osAndBrowser
				.getRefOperatingSystem().getName());

		WebDriver driver = com.utms.util.DriverFactory.getDriverInstance(
				capabilities, Parameters.ISREMOTE);

		setScreenShotDetails(exeConfig, capabilities);

		performAction.setDriver(driver);

		performAction.execute(Action.getActionTypeByString("openurl"), "temp",
				exeConfig.getRefUrl().getUrl());
		ITestCase testCase = new TestCaseImpl();

		Set<TestCaseResults> allTestCaseResults = new HashSet<TestCaseResults>();

		for (AutoTestCase autoTestCase : autoTestCases) {

			TestCaseResults testCaseResults = new TestCaseResults();

			ScreenShotDetails.setTestCaseName(autoTestCase.getName());

			testCaseResults.setStartDateTime(new Date());

			// This is a test case
			Set<TestStepResults> testStepResults = testCase.execute(
					autoTestCase, performAction);

			testCaseResults.setResult(testCase.getErrorReason());

			testCaseResults.setTestStepResultses(testStepResults);

			testCaseResults.setEndDateTime(new Date());

			allTestCaseResults.add(testCaseResults);

			/*
			 * if (result.getResult().equals(Parameters.FAILED)) { // We need to
			 * see if we are implementing the skip option we // return
			 * Parameters.PARTIAL_SUCCESS report.setResult(Parameters.FAILED);
			 * report.setResultList(resultList); // return report; }
			 * resultList.add(result);
			 */
			System.out.println("Results : " + allTestCaseResults);
		}
		// return report;
		performAction.execute(Action.getActionTypeByString("closebrowser"),
				"temp", "");
		performAction.execute(Action.getActionTypeByString("closedriver"),
				"temp", "");

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
		ExeConfigRefOsRefBrowser exeConfigRefOsRefBrowser = listOfConfigs
				.remove(0);
		execute(exeConfigRefOsRefBrowser);
	}
}
