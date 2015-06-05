package com.utms.Interfaces;

import java.util.List;

import com.utms.actions.TestStepImpl;
import com.utms.repo.AutoTestStepRepository;
import com.utms.repo.ExeConfigRepository;
import com.utms.resources.Result;

/**
 * Created by sudheer on 29/5/15.
 */

public interface TestCase {
    Result execute();
    List<TestStepImpl> getSteps();
    String getTestCaseId();
    void setTestCaseId(String testCaseId);
    void setAutoTestStepRepository(AutoTestStepRepository autoTestStepRepository);
    void setExeConfigRepository(ExeConfigRepository exeConfigRepository);
}
