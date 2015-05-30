package com.utms.actions;

import com.utms.Interfaces.TestCase;
import com.utms.Interfaces.TestSuite;
import com.utms.resources.Parameters;
import com.utms.resources.Report;
import com.utms.resources.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sudheer on 30/5/15.
 */
public class TestSuiteImpl implements TestSuite {

    public Report executeTestCase(TestCase testCase) {
        // Read db for the list of test cases and execute
        List<TestCase> testCases = new ArrayList<TestCase>();
        List<Result> resultList = new ArrayList<Result>(testCases.size());
        Report report = new Report();


        for(TestCase tCase: testCases){
            Result result = tCase.execute();
            if(result.getResult().equals(Parameters.FAILED)){
                // We need to see if we are implementing the skip option we return Parameters.PARTIAL_SUCCESS
                report.setResult(Parameters.FAILED);
                report.setResultList(resultList);
                return report;
            }
            resultList.add(result);
        }
        return report;
    }
}
