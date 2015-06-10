package com.utms.Interfaces;

import com.utms.entity.ExeConfig;
import com.utms.entity.ExeConfigRefOsRefBrowser;
import com.utms.repo.ExeRunRepository;

/**
 * Created by sudheer on 29/5/15.
 */
public interface ITestSuite {
	
	void invokeTestSuite(ExeConfig exeConfig);
	
	void execute(ExeConfigRefOsRefBrowser exeConfigRefOsRefBrowser);

	void setExeRunRepository(ExeRunRepository exeRunRepository);
	
	void setPerformAction(IPerformAction performAction);
	
}
