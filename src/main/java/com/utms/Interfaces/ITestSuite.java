package com.utms.Interfaces;

import com.utms.entity.ExeConfig;
import com.utms.resources.Result;

/**
 * Created by sudheer on 29/5/15.
 */
public interface ITestSuite {
	
	Result execute(ExeConfig exeConfig);

	void setPerformAction(IPerformAction performAction);
	
}
