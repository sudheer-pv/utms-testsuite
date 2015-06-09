package com.utms.Interfaces;

import org.openqa.selenium.WebDriver;

import com.utms.actions.Action.Types;
import com.utms.entity.TestStepResults;

public interface IPerformAction {

	TestStepResults execute(Types action, String xPath, String data);

	void takeScreenShot();

	void setDriver(WebDriver driver);
}
