package com.utms.Interfaces;

import org.openqa.selenium.WebDriver;

import com.utms.actions.Action.Types;
import com.utms.entity.ScreenShotDetails;
import com.utms.entity.TestStepResults;
import com.utms.exceptions.TestStepFailedException;

public interface IPerformAction {

	TestStepResults execute(Types action, String xPath, String data)throws TestStepFailedException;

	void takeScreenShot(ScreenShotDetails screenShotDetails)throws TestStepFailedException;

	void setDriver(WebDriver driver);
}
