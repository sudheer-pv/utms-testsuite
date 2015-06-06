package com.utms.actions;

import java.util.ArrayList;
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
import com.utms.entity.RefBrowser;
import com.utms.entity.RefOperatingSystem;
import com.utms.resources.Parameters;
import com.utms.resources.Report;
import com.utms.resources.Result;

/**
 * Created by sudheer on 30/5/15.
 */
@Component
public class TestSuiteImpl implements ITestSuite {

	private IPerformAction performAction = null;

	public Result execute(ExeConfig exeConfig) {
		
		// Get the test cases from the db
    	Set<AutoTestCase> autoTestCases = exeConfig.getAutoTestCases();
		
    	
    	List<Result> resultList = new ArrayList<Result>(autoTestCases.size());
		Report report = new Report();
		
		// FIXME: for now assuming there is only one browser and os per suite need to discuss
		Set<RefBrowser> browserSet = exeConfig.getRefBrowsers();
		Set<RefOperatingSystem> osSet = exeConfig.getRefOperatingSystems();		
		DesiredCapabilities capabilities = new DesiredCapabilities(browserSet.iterator().next().getName(), "", Platform.fromString(osSet.iterator().next().getName()));
		WebDriver driver = com.utms.util.DriverFactory.getDriverInstance(capabilities, Parameters.ISREMOTE);
		
		
		performAction.setDriver(driver);
		
		performAction.execute(Action.getActionTypeByString("openurl"), "temp", exeConfig.getUrl());
		ITestCase testCase = new TestCaseImpl();
		
		//FIXME: need to use the entity object instead of the Result object here
		Result result = null;
		for (AutoTestCase autoTestCase : autoTestCases) {
			result = testCase.execute(autoTestCase,performAction);
			
			if (result.getResult().equals(Parameters.FAILED)) {
				// We need to see if we are implementing the skip option we
				// return Parameters.PARTIAL_SUCCESS
				report.setResult(Parameters.FAILED);
				report.setResultList(resultList);
//				return report;
			}
			resultList.add(result);
		}
//		return report;
		return result;
	}

	public IPerformAction getPerformAction() {
		return performAction;
	}

	public void setPerformAction(IPerformAction performAction) {
		this.performAction = performAction;
	}
}
