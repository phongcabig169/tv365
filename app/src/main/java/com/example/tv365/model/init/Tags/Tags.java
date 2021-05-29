package com.example.tv365.model.init.Tags;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tags {

    @SerializedName("data")
    @Expose
    private TagsData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public TagsData getData() {
        return data;
    }

    public void setData(TagsData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}