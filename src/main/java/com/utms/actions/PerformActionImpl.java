package com.utms.actions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import com.utms.Interfaces.IPerformAction;
import com.utms.actions.Action.Types;
import com.utms.entity.ScreenShotDetails;
import com.utms.entity.TestStepResults;
import com.utms.resources.Parameters;

@Component
public class PerformActionImpl implements IPerformAction {
	private WebDriver driver = null;
	private TestStepResults testStepResult = null;

	private void setTestStepResult(String status, String comments,
			String errorReason) {
		testStepResult = new TestStepResults();
		testStepResult.setResult(status);
		testStepResult.setComments(comments);
		testStepResult.setErrorReason(errorReason);
		System.out.println("Result : " + testStepResult);
	}

	private boolean verifyIsPresent(String xPath) {

		try {
			driver.findElement(By.xpath(xPath)).isDisplayed();
			setTestStepResult(Parameters.PASSED,
					"Element Is Present In the Page ", "");
			return true;
		} catch (Exception e) {
			setTestStepResult(Parameters.FAILED,
					"Element Is Not Present In the Page ", "Invisible Element");
			return false;
		}
	}

	private void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			setTestStepResult(Parameters.PASSED, " Unable to click Alert ", "");
		} catch (Exception e) {
			setTestStepResult(Parameters.FAILED, " Unable to click Alert ", "");
		}

	}

	private void keyPress(String xPath, String data) {

		String value;
		try {

			value = Keys.valueOf(data).toString();
			driver.findElement(By.xpath(xPath)).sendKeys(value);
			setTestStepResult(Parameters.PASSED,
					"Performing KeyPress Successfully ", "");

		} catch (IndexOutOfBoundsException ie) {
			setTestStepResult(Parameters.FAILED,
					"Can't get Key for the given value  " + data,
					"No Key available in this number");
			return;
		} catch (Exception e) {

			setTestStepResult(Parameters.FAILED,
					"Unable to performing KeyPress",
					"Exception while performing KeyPress Event");
		}

	}

	private void waitForElement(String xPath, String waittime) {

		long seconds = Integer.parseInt(waittime) / 1000;

		while (seconds >= 0) {
			try {

				if (driver.findElement(By.xpath(xPath)).isDisplayed()) {
					return;
				}

			} catch (Exception e) {
			}
			seconds--;
			waitTime("1000");
		}
	}

	private void openUrl(String url) {

		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			setTestStepResult(Parameters.PASSED, "Open URl successfully "
					+ driver.getCurrentUrl(), "");

		} catch (Exception e) {

			System.out.println("Unable To Close The Driver");
			setTestStepResult(Parameters.FAILED, "Unable To Open The URl "
					+ driver.getCurrentUrl(), "");
		}

	}

	private void click(String xPath) {

		try {

			waitTime("1000");
			driver.findElement(By.xpath(xPath)).click();
			setTestStepResult(Parameters.PASSED,
					"Clicked Element Successfully ", "");
//			takeScreenShot();

		} catch (Exception e) {

			System.out.println("Unable To Close The Driver");
			setTestStepResult(Parameters.FAILED, "Unable to Clicked Element "
					+ xPath, "");
		}
	}

	private void clearField(String xPath) {

		try {

			waitTime("1000");
			driver.findElement(By.xpath(xPath)).clear();
			setTestStepResult(Parameters.PASSED,
					"Cleared The Field Successfully ", "");

		} catch (Exception e) {

			System.out.println("Unable To Close The Driver");
			setTestStepResult(Parameters.FAILED, "Unable To Clear The Field",
					"");
		}

	}

	private void enter(String xPath, String data) {

		try {

			driver.findElement(By.xpath(xPath)).sendKeys(data);
			setTestStepResult(Parameters.PASSED, "Entered Data Successfylly ",
					"");

		} catch (Exception e) {

			setTestStepResult(Parameters.FAILED, "Unable To Entered The Data ",
					"");
		}

	}

	private void closeBrowser() {
		try {
			driver.close();
			setTestStepResult(Parameters.PASSED, "browser succesfully closed",
					"");
		} catch (Exception e) {
			System.out.println("Unable To Close The Browser");
			setTestStepResult(Parameters.FAILED, "Unable To Close the Browser",
					"");
		}
	}

	private void closeDriver() {
		try {
			driver.quit();
		} catch (Exception e) {
			setTestStepResult(Parameters.FAILED, "Unable To Close The Driver",
					"");
		}

	}

	private void clearSession() {

		try {

			driver.manage().deleteAllCookies();
			openUrl(driver.getCurrentUrl());
			setTestStepResult(Parameters.PASSED,
					"Delete Cookies & Reload The Page Successfully ", "");

		} catch (Exception e) {

			setTestStepResult(Parameters.FAILED,
					"Unable To Delete Cookies & Reload The Page", "");

		}
	}

	private void waitTime(String time) {

		try {

			Thread.sleep(Integer.parseInt(time));

		} catch (NumberFormatException e) {

			setTestStepResult(Parameters.FAILED, "Unable To Parse the data",
					"You Should Provide Number of time for wait");

		} catch (InterruptedException e) {
			setTestStepResult(Parameters.FAILED,
					"Unable To Wait For Given Time",
					"Got exception in time of waiting");
		}
	}

	private void select(String xPath, String data, String whichBasis) {

		Select select = null;

		try {

			select = new Select(driver.findElement(By.xpath(xPath)));

			if (whichBasis.equalsIgnoreCase("byIndex")) {

				int optionIndex = Integer.parseInt(data);
				if (optionIndex >= 0) {
					select.selectByIndex(optionIndex);
				} else {
					setTestStepResult(Parameters.FAILED,
							"Can not create select object ",
							"Trying To Selection Negetive Indexed option ");
					return;
				}

			} else if (whichBasis.equalsIgnoreCase("byText")) {

				if (!data.equalsIgnoreCase("")) {
					select.selectByVisibleText(data);
				} else {
					setTestStepResult(Parameters.FAILED,
							"Can not create select object ",
							"Trying To Selection Without Any Data ");
					return;
				}

			} else if (whichBasis.equalsIgnoreCase("byValue")) {

				if (!data.equalsIgnoreCase("")) {
					select.selectByValue(data);
				} else {
					setTestStepResult(Parameters.FAILED,
							"Can not create select object ",
							"Trying To Selection Without Any Value ");
					return;
				}

			} else {

				int size = select.getOptions().size();
				int optionIndex = (int) (Math.random() * size);
				select.selectByIndex(optionIndex);

			}

			setTestStepResult(Parameters.PASSED,
					"Select object Created successfully ", "");
		} catch (Exception e) {
			setTestStepResult(Parameters.FAILED,
					"Exception in creating select object ", "");
		}

	}

	private void selectFrame(String xPath, String data, String whichBasis) {

		try {
			if (whichBasis.equalsIgnoreCase("byXpath")) {

				if (!xPath.equalsIgnoreCase("")) {
					WebElement ele = driver.findElement(By.xpath(xPath));
					driver.switchTo().frame(ele);

				} else {
					setTestStepResult(Parameters.FAILED,
							"Can not select frame ",
							"Trying To Selection Without Xpath ");
					return;
				}

			} else {
				if (Integer.parseInt(data) != -1) {
					driver.switchTo().frame(Integer.parseInt(data));
				} else {
					setTestStepResult(Parameters.FAILED,
							"Can not select the frame ",
							"Trying To Selection Negetive Indexed option ");
					return;
				}
			}

			setTestStepResult(Parameters.PASSED, "Select Frame successfully ",
					"");
		} catch (NoSuchFrameException e) {
			setTestStepResult(Parameters.FAILED,
					" Unable to select the frame  ", "No such frame found");
		} catch (Exception e) {
			setTestStepResult(Parameters.FAILED, "Unale to select the frame ",
					" Exception in executing SELECTFRAME ");
		}

	}

	private void check(String xPath) {
		try {

			if (!xPath.equalsIgnoreCase("")) {
				driver.findElement(By.xpath(xPath)).click();
				setTestStepResult(Parameters.PASSED, "Clicked On The Element ",
						"");
			} else {
				setTestStepResult(Parameters.FAILED,
						"Can not Check The Element",
						"Trying To Selection Without Xpath ");
			}

		} catch (Exception e) {
			setTestStepResult(Parameters.FAILED,
					" Unable to perform Check / uncheck",
					"Exception when check on element");
		}
	}

	private void mouseOver(String xPath) {
		try {

			WebElement element = driver.findElement(By.xpath(xPath));
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			setTestStepResult(Parameters.PASSED,
					"Has gone to the element Successfully ", "");

		} catch (Exception e) {
			setTestStepResult(Parameters.FAILED, " Unable get the Element",
					"Exception when trying to get the element");
		}

	}

	private void selectWindow() {

		try {
			waitTime("2000");
			driver.switchTo().window(driver.getWindowHandle());
			driver.manage().window().maximize();
			setTestStepResult(Parameters.PASSED,
					"Has gone to the element Successfully ", "");
		} catch (Exception e) {
			setTestStepResult(Parameters.FAILED,
					" Exception in executing SELECTWINDOW ", "");
		}
	}

	private void goBack() {

		try {
			driver.navigate().back();

			try {
				ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driver) {
						return (((JavascriptExecutor) driver)
								.executeScript("return document.readyState")
								.equals("complete"));
					}
				};

				Wait<WebDriver> wait = new WebDriverWait(driver, 30);

				try {

					wait.until(expectation);

				} catch (Throwable error) {
					setTestStepResult(Parameters.FAILED, "",
							"Page still loaing");
				}

				setTestStepResult(Parameters.PASSED,
						"Has gone to the Back Page Successfully ", "");
			} catch (Exception e) {
				setTestStepResult(Parameters.FAILED, "",
						"exception waitforpageload : ");
			}
		} catch (Exception e) {
			setTestStepResult(Parameters.FAILED, "",
					" Exception in executing GOBACK");
		}
	}

	private void refreshPage() {

		try {
			driver.navigate().refresh();
			Thread.sleep(2000);
			setTestStepResult(Parameters.PASSED,
					"Page Refreshed Successfully ", "");
		} catch (Exception e) {
			setTestStepResult(Parameters.FAILED, "Unable to refresh the page",
					"Exception When Refreshing the page");
		}

	}

	public void dragAndDrop(String srcXpath, String destXpath) {

		if (srcXpath.equals(destXpath)) {
			setTestStepResult(Parameters.FAILED, "",
					" Source and destination points are same ");
			return;
		}

		if (srcXpath.equals("") || destXpath.equals("")) {
			setTestStepResult(Parameters.FAILED, "",
					" One of the target fields are resolved to be empty ");
			return;
		}

		By src = By.xpath(srcXpath);

		if (src == null) {
			setTestStepResult(Parameters.FAILED, "", "Source element not found");
			return;
		}

		By destn = By.xpath(destXpath);

		if (destn == null) {
			setTestStepResult(Parameters.FAILED, "",
					"Destination element not found");
			return;
		}

		try {
			new Actions(driver).dragAndDrop(driver.findElement(src),
					driver.findElement(destn));
			setTestStepResult(Parameters.PASSED, "Drag And Drop Successfylly ",
					"");
		} catch (Exception e) {
			setTestStepResult(Parameters.FAILED, "",
					" Exception while performing drag and drop operation");
		}
	}

	private void createDir(String dirName, String errorMessage) {
		File file = new File(dirName);
		try {
			if (!file.exists()) {
				file.mkdir();
				System.out.println("Directory Created :: " + errorMessage);
			}
		} catch (Throwable e) {
			System.out.println("Unable to create directory with "
					+ errorMessage);
		}
	}

	public void takeScreenShot() {

		String name = "ScreenShots//" + ScreenShotDetails.getProjectName();
				
		createDir(name, "Project Name");

		// name = name + "\\";

		name = name + "//" + ScreenShotDetails.getConfigName();
		createDir(name, "Config Name");
		
		name = name + "//" + ScreenShotDetails.getScrShotDirWithTimeStamp();
		createDir(name, "TimeStamp");

		// strScreenshotName = name + "\\" + +
		// ScreenShotDetails.getTestCaseName()+"_"+ScreenShotDetails.getScreenShotNameWithTimeStamp()+".png";

		String strScreenshotName = name + "//"
				+ ScreenShotDetails.getTestCaseName() + "_"
				+ ScreenShotDetails.getScreenShotNameWithTimeStamp() + ".png";
		try {
			if ((ScreenShotDetails.getBrowserName())
					.equalsIgnoreCase("ANDROIDNATIVEAPP")) {
				WebDriver augmentedDriver = new Augmenter().augment(driver);
				File file = ((TakesScreenshot) augmentedDriver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file, new File(strScreenshotName));
				file.delete();
			} else {
				File file = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file, new File(strScreenshotName));
				file.delete();
			}

			strScreenshotName = ". Screen Shot : " + strScreenshotName;
			System.out.println(strScreenshotName);
		} catch (Exception e) {
			System.out.println("Unable to take the screenshot");
		}
	}

	private void validateData(Types action, String xPath) {
		if (null == action) {
			throw new IllegalArgumentException("Action cannot be null!!!");
		}

		if (xPath.isEmpty() && !xPath.equalsIgnoreCase("null")) {

			throw new IllegalArgumentException("xPath cannot be null!!!");
		}
	}

	public TestStepResults execute(Types actionType, String xPath, String data)
			throws IllegalArgumentException {

		validateData(actionType, xPath);

		switch (actionType) {

		case ACCEPTALERT:
			acceptAlert();
			break;

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
			waitForElement(xPath, data);
			break;

		case VERIFYISPRESENT:
			verifyIsPresent(xPath);
			break;

		case SELECTBYINDEX:
			select(xPath, data, "byIndex");
			break;

		case SELECTBYVALUE:
			select(xPath, data, "byValue");
			break;

		case SELECTBYVISIBLETEXT:
			select(xPath, data, "byText");
			break;

		case SELECTRANDOMLY:
			select(xPath, "", "randomly");
			break;

		case SELECTFRAMEBYINDEX:
			selectFrame(xPath, data, "byIndex");
			break;

		case SELECTFRAMEBYXPATH:
			selectFrame(xPath, "", "byXpath");
			break;

		case CLICK:
			click(xPath);
			break;

		case CHECK:
			check(xPath);
			break;

		case UNCHECK:
			check(xPath);
			break;

		case ENTER:
			enter(xPath, data);
			break;

		case CLEAR:
			clearField(xPath);
			break;

		case MOUSEOVER:
			waitTime("1000");
			mouseOver(xPath);
			break;

		case SELECTWINDOW:
			selectWindow();
			break;

		case CLOSEBROWSER:
			closeBrowser();
			break;

		case GOBACK:
			goBack();
			break;

		case KEYPRESS:
			keyPress(xPath, data);
			break;

		case DRAGANDDROP:
			dragAndDrop(xPath, data);
			break;

		case REFRESH:
			refreshPage();
			break;

		case CLOSEDRIVER:
			closeDriver();
			break;

		default:
			break;

		}
		return testStepResult;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
