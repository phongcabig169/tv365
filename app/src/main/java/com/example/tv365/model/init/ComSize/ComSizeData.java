package com.example.tv365.model.init.ComSize;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComSizeData {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("quymo")
    @Expose
    private List<String> quymo = null;

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

    public List<String> getQuymo() {
        return quymo;
    }

    public void setQuymo(List<String> quymo) {
        this.quymo = quymo;
    }

}