package com.example.tv365.model.init.Salary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SalaryData {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("mucluong")
    @Expose
    private List<String> mucluong = null;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getMucluong() {
        return mucluong;
    }

    public void setMucluong(List<String> mucluong) {
        this.mucluong = mucluong;
    }

}