package com.example.tv365.model.init.City;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CityDistrictInfo implements Serializable {

    @SerializedName("cit_id")
    @Expose
    private String citId;
    @SerializedName("cit_name")
    @Expose
    private String citName;

    public String getCitId() {
        return citId;
    }

    public void setCitId(String citId) {
        this.citId = citId;
    }

    public String getCitName() {
        return citName;
    }

    public void setCitName(String citName) {
        this.citName = citName;
    }

}