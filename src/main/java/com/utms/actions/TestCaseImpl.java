package com.utms.actions;

import com.utms.Interfaces.TestCase;
import com.utms.entity.AutoTestStep;
import com.utms.repo.AutoTestStepRepository;
import com.utms.repo.ExeConfigRepository;
import com.utms.resources.Parameters;
import com.utms.resources.Result;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sudheer on 30/5/15.
 */
public class TestCaseImpl implements TestCase{

//	private PersonRepo personRepo;

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
		List<TestStepImpl> steps = getSteps();
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = com.utms.util.DriverFactory.getDriverInstance(
				capabilities, Parameters.ISREMOTE);
		Result result = new Result();
		result.setStartTime(System.nanoTime());

		for (TestStepImpl step : steps) {
			step.execute(driver);
			// TODO: make checks if result is correct or not
			// FIXME: If failed then we need to see what to be done;
		}
		result.setEndTime(System.nanoTime());
		result.setResult(Parameters.SUCCESS);
		return result;
	}

	public List<TestStepImpl> getSteps() {
		/*System.out.println(personRepo);
		Person p1 = personRepo.findById(101);*/
		List<AutoTestStep> steps = autoTestStepRepository.findByAutoTestCaseId(Integer.parseInt(testCaseId));
		ArrayList<TestStepImpl> testSteps=new ArrayList<TestStepImpl>();
		for(AutoTestStep autoTestStep:steps){
			TestStepImpl testStepImpl = new TestStepImpl(autoTestStep.getRefKeyword().getName(), autoTestStep.getObject().getLocator(), autoTestStep.getTestData());
			testSteps.add(testStepImpl);
		}
		System.out.println("=== Steps "+ steps);
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
	public PersonRepo getPersonRepo() {
		return personRepo;
	}

	public void setPersonRepo(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}*/

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
}
