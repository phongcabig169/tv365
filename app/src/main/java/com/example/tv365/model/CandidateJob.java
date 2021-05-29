package com.example.tv365.model;

public class CandidateJob {
    private int cjID;
    private String cjTitle;
    private String cjCompany;
    private String cjLocation;
    private String cjDate;
    private String cjSalary;

    public CandidateJob(int cjID, String cjTitle, String cjCompany, String cjLocation, String cjDate, String cjSalary) {
        this.cjID = cjID;
        this.cjTitle = cjTitle;
        this.cjCompany = cjCompany;
        this.cjLocation = cjLocation;
        this.cjDate = cjDate;
        this.cjSalary = cjSalary;
    }

    public String getCjSalary() {
        return cjSalary;
    }

    public void setCjSalary(String cjSalary) {
        this.cjSalary = cjSalary;
    }

    public int getCjID() {
        return cjID;
    }

    public void setCjID(int cjID) {
        this.cjID = cjID;
    }

    public String getCjTitle() {
        return cjTitle;
    }

    public void setCjTitle(String cjTitle) {
        this.cjTitle = cjTitle;
    }

    public String getCjCompany() {
        return cjCompany;
    }

    public void setCjCompany(String cjCompany) {
        this.cjCompany = cjCompany;
    }

    public String getCjLocation() {
        return cjLocation;
    }

    public void setCjLocation(String cjLocation) {
        this.cjLocation = cjLocation;
    }

    public String getCjDate() {
        return cjDate;
    }

    public void setCjDate(String cjDate) {
        this.cjDate = cjDate;
    }
}
