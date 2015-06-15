package com.utms.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.utms.actions.PerformActionImpl;
import com.utms.actions.TestSuiteImpl;
import com.utms.entity.ExeConfig;
import com.utms.entity.ExeConfigRefOsRefBrowser;
import com.utms.repo.AutoTestCaseResultsRepository;
import com.utms.repo.AutoTestStepResultsRepository;
import com.utms.repo.ExeConfigRepository;
import com.utms.repo.ExeRunRepository;

/**
 * Created by sudheer on 30/5/15.
 */
@RestController
public class ProjectServices {

	private List<ExeConfigRefOsRefBrowser> listOfConfigs = null;
	private  Logger log = Logger.getLogger(ProjectServices.class.getName());

	@RequestMapping(value = "/executeTestSuite", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	
	public void executeTestCase(
			@RequestParam(value = "configId", required = true) String configId) {

		DOMConfigurator.configure("log4j.xml");
		log.info(" Hit the executeTestSuite service with configId : "+configId);
		invokeTestSuite(configId);
	}

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public String get() { return new String("Get"); }
	 */

	@Transactional
	public void invokeTestSuite(String configId) {
		// Get the desired configuration from the db
		ExeConfig exeConfig = exeConfigRepository.getExeConfigById(Integer
				.parseInt(configId));
		
		log.info("Got the desired configuration from the db ");
		
		listOfConfigs = new ArrayList<ExeConfigRefOsRefBrowser>();
		listOfConfigs.addAll(exeConfig.getExeConfigRefOsRefBrowsers());

		for (int i = 0; i < listOfConfigs.size(); i++) {

			TestSuiteImpl testSuite = new TestSuiteImpl();
			testSuite.setExeConfig(exeConfig);
			testSuite.setExeRunRepository(exeRunRepository);
			testSuite
					.setAutoTestCaseResultsRepository(autoTestCaseResultsRepository);
			testSuite
					.setAutoTestStepResultsRepository(autoTestStepResultsRepository);
			testSuite.setPerformAction(new PerformActionImpl());
			testSuite.setExeConfigRefOsRefBrowser(listOfConfigs.get(i));
			Thread thread = new Thread(testSuite);
			thread.start();
		}

	}

	
	@Autowired
	ExeConfigRepository exeConfigRepository;

	@Autowired
	ExeRunRepository exeRunRepository;

	@Autowired
	AutoTestCaseResultsRepository autoTestCaseResultsRepository;

	@Autowired
	AutoTestStepResultsRepository autoTestStepResultsRepository;

}
