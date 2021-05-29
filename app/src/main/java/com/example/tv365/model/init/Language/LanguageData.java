package com.example.tv365.model.init.Language;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LanguageData {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("ngonngu")
    @Expose
    private List<String> ngonngu = null;

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

    public List<String> getNgonngu() {
        return ngonngu;
    }

    public void setNgonngu(List<String> ngonngu) {
        this.ngonngu = ngonngu;
    }

}