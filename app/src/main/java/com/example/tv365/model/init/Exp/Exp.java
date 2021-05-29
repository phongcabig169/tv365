package com.example.tv365.model.init.Exp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Exp {

    @SerializedName("data")
    @Expose
    private ExpData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public ExpData getData() {
        return data;
    }

    public void setData(ExpData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}