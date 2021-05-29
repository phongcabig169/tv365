package com.example.tv365.model.init.AcademiRank;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcademiRankData {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("xeploai")
    @Expose
    private List<String> xeploai = null;

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

    public List<String> getXeploai() {
        return xeploai;
    }

    public void setXeploai(List<String> xeploai) {
        this.xeploai = xeploai;
    }

}