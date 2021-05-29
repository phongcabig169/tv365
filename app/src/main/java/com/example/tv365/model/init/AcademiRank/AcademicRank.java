package com.example.tv365.model.init.AcademiRank;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcademicRank {

    @SerializedName("data")
    @Expose
    private AcademiRankData data;
    @SerializedName("error")
    @Expose
    private Object error;

    public AcademiRankData getData() {
        return data;
    }

    public void setData(AcademiRankData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}