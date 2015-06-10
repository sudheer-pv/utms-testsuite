package com.utms.exceptions;


/**
 * Created by sudheer on 30/5/15.
 */
@SuppressWarnings("serial")
public class TestCaseFailedException extends Throwable {
    public TestCaseFailedException(String reason) {
		// TODO Auto-generated constructor stub
    	super(reason);
	}
}
