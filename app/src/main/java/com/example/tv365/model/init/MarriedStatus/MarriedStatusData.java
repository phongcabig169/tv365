package com.example.tv365.model.init.MarriedStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarriedStatusData {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("honnhan")
    @Expose
    private MarriedStatusInfo honnhan;

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

    public MarriedStatusInfo getHonnhan() {
        return honnhan;
    }

    public void setHonnhan(MarriedStatusInfo honnhan) {
        this.honnhan = honnhan;
    }

}