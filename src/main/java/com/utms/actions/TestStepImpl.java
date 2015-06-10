package com.utms.actions;

import com.utms.Interfaces.IPerformAction;
import com.utms.Interfaces.ITestStep;
import com.utms.actions.Action.Types;
import com.utms.entity.TestStepResults;
import com.utms.exceptions.TestStepFailedException;

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

	public TestStepResults execute(IPerformAction performAction)
			throws TestStepFailedException {

		TestStepResults testStepResult = null;
		try {

			testStepResult = performAction.execute(actionType, xPath, data);

		} catch (Exception e) {
			performAction.takeScreenShot();
			throw new TestStepFailedException(testStepResult.getErrorReason());
		}

		return testStepResult;
	}

}
