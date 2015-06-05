package com.utms.service;

import com.utms.Interfaces.TestCase;
import com.utms.repo.AutoTestStepRepository;
import com.utms.repo.ExeConfigRepository;
import com.utms.resources.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
