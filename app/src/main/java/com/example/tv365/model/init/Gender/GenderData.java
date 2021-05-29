package com.example.tv365.model.init.Gender;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenderData {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("gioitinh")
    @Expose
    private GenderInfo gioitinh;

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

    public GenderInfo getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(GenderInfo gioitinh) {
        this.gioitinh = gioitinh;
    }

}