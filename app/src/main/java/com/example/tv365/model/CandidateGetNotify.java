package com.example.tv365.model;

public class CandidateGetNotify {
    private int cgnID;
    private String cngImage;
    private String cgnContent;

    public CandidateGetNotify(int cgnID, String cngImage, String cgnContent) {
        this.cgnID = cgnID;
        this.cngImage = cngImage;
        this.cgnContent = cgnContent;
    }

    public int getCgnID() {
        return cgnID;
    }

    public void setCgnID(int cgnID) {
        this.cgnID = cgnID;
    }

    public String getCngImage() {
        return cngImage;
    }

    public void setCngImage(String cngImage) {
        this.cngImage = cngImage;
    }

    public String getCgnContent() {
        return cgnContent;
    }

    public void setCgnContent(String cgnContent) {
        this.cgnContent = cgnContent;
    }
}
