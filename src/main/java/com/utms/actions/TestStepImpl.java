package com.utms.actions;

import org.openqa.selenium.WebDriver;

import com.utms.Interfaces.TestStep;
import com.utms.actions.AllActionTypes.ActionTypes;

/**
 * Created by sudheer on 30/5/15.
 */
public class TestStepImpl implements TestStep{
    ActionTypes actionType;
    String data;
    String xPath = null;

    @SuppressWarnings("unused")
	private TestStepImpl(){};

    public TestStepImpl(String action, String xPath, String data){
        actionType = ActionTypes.valueOf(action.toUpperCase());
        this.data = data;
        this.xPath = xPath;
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public String execute(WebDriver driver) {
        // We call the execution method or write the logic here
        // Based on the execution we return the result;
        // if failed we throw exception if step fails
        return "result";
    }
}
