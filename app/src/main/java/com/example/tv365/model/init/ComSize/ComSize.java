package com.example.tv365.model.init.ComSize;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComSize {

    @SerializedName("data")
    @Expose
    private ComSizeData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public ComSizeData getData() {
        return data;
    }

    public void setData(ComSizeData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }


}