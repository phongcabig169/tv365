package com.example.tv365.model.init.Cate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComCateInfo {

    @SerializedName("cate_id")
    @Expose
    private String cateId;
    @SerializedName("cate_name")
    @Expose
    private String cateName;

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

}