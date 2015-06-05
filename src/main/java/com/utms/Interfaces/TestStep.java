package com.utms.Interfaces;

import org.springframework.stereotype.Component;

import com.utms.actions.Action.Types;
import com.utms.exceptions.TestStepFailedException;

/**
 * Created by sudheer on 30/5/15.
 */
@Component
public interface TestStep {
	String execute(PerformAction actionToBePerformed, TestStep step) throws TestStepFailedException;

	public Types getActionType();

	public void setActionType(Types actionType);

	public String getData();

	public void setData(String data);

	public String getxPath();

	public void setxPath(String xPath);
}
