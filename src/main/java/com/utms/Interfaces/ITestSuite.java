package com.utms.Interfaces;

import com.utms.entity.ExeConfigRefOsRefBrowser;
import com.utms.repo.AutoTestCaseResultsRepository;
import com.utms.repo.AutoTestStepResultsRepository;
import com.utms.repo.ExeRunRepository;

/**
 * Created by sudheer on 29/5/15.
 */
public interface ITestSuite {

	// void invokeTestSuite(ExeConfig exeConfig);

	void setAutoTestStepResultsRepository(
			AutoTestStepResultsRepository autoTestStepResultsRepository);

	void setAutoTestCaseResultsRepository(
			AutoTestCaseResultsRepository autoTestCaseResultsRepository);

	void execute();

	void setExeConfigRefOsRefBrowser(
			ExeConfigRefOsRefBrowser exeConfigRefOsRefBrowser);

	void setExeRunRepository(ExeRunRepository exeRunRepository);

	void setPerformAction(IPerformAction performAction);

}
