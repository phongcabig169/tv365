package com.example.tv365.model.init.Degree;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DegreeData {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("bangcap")
    @Expose
    private DegreeInfo bangcap;

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

    public DegreeInfo getBangcap() {
        return bangcap;
    }

    public void setBangcap(DegreeInfo bangcap) {
        this.bangcap = bangcap;
    }

}