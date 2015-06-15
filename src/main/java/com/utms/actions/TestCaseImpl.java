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
import com.utms.entity.TestCaseResults;
import com.utms.entity.TestStepResults;
import com.utms.exceptions.TestCaseFailedException;
import com.utms.exceptions.TestStepFailedException;

/**
 * Created by sudheer on 30/5/15.
 */

@Component
public class TestCaseImpl implements ITestCase {

	public TestCaseImpl() {
		// nothing to do
	}

	public Set<TestStepResults> execute(AutoTestCase autoTestCase,
			IPerformAction performAction, TestCaseResults testCaseResults, ScreenShotDetails screenShotDetails) throws TestCaseFailedException {

		Set<TestStepResults> allTestStepResults = new HashSet<TestStepResults>();
		Set<AllAutoSteps> steps = autoTestCase
				.getAllAutoStepsesForAutoTestcaseId();

		ITestStep testStep = null;
//		System.out.println("Steps are : "+steps );
		
		for (AllAutoSteps allAutoTestStep : steps) {
			TestStepResults testStepResult = new TestStepResults();
			Date startdate=null;
//			System.out.println("Test Step is : "+allAutoTestStep);
			try {
				if (!allAutoTestStep.getIsTestStep()) {
					// Means this is a test case
					AutoTestCase refAutoTestCase = allAutoTestStep
							.getAutoTestCaseByAutoTestcaseId();
					ITestCase testCase = new TestCaseImpl();
					allTestStepResults = testCase.execute(refAutoTestCase,
							performAction, testCaseResults, screenShotDetails);
				} else {
					// This is a test step
					
//					System.out.println("Entered else");
					
					AutoTestStep autoTestStep = allAutoTestStep.getAutoTestStep();
					
//					System.out.println("autoTestStep : "+autoTestStep);
					
					screenShotDetails.setTestStepId(autoTestStep.getId());
					
//					System.out.println("Set screenshot details");
//					System.out.println("Stage 1 completed : ");
					
//					System.out.println("keyword : "+autoTestStep.getRefKeyword().getName());
//					System.out.println("object : "+autoTestStep.getObject().getLocator());
//					System.out.println("data : "+autoTestStep.getTestData());
					
					testStep = new TestStepImpl(autoTestStep.getRefKeyword()
							.getName(), autoTestStep.getObject().getLocator(),
							autoTestStep.getTestData());
					
					startdate = new Date();
					
					testStepResult = testStep.execute(performAction, screenShotDetails);

				}
			} catch (TestStepFailedException e) {
				e.printStackTrace();
				throw new TestCaseFailedException(e.getMessage(), e);
				
			}finally{
				testStepResult.setStartDateTime(startdate);
				testStepResult.setEndDateTime(new Date());
				testStepResult.setTestCaseResults(testCaseResults);
				allTestStepResults.add(testStepResult);
				System.out.println("Result : " + testStepResult);
			}

			// TODO: make checks if result is correct or not
			// FIXME: If failed then we need to see what to be done;
			
		}

		return allTestStepResults;
	}
}
