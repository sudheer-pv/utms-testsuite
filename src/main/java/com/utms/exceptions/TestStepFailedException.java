package com.utms.exceptions;

/**
 * Created by sudheer on 30/5/15.
 */
@SuppressWarnings("serial")
public class TestStepFailedException extends Exception {

	public TestStepFailedException(String reason) {
		// TODO Auto-generated constructor stub
		super(reason);
	}
	public TestStepFailedException(String reason, Exception e) {
		// TODO Auto-generated constructor stub
		super(reason,e);
	}
}
