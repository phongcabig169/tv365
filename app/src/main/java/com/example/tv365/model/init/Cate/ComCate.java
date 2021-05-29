package com.example.tv365.model.init.Cate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComCate {

    @SerializedName("data")
    @Expose
    private ComCateData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public ComCateData getData() {
        return data;
    }

    public void setData(ComCateData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}