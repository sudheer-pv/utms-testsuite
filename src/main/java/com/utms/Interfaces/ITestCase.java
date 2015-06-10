package com.utms.Interfaces;

import java.util.Set;

import com.utms.entity.AutoTestCase;
import com.utms.entity.TestStepResults;
import com.utms.exceptions.TestCaseFailedException;

/**
 * Created by sudheer on 29/5/15.
 */

public interface ITestCase {
	
	Set<TestStepResults> execute(AutoTestCase autoTestCase, IPerformAction performAction) throws TestCaseFailedException;
}
