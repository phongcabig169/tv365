package com.example.tv365.model.init.Gender;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gender {

    @SerializedName("data")
    @Expose
    private GenderData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public GenderData getData() {
        return data;
    }

    public void setData(GenderData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}