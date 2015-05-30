package com.utms.actions;

import com.utms.Interfaces.TestStep;

/**
 * Created by sudheer on 30/5/15.
 */
public class TestStepImpl implements TestStep{
    ActionType actionType;
    String data;

    private TestStepImpl(){};

    public TestStepImpl(String action, String data){
        actionType = ActionType.valueOf(action.toUpperCase());
        this.data = data;
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public String execute() {
        // We call the execution method or write the logic here
        // Based on the execution we return the result;
        // if failed we throw exception if step fails
        return "result";
    }
}
