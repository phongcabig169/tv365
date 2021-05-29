package com.example.tv365.model.init.Salary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Salary {

    @SerializedName("data")
    @Expose
    private SalaryData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public SalaryData getData() {
        return data;
    }

    public void setData(SalaryData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}