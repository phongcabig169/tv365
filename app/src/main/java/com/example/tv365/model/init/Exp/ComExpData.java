package com.example.tv365.model.init.Exp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComExpData {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("kinhnghiem_com")
    @Expose
    private List<String> kinhnghiemCom = null;

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

    public List<String> getKinhnghiemCom() {
        return kinhnghiemCom;
    }

    public void setKinhnghiemCom(List<String> kinhnghiemCom) {
        this.kinhnghiemCom = kinhnghiemCom;
    }

}