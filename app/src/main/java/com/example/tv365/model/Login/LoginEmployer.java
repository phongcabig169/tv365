package com.example.tv365.model.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginEmployer {

    @SerializedName("data")
    @Expose
    private LoginEmployerData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public LoginEmployerData getData() {
        return data;
    }

    public void setData(LoginEmployerData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}