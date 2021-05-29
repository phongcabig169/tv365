package com.example.tv365.model.init.Exp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExpData {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("kinhnghiem")
    @Expose
    private List<String> kinhnghiem = null;

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

    public List<String> getKinhnghiem() {
        return kinhnghiem;
    }

    public void setKinhnghiem(List<String> kinhnghiem) {
        this.kinhnghiem = kinhnghiem;
    }

}