package com.example.tv365.model.init.Cate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cate {

    @SerializedName("data")
    @Expose
    private CateData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public CateData getData() {
        return data;
    }

    public void setData(CateData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}