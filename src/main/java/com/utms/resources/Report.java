package com.utms.resources;

import java.util.List;

/**
 * Created by sudheer on 30/5/15.
 */
public class Report {
    String result;
    List<Result> resultList;


    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Report{" +
                "result='" + result + '\'' +
                ", resultList=" + resultList +
                '}';
    }
}
