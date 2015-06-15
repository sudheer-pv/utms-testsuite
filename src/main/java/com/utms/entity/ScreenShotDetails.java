package com.utms.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotDetails {

	private String projectName = null;
	private String configName = null;
	private String testCaseName = null;
	private Integer testStepId;
	private String scrShotDirWithTimeStamp = null;
	private String browserName = null;

	public ScreenShotDetails() {
	}

	public ScreenShotDetails(String projectName, String configName,
			String testCaseName, Integer testStepId,
			String scrShotDirWithTimeStamp, String browserName) {
		this.projectName = projectName;
		this.configName = configName;
		this.testCaseName = testCaseName;
		this.testStepId = testStepId;
		this.scrShotDirWithTimeStamp = scrShotDirWithTimeStamp;
		this.browserName = browserName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public Integer getTestStepId() {
		return testStepId;
	}

	public void setTestStepId(Integer testStepId) {
		this.testStepId = testStepId;
	}

	public String getScrShotDirWithTimeStamp() {
		return scrShotDirWithTimeStamp;
	}

	public void setScrShotDirWithTimeStamp(String scrShotDirWithTimeStamp) {
		this.scrShotDirWithTimeStamp = scrShotDirWithTimeStamp;
	}

	public String getScreenShotNameWithTimeStamp() {
		return new SimpleDateFormat("MMddyy_HHmmss").format(new Date());
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	@Override
	public String toString() {
		return "ScreenShotDetails [projectName=" + projectName
				+ ", configName=" + configName + ", testCaseName="
				+ testCaseName + ", testStepId=" + testStepId
				+ ", scrShotDirWithTimeStamp=" + scrShotDirWithTimeStamp
				+ ", browserName=" + browserName + "]";
	}
}
