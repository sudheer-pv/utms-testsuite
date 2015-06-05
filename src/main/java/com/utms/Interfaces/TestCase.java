package com.utms.Interfaces;

import com.utms.actions.TestStepImpl;
import com.utms.repo.AutoTestStepRepository;
import com.utms.repo.ExeConfigRepository;
import com.utms.resources.Result;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sudheer on 29/5/15.
 */
@Component
public interface TestCase {
    Result execute();
    List<TestStepImpl> getSteps();
    String getTestCaseId();
    void setTestCaseId(String testCaseId);
    void setAutoTestStepRepository(AutoTestStepRepository autoTestStepRepository);
    void setExeConfigRepository(ExeConfigRepository exeConfigRepository);
}
