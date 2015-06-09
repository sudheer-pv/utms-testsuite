package com.utms.Interfaces;

import com.utms.entity.ExeConfig;
import com.utms.entity.ExeConfigRefOsRefBrowser;

/**
 * Created by sudheer on 29/5/15.
 */
public interface ITestSuite {
	
	void invokeTestSuite(ExeConfig exeConfig);
	
	void execute(ExeConfigRefOsRefBrowser exeConfigRefOsRefBrowser);

	void setPerformAction(IPerformAction performAction);
	
}
