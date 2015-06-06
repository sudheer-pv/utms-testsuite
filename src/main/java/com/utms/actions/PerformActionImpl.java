package com.utms.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.utms.Interfaces.IPerformAction;
import com.utms.actions.Action.Types;

@Component
public class PerformActionImpl implements IPerformAction {
	private WebDriver driver = null;

	/*
	 * public void invokeBrowser(DesiredCapabilities capabilities, String
	 * hubUrl) { invokeBrowser(DriverFactory.getDriverInstance(capabilities,
	 * true, hubUrl)); }
	 */

	private void openUrl(String url) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	private void click(String xPath) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(xPath)).click();
	}

	private void clearField(String xPath) {
		driver.findElement(By.xpath(xPath)).clear();
	}

	private void enter(String xPath, String data) {
		driver.findElement(By.xpath(xPath)).sendKeys(data);
		System.out.println("enter() ssss");
	}

	private void closeBrowser() {
		driver.close();
	}

	@SuppressWarnings("unused")
	private void closeDriver() {
		driver.quit();
	}

	private void clearSession() {
		driver.manage().deleteAllCookies();
	}

	private void waitTime(String time) {
		try {
			Thread.sleep(Integer.parseInt(time));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShot() {

	}

	private void validateData(Types action, String xPath) {
		if (null == action) {
			throw new IllegalArgumentException("Action cannot be null!!!");
		}

		if (xPath.isEmpty() && !xPath.equalsIgnoreCase("null")) {

			throw new IllegalArgumentException("xPath cannot be null!!!");
		}
	}

	public void execute(Types actionType, String xPath, String data)
			throws IllegalArgumentException {
		validateData(actionType, xPath);

		switch (actionType) {

		case CLEARSESSION:
			clearSession();
			break;

		case WAIT:
			waitTime(data);
			break;

		case OPENURL:
			openUrl(data);
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
			click(xPath);
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
			System.out.println("ENTER in switch");
			enter(xPath, data);
			break;

		case CLEAR:
			clearField(xPath);
			break;

		case MOUSEOVER:
			// mouseOver(webdriver, fieldText, fieldName, formField_ID);
			break;

		case SELECTWINDOW:

			// selectWindow(webdriver, fieldText, value, fieldName,
			// formField_ID);
			break;

		case CLOSEWINDOW:
			closeBrowser();
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
				driver.navigate().refresh();
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
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
