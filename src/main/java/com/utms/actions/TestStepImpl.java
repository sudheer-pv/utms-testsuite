package com.utms.actions;

import com.utms.Interfaces.IPerformAction;
import com.utms.Interfaces.ITestStep;
import com.utms.actions.Action.Types;

/**
 * Created by sudheer on 30/5/15.
 */
public class TestStepImpl implements ITestStep {
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

	public String execute(IPerformAction performAction) {
		System.out.println("actionType : "+actionType);
		System.out.println("xPath : "+xPath);
		System.out.println("data : "+data);
		performAction.execute(actionType, xPath, data);
		// We call the execution method or write the logic here
		// Based on the execution we return the result;
		// if failed we throw exception if step fails
		return "result";
	}
	
	
}
