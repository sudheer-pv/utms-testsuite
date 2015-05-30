package com.utms.actions;

import com.utms.Interfaces.TestCase;
import com.utms.resources.Parameters;
import com.utms.resources.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sudheer on 30/5/15.
 */
public class TestCaseImpl implements TestCase {
    private String testCaseId;
    private TestCaseImpl(){
        // nothing to do
    }

    public TestCaseImpl(String testCaseId){
        this.testCaseId = testCaseId;
    }

    public Result execute()  {
        // Get the list of test steps from the db
        List<TestStepImpl> steps = getSteps();
        Result result = new Result();
        result.setStartTime(System.nanoTime());
        for(TestStepImpl step : steps){
            step.execute();
            // TODO: make checks if result is correct or not
            // FIXME: If failed then we need to see what to be done;
        }
        result.setEndTime(System.nanoTime());
        result.setResult(Parameters.SUCCESS);
        return result;
    }

    private List<TestStepImpl> getSteps(){
        return new ArrayList<TestStepImpl>();
        // return the steps from the db
    }
}
