package com.utms.Interfaces;

import java.util.Set;

import com.utms.entity.AutoTestCase;
import com.utms.entity.ScreenShotDetails;
import com.utms.entity.TestCaseResults;
import com.utms.entity.TestStepResults;
import com.utms.exceptions.TestCaseFailedException;

/**
 * Created by sudheer on 29/5/15.
 */

public interface ITestCase {
	
	Set<TestStepResults> execute(AutoTestCase autoTestCase, IPerformAction performAction, TestCaseResults testCaseResults, ScreenShotDetails screenShotDetails) throws TestCaseFailedException;
}
