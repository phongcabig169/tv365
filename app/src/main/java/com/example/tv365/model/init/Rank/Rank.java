package com.example.tv365.model.init.Rank;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rank {

    @SerializedName("data")
    @Expose
    private RankData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public RankData getData() {
        return data;
    }

    public void setData(RankData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}