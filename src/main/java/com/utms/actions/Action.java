package com.utms.actions;


public class Action {


	public enum Types {
		CHECK, UNCHECK, CLEARSESSION, CLICK, CLOSEWINDOW, CLEAR, ENTER, OPENURL, MOUSEOVER, GOBACK, ISDISABLED, ISENABLED, KEYPRESS, SELECT, WAIT, SELECTWINDOW, VERIFY, VERIFYATTRIBUTE, VERIFYNOTPRESENT, VERIFYOBJECT, WAITFORELEMENT, DRAGANDDROP, REFRESH
	}

	public static Types getActionTypeByString(String action) {
		return Types.valueOf(action.toUpperCase());
	}

}
