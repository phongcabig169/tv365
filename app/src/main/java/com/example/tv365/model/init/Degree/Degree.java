package com.example.tv365.model.init.Degree;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Degree {

    @SerializedName("data")
    @Expose
    private DegreeData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public DegreeData getData() {
        return data;
    }

    public void setData(DegreeData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}