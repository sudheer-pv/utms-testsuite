package com.utms.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.utms.resources.Parameters;

public class DriverFactory {

	public static synchronized WebDriver getDriverInstance(DesiredCapabilities capabilities,
			boolean isRemote) {
		String browserName = capabilities.getBrowserName();
		if (browserName.equalsIgnoreCase(Parameters.FIREFOX)) {
			return getFireforDriver(capabilities, isRemote);
		} else if (browserName.equalsIgnoreCase(Parameters.CHROME)) {
			return getChromeDriver(capabilities, isRemote);
		} else if(browserName.equalsIgnoreCase(Parameters.IE) || browserName.equalsIgnoreCase(Parameters.INTERNATE_EXPLORE)){
			return getIEDriver(capabilities, isRemote);
		}else {
			return null;
		}
	}

	private static WebDriver getIEDriver(DesiredCapabilities capabilities,
			boolean isRemote) {
		return isRemote ? getRemoteDriverInstance(capabilities)
				: new InternetExplorerDriver(capabilities);
	}

	private static WebDriver getFireforDriver(DesiredCapabilities capabilities,
			boolean isRemote) {
		return isRemote ? getRemoteDriverInstance(capabilities)
				: new FirefoxDriver(capabilities);
	}

	private static WebDriver getChromeDriver(DesiredCapabilities capabilities,
			boolean isRemote) {
		System.setProperty("webdriver.chrome.driver", "/opt/apps/chromedriver");
		return isRemote ? getRemoteDriverInstance(capabilities)
				: new ChromeDriver(capabilities);
	}

	private static WebDriver getRemoteDriverInstance(
			DesiredCapabilities capabilities) {
		try {
			Properties properties =new PropWithinClasspath().getProperties("dev/config.properties");
			return new RemoteWebDriver(new URL(properties.getProperty("HUBURL")), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
