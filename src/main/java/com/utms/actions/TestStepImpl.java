package com.utms.actions;

import com.utms.Interfaces.PerformAction;
import com.utms.Interfaces.TestStep;
import com.utms.actions.Action.Types;

/**
 * Created by sudheer on 30/5/15.
 */
public class TestStepImpl implements TestStep {
	Types actionType;
	String data;
	String xPath = null;

	@SuppressWarnings("unused")
	private TestStepImpl() {
	};

	public TestStepImpl(String action, String xPath, String data) {
		actionType = Action.getActionTypeByString(action);
		this.data = data;
		this.xPath = xPath;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public String execute(PerformAction performAction, TestStep stepInfo) {
		performAction.execute(stepInfo.getActionType(), stepInfo.getxPath(), stepInfo.getData());
		// We call the execution method or write the logic here
		// Based on the execution we return the result;
		// if failed we throw exception if step fails
		return "result";
	}

	public Types getActionType() {
		return actionType;
	}

	public void setActionType(Types actionType) {
		this.actionType = actionType;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getxPath() {
		return xPath;
	}

	public void setxPath(String xPath) {
		this.xPath = xPath;
	}
}
