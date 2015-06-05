package com.utms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.utms.Interfaces.PerformAction;
import com.utms.Interfaces.TestCase;
import com.utms.repo.AutoTestStepRepository;
import com.utms.repo.ExeConfigRepository;
import com.utms.resources.Result;

/**
 * Created by sudheer on 30/5/15.
 */
@RestController
public class ProjectServices {

    @RequestMapping(value = "/executeTestCase", method = RequestMethod.GET)
    @ResponseBody
    public Result executeTestCase(@RequestParam(value = "testCaseId", required = true) String testCaseId){
    	instance.setTestCaseId(testCaseId);
    	instance.setAutoTestStepRepository(autoTestStepRepo);
    	instance.setExeConfigRepository(exeConfigRepository);
    	instance.setPerformAction(performAction);
        return instance.execute();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return new String("Get");
    }
    @Autowired
	private AutoTestStepRepository autoTestStepRepo;
    
    @Autowired
    private ExeConfigRepository exeConfigRepository;
    
    @Autowired
    TestCase instance;
    
    @Autowired
    PerformAction performAction;
}
