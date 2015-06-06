package com.utms.Interfaces;

import java.util.List;

import com.utms.entity.AutoTestCase;
import com.utms.repo.AutoTestStepRepository;
import com.utms.repo.ExeConfigRepository;
import com.utms.resources.Result;

/**
 * Created by sudheer on 29/5/15.
 */

public interface ITestCase {
	Result execute(AutoTestCase autoTestCase, IPerformAction performAction);
}
