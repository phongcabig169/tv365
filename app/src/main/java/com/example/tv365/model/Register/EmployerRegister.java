package com.example.tv365.model.Register;

import com.example.tv365.model.Employer;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployerRegister {

    @SerializedName("data")
    @Expose
    private EmployerRegisterData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public EmployerRegisterData getData() {
        return data;
    }

    public void setData(EmployerRegisterData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}