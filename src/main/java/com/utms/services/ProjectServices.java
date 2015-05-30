package com.utms.services;

import com.utms.Interfaces.TestCase;
import com.utms.actions.TestCaseImpl;
import com.utms.resources.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sudheer on 30/5/15.
 */
@RestController
public class ProjectServices {

    @RequestMapping("/executeTestCase")
    public @ResponseBody Result executeTestCase(@RequestParam(value = "testCaseId", required = true) String testCaseId){
        TestCase instance =new TestCaseImpl(testCaseId);
        return instance.execute();
    }


}
