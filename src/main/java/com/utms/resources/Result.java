package com.utms.resources;

/**
 * Created by sudheer on 30/5/15.
 */
public class Result {
    long startTime;
    long endTime;
    String message;
    String result;

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer("startTime : ");
        buf.append(startTime);
        buf.append(", endTime :");
        buf.append(endTime);
        buf.append(", message :");
        buf.append(message);
        buf.append(", result :");
        buf.append(result);
        return buf.toString();
    }

    public long executionTime(){
        return endTime - startTime;
    }
}
