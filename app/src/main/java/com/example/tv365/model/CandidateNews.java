package com.example.tv365.model;

public class CandidateNews {
    private int rnID;
    private String rnTitle1;
    private String rnTitle2;
    private String rnJobPosition;
    private String rnImage;
    private String rnJobNumber;

    public CandidateNews(int rnID, String rnTitle1, String rnTitle2, String rnJobPosition, String rnImage, String rnJobNumber) {
        this.rnID = rnID;
        this.rnTitle1 = rnTitle1;
        this.rnTitle2 = rnTitle2;
        this.rnJobPosition = rnJobPosition;
        this.rnImage = rnImage;
        this.rnJobNumber = rnJobNumber;
    }

    public int getRnID() {
        return rnID;
    }

    public void setRnID(int rnID) {
        this.rnID = rnID;
    }

    public String getRnTitle1() {
        return rnTitle1;
    }

    public void setRnTitle1(String rnTitle1) {
        this.rnTitle1 = rnTitle1;
    }

    public String getRnTitle2() {
        return rnTitle2;
    }

    public void setRnTitle2(String rnTitle2) {
        this.rnTitle2 = rnTitle2;
    }

    public String getRnJobPosition() {
        return rnJobPosition;
    }

    public void setRnJobPosition(String rnJobPosition) {
        this.rnJobPosition = rnJobPosition;
    }

    public String getRnImage() {
        return rnImage;
    }

    public void setRnImage(String rnImage) {
        this.rnImage = rnImage;
    }

    public String getRnJobNumber() {
        return rnJobNumber;
    }

    public void setRnJobNumber(String rnJobNumber) {
        this.rnJobNumber = rnJobNumber;
    }
}
