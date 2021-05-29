package com.example.tv365.model.init.City;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityDistrictData {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("quanhuyen")
    @Expose
    private List<CityDistrictInfo> quanhuyen = null;

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

    public List<CityDistrictInfo> getQuanhuyen() {
        return quanhuyen;
    }

    public void setQuanhuyen(List<CityDistrictInfo> quanhuyen) {
        this.quanhuyen = quanhuyen;
    }

}