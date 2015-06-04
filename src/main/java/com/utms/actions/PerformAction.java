package com.utms.actions;

import org.openqa.selenium.WebDriver;

import com.utms.actions.AllActionTypes.ActionTypes;


public class PerformAction {
	public static void performAction(ActionTypes actionType,
			WebDriver webdriver, String xPath, String data) {

		ActionsToBePerformed allActions = new ActionsToBePerformed();

		if (allActions != null) {
			try {

				allActions.setDriver(webdriver);

				switch (actionType) {

				case CLEARSESSION:
					allActions.clearSession();
					break;

				case WAIT:

					break;

				case OPENURL:
					allActions.openUrl(data);
					break;

				case WAITFORELEMENT:
					// waitForElement(webdriver, fieldText, value, fieldName,
					// formField_ID);
					break;

				case VERIFY:
					// verify(webdriver, fieldText, value, fieldName,
					// formField_ID);
					break;

				case VERIFYNOTPRESENT:
					// verifynotpresent(webdriver, fieldText, value, fieldName,
					// formField_ID);
					break;

				case SELECT:
					// select(webdriver, fieldText, value, fieldName,
					// formField_ID);
					// sleep(1000);
					break;

				case CLICK:
					allActions.click(xPath);
					break;

				case CHECK:
					// checkOrUncheck(webdriver, fieldText, value, fieldName,
					// true,
					// formField_ID);
					break;

				case UNCHECK:
					// checkOrUncheck(webdriver, fieldText, value, fieldName,
					// false,
					// formField_ID);
					break;

				case ENTER:
					allActions.enter(xPath, data);
					break;

				case CLEAR:
					allActions.clearField(xPath);
					break;

				case MOUSEOVER:
					// mouseOver(webdriver, fieldText, fieldName, formField_ID);
					break;

				case SELECTWINDOW:

					// selectWindow(webdriver, fieldText, value, fieldName,
					// formField_ID);
					break;

				case CLOSEWINDOW:
					allActions.closeBrowser();
					// formField_ID);
					break;

				case GOBACK:
					// goBack(webdriver);
					break;

				case ISDISABLED:
					//
					// isEnabledorDisabled(webdriver, fieldText, fieldName,
					// false,
					// formField_ID);
					break;

				case ISENABLED:
					// isEnabledorDisabled(webdriver, fieldText, fieldName,
					// true,
					// formField_ID);
					break;

				case KEYPRESS:
					// keypress(webdriver, fieldText, value, fieldName,
					// formField_ID);
					break;

				case VERIFYATTRIBUTE:
					// verifyAttribute(webdriver, fieldText, value, fieldName,
					// formField_ID);
					break;

				case DRAGANDDROP:
					// dragAndDrop(webdriver, fieldText, fieldName,
					// formField_ID);
					break;
				case REFRESH:
					try {
						webdriver.navigate().refresh();
						Thread.sleep(2000);
					} catch (Exception e) {
						System.out.println("Unable to refresh the page");
					}

					break;
				case VERIFYOBJECT:
					// verifyObject(webdriver,fieldText,value,fieldName,
					// formField_ID);
					break;

				}

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}
}
