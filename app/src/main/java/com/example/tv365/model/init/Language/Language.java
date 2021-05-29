package com.example.tv365.model.init.Language;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Language {

    @SerializedName("data")
    @Expose
    private LanguageData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public LanguageData getData() {
        return data;
    }

    public void setData(LanguageData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}