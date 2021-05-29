package com.example.tv365.model.init.WorkType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WorkTypeData {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("htlv")
    @Expose
    private List<String> htlv = null;

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

    public List<String> getHtlv() {
        return htlv;
    }

    public void setHtlv(List<String> htlv) {
        this.htlv = htlv;
    }

}