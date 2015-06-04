package com.utms.actions;

public class AllActionTypes {

	public enum ActionTypes {
		CHECK, UNCHECK, CLEARSESSION, CLICK, CLOSEWINDOW, CLEAR, ENTER, OPENURL, MOUSEOVER, GOBACK, ISDISABLED, ISENABLED, KEYPRESS, SELECT, WAIT, SELECTWINDOW, VERIFY, VERIFYATTRIBUTE, VERIFYNOTPRESENT, VERIFYOBJECT, WAITFORELEMENT,  DRAGANDDROP, REFRESH
	}
	public static ActionTypes getActionTypeForString(String action) {
		return ActionTypes.valueOf(action.toUpperCase());
	}
}
