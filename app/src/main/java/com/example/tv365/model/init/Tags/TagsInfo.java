package com.example.tv365.model.init.Tags;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TagsInfo{

    @SerializedName("tag_id")
    @Expose
    private String tagId;
    @SerializedName("tag_name")
    @Expose
    private String tagName;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}