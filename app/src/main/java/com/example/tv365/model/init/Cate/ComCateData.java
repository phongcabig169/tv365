package com.example.tv365.model.init.Cate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComCateData {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("linhvuc")
    @Expose
    private List<ComCateInfo> linhvuc = null;

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

    public List<ComCateInfo> getLinhvuc() {
        return linhvuc;
    }

    public void setLinhvuc(List<ComCateInfo> linhvuc) {
        this.linhvuc = linhvuc;
    }

}