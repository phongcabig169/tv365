package com.example.tv365.model.init.City;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityDistrict {

    @SerializedName("data")
    @Expose
    private CityDistrictData cityDistrictData;
    @SerializedName("error")
    @Expose
    private Object error;

    public CityDistrictData getData() {
        return cityDistrictData;
    }

    public void setData(CityDistrictData cityDistrictData) {
        this.cityDistrictData = cityDistrictData;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}