package com.example.tv365.model.init.WorkType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkType {

    @SerializedName("data")
    @Expose
    private WorkTypeData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public WorkTypeData getData() {
        return data;
    }

    public void setData(WorkTypeData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}