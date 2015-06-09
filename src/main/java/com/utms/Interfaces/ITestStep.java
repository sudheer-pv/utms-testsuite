package com.utms.Interfaces;

import org.springframework.stereotype.Component;

import com.utms.entity.TestStepResults;
import com.utms.exceptions.TestStepFailedException;

/**
 * Created by sudheer on 30/5/15.
 */
@Component
public interface ITestStep {
	TestStepResults execute(IPerformAction actionToBePerformed) throws TestStepFailedException;
}
