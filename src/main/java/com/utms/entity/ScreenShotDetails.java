package com.utms.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotDetails {

	private static String projectName = null;
	private static String configName = null;
	private static String testCaseName = null;
	private static Integer testStepId;
	private static String scrShotDirWithTimeStamp = null;
	private static String browserName = null;
	
	public static String getProjectName() {
		return projectName;
	}
	public static void setProjectName(String projectName) {
		ScreenShotDetails.projectName = projectName;
	}
	public static String getConfigName() {
		return configName;
	}
	public static void setConfigName(String configName) {
		ScreenShotDetails.configName = configName;
	}
	public static String getTestCaseName() {
		return testCaseName;
	}
	public static void setTestCaseName(String testCaseName) {
		ScreenShotDetails.testCaseName = testCaseName;
	}
	public static Integer getTestStepId() {
		return testStepId;
	}
	public static void setTestStepId(Integer testStepId) {
		ScreenShotDetails.testStepId = testStepId;
	}
	public static String getScrShotDirWithTimeStamp() {
		return scrShotDirWithTimeStamp;
	}
	
	public static void setScrShotDirWithTimeStamp(String scrShotDirWithTimeStamp) {
		ScreenShotDetails.scrShotDirWithTimeStamp = scrShotDirWithTimeStamp;
	}
	
	public static String getScreenShotNameWithTimeStamp() {
		return new SimpleDateFormat("MMddyy_HHmmss").format(new Date());
	}
	public static String getBrowserName() {
		return browserName;
	}
	public static void setBrowserName(String browserName) {
		ScreenShotDetails.browserName = browserName;
	}
}
