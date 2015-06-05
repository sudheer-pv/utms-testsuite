package com.utms.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import com.utms.Interfaces.PerformAction;
import com.utms.Interfaces.TestCase;
import com.utms.Interfaces.TestStep;
import com.utms.entity.AutoTestStep;
import com.utms.entity.ExeConfig;
import com.utms.exceptions.TestStepFailedException;
import com.utms.repo.AutoTestStepRepository;
import com.utms.repo.ExeConfigRepository;
import com.utms.resources.Parameters;
import com.utms.resources.Result;

/**
 * Created by sudheer on 30/5/15.
 */
@Component
public class TestCaseImpl implements TestCase {

	private PerformAction performAction = null;
	private AutoTestStepRepository autoTestStepRepository;
	private ExeConfigRepository exeConfigRepository;
	private String testCaseId;

	@SuppressWarnings("unused")
	private TestCaseImpl() {
		// nothing to do
	}

	public TestCaseImpl(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	public Result execute() {
		// Get the list of test steps from the db
		List<TestStep> steps = getSteps();

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = com.utms.util.DriverFactory.getDriverInstance(
				capabilities, Parameters.ISREMOTE);
		performAction.setDriver(driver);
		// FIXME: the below value needs to be changed from testCaseId to
		// configurationId
		ExeConfig exeConfig = exeConfigRepository.findByRunId(testCaseId);

		System.out.println("\nId: " + exeConfig.getId() + "\nRun Id: "
				+ exeConfig.getRunId() + "\nUrl: " + exeConfig.getUrl()
				+ "\nProject Id: " + exeConfig.getProject().getId());
		driver.get(exeConfig.getUrl());

		Result result = new Result();
		result.setStartTime(System.nanoTime());
		
		for (TestStep stepInfo : steps) {
			System.out.println("\nAction Type:: " + stepInfo.getActionType()
					+ " \nXpath:: " + stepInfo.getxPath() + " \nData:: "
					+ stepInfo.getData());
			try {
				stepInfo.execute(performAction, stepInfo);
			} catch (TestStepFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// TODO: make checks if result is correct or not
			// FIXME: If failed then we need to see what to be done;
		}
		
		result.setEndTime(System.nanoTime());
		result.setMessage("Executed Successfully");
		result.setResult(Parameters.STATUS);
		return result;
	}

	public List<TestStep> getSteps() {

		List<AutoTestStep> steps = autoTestStepRepository
				.findByAutoTestCaseId(Integer.parseInt(testCaseId));
		ArrayList<TestStep> testSteps = new ArrayList<TestStep>();
		for (AutoTestStep autoTestStep : steps) {
			TestStepImpl testStepImpl = new TestStepImpl(autoTestStep
					.getRefKeyword().getName(), autoTestStep.getObject()
					.getLocator(), autoTestStep.getTestData());
			testSteps.add(testStepImpl);
		}
		System.out.println("=== Steps " + steps);
		return testSteps;
		// return the steps from the db
	}

	public String getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	/*
	 * public PersonRepo getPersonRepo() { return personRepo; }
	 * 
	 * public void setPersonRepo(PersonRepo personRepo) { this.personRepo =
	 * personRepo; }
	 */

	public AutoTestStepRepository getAutoTestStepRepository() {
		return autoTestStepRepository;
	}

	public void setAutoTestStepRepository(
			AutoTestStepRepository autoTestStepRepository) {
		this.autoTestStepRepository = autoTestStepRepository;
	}

	public ExeConfigRepository getExeConfigRepository() {
		return exeConfigRepository;
	}

	public void setExeConfigRepository(ExeConfigRepository exeConfigRepository) {
		this.exeConfigRepository = exeConfigRepository;
	}

	public PerformAction getPerformAction() {
		return performAction;
	}

	public void setPerformAction(PerformAction performAction) {
		this.performAction = performAction;
	}

}
