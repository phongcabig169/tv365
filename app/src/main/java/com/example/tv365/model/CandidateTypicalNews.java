package com.example.tv365.model;

public class CandidateTypicalNews {
    private int ctnID;
    private String ctnImage;
    private String ctnTitle;
    private String ctnContent;
    private String ctnName;
    private String ctnDate;

    public CandidateTypicalNews(int ctnID, String ctnImage, String ctnTitle, String ctnContent, String ctnName, String ctnDate) {
        this.ctnID = ctnID;
        this.ctnImage = ctnImage;
        this.ctnTitle = ctnTitle;
        this.ctnContent = ctnContent;
        this.ctnName = ctnName;
        this.ctnDate = ctnDate;
    }

    public int getCtnID() {
        return ctnID;
    }

    public void setCtnID(int ctnID) {
        this.ctnID = ctnID;
    }

    public String getCtnImage() {
        return ctnImage;
    }

    public void setCtnImage(String ctnImage) {
        this.ctnImage = ctnImage;
    }

    public String getCtnTitle() {
        return ctnTitle;
    }

    public void setCtnTitle(String ctnTitle) {
        this.ctnTitle = ctnTitle;
    }

    public String getCtnContent() {
        return ctnContent;
    }

    public void setCtnContent(String ctnContent) {
        this.ctnContent = ctnContent;
    }

    public String getCtnName() {
        return ctnName;
    }

    public void setCtnName(String ctnName) {
        this.ctnName = ctnName;
    }

    public String getCtnDate() {
        return ctnDate;
    }

    public void setCtnDate(String ctnDate) {
        this.ctnDate = ctnDate;
    }
}
