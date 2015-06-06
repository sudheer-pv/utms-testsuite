package com.utms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.utms.Interfaces.IPerformAction;
import com.utms.Interfaces.ITestSuite;
import com.utms.entity.ExeConfig;
import com.utms.repo.ExeConfigRepository;
import com.utms.resources.Result;

/**
 * Created by sudheer on 30/5/15.
 */
@RestController
public class ProjectServices {

    @RequestMapping(value = "/executeTestCase", method = RequestMethod.GET)
    @ResponseBody
    public Result executeTestCase(@RequestParam(value = "configId", required = true) String configId){
    	// Get the desired configuration from the db
    	ExeConfig exeConfig = exeConfigRepository.getExeConfig(Integer
				.parseInt(configId));
    	System.out.println("exeConfig  : "+exeConfig );
    	testSuite.setPerformAction(performAction);
        return testSuite.execute(exeConfig);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return new String("Get");
    }
    
    @Autowired
    ExeConfigRepository exeConfigRepository;
    
    @Autowired
    ITestSuite testSuite;
    
    
    @Autowired
    IPerformAction performAction;
}
