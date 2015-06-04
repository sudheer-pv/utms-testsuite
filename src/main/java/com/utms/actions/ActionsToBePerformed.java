package com.utms.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionsToBePerformed {
	private WebDriver driver = null;

	/*
	 * public void invokeBrowser(DesiredCapabilities capabilities, String
	 * hubUrl) { invokeBrowser(DriverFactory.getDriverInstance(capabilities,
	 * true, hubUrl)); }
	 */

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void openUrl(String url) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	public void click(String xPath) {
		driver.findElement(By.xpath(xPath)).click();
	}

	public void clearField(String xPath) {
		driver.findElement(By.xpath(xPath)).clear();
	}

	public void enter(String xPath, String data) {
		driver.findElement(By.xpath(xPath)).sendKeys(data);
	}

	public void closeBrowser() {
		driver.close();
	}

	public void closeDriver() {
		driver.quit();
	}

	public void clearSession() {
		driver.manage().deleteAllCookies();
	}

	public void waitTime(String time) {
		try {
			Thread.sleep(Integer.parseInt(time));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void takeScreenShot(){
		
	}
}
