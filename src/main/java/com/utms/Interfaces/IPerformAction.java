package com.utms.Interfaces;

import org.openqa.selenium.WebDriver;

import com.utms.actions.Action.Types;

public interface IPerformAction {

	void execute(Types action, String xPath, String data);
	void setDriver(WebDriver driver);
}
