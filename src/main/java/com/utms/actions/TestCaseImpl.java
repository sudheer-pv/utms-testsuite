package com.utms.actions;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.utms.Interfaces.IPerformAction;
import com.utms.Interfaces.ITestCase;
import com.utms.Interfaces.ITestStep;
import com.utms.entity.AllAutoSteps;
import com.utms.entity.AutoTestCase;
import com.utms.entity.AutoTestStep;
import com.utms.entity.ScreenShotDetails;
import com.utms.entity.TestStepResults;
import com.utms.exceptions.TestStepFailedException;
import com.utms.resources.Parameters;

/**
 * Created by sudheer on 30/5/15.
 */
@Component
public class TestCaseImpl implements ITestCase {

	private String errorReason = null;
	public TestCaseImpl() {
		// nothing to do
	}

	public Set<TestStepResults> execute(AutoTestCase autoTestCase,
			IPerformAction performAction) {

		Set<TestStepResults> allTestStepResults = new HashSet<TestStepResults>();
		Set<AllAutoSteps> steps = autoTestCase
				.getAllAutoStepsesForAutoTestcaseId();

		ITestStep testStep = null;
		
		for (AllAutoSteps allAutoTestStep : steps) {
			TestStepResults testStepResult = new TestStepResults();
			
			try {
				if (!allAutoTestStep.getIsTestStep()) {
					// Means this is a test case
					AutoTestCase refAutoTestCase = allAutoTestStep
							.getAutoTestCaseByAutoTestcaseId();
					ITestCase testCase = new TestCaseImpl();
					allTestStepResults = testCase.execute(refAutoTestCase,
							performAction);
				} else {
					// This is a test step
					AutoTestStep autoTestStep = allAutoTestStep
							.getAutoTestStep();
					ScreenShotDetails.setTestStepId(autoTestStep.getId());
					testStep = new TestStepImpl(autoTestStep.getRefKeyword()
							.getName(), autoTestStep.getObject().getLocator(),
							autoTestStep.getTestData());
					
					testStepResult.setStartDateTime(new Date());
					testStepResult = testStep.execute(performAction);

				}
			} catch (TestStepFailedException e) {
				e.printStackTrace();
			}finally{
				if((testStepResult.getResult()).equalsIgnoreCase(Parameters.FAILED)){
					setErrorReason(testStepResult.getErrorReason());
				}
				testStepResult.setEndDateTime(new Date());
				
				allTestStepResults.add(testStepResult);
			}

			// TODO: make checks if result is correct or not
			// FIXME: If failed then we need to see what to be done;
			
		}

		return allTestStepResults;
	}

	public String getErrorReason() {
		return errorReason;
	}

	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}

}
