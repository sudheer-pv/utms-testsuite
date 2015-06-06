package com.utms.actions;

import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.utms.Interfaces.IPerformAction;
import com.utms.Interfaces.ITestCase;
import com.utms.Interfaces.ITestStep;
import com.utms.entity.AllAutoSteps;
import com.utms.entity.AutoTestCase;
import com.utms.entity.AutoTestStep;
import com.utms.exceptions.TestStepFailedException;
import com.utms.resources.Parameters;
import com.utms.resources.Result;

/**
 * Created by sudheer on 30/5/15.
 */
@Component
public class TestCaseImpl implements ITestCase {

	public TestCaseImpl() {
		// nothing to do
	}

	public Result execute(AutoTestCase autoTestCase,
			IPerformAction performAction) {
		// Get the list of test steps from the db
		// List<ITestStep> steps = getAutoTestSteps(autoTestCase);
		Set<AllAutoSteps> steps = autoTestCase
				.getAllAutoStepsesForAutoTestcaseId();

		Result result = new Result();
		ITestStep testStep = null;
		System.out.println("count : " + steps.size());
		System.out.println("steps : " + steps);
		Iterator<AllAutoSteps> iterator = steps.iterator();
//		for (AllAutoSteps allAutoTestStep : steps) {
		while (iterator.hasNext()) {
			AllAutoSteps allAutoTestStep = iterator.next();
			System.out.println("Start..." + allAutoTestStep);
			System.out
					.println("condition : " + allAutoTestStep.getIsTestStep());
			try {
				if (!allAutoTestStep.getIsTestStep()) {
					// Means this is a test case
					AutoTestCase refAutoTestCase = allAutoTestStep
							.getAutoTestCaseByAutoTestcaseId();
					ITestCase testCase = new TestCaseImpl();
					result = testCase.execute(refAutoTestCase, performAction);
				} else {
					// This is a test step
					System.out.println("else");
					AutoTestStep autoTestStep = allAutoTestStep
							.getAutoTestStep();
					System.out.println("actionType 1 : "
							+ autoTestStep.getRefKeyword().getName());
					System.out.println("xPath 1 : "
							+ autoTestStep.getObject().getLocator());
					System.out
							.println("data 1 : " + autoTestStep.getTestData());
					testStep = new TestStepImpl(autoTestStep.getRefKeyword()
							.getName(), autoTestStep.getObject().getLocator(),
							autoTestStep.getTestData());
					String stepResult = testStep.execute(performAction);
					System.out.println("result : " + result);
				}
			} catch (TestStepFailedException e) {
				// TODO Pass the error properly
				e.printStackTrace();
			}

			// TODO: make checks if result is correct or not
			// FIXME: If failed then we need to see what to be done;
			result.setMessage("Success!!!");
			result.setResult(Parameters.STATUS);
			result.setEndTime(System.nanoTime());
			System.out.println("Returning Result: "+result);
			//return result;
		}

		result.setEndTime(System.nanoTime());
		result.setMessage("Test case executed Successfully");
		result.setResult(Parameters.STATUS);
		return result;
	}

}
