package com.example.tv365.model.init.MarriedStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarriedStatus {

    @SerializedName("data")
    @Expose
    private MarriedStatusData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public MarriedStatusData getData() {
        return data;
    }

    public void setData(MarriedStatusData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}