package com.example.tv365.model.init.Exp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComExp {

    @SerializedName("data")
    @Expose
    private ComExpData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public ComExpData getData() {
        return data;
    }

    public void setData(ComExpData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}