package com.example.tv365.model;

public class Job {
    private int jobID;
    private String jobImage;
    private String jobName;
    private String jobCompany;
    private String jobLocation;

    public Job(int jobID, String jobImage, String jobName, String jobCompany, String jobLocation) {
        this.jobID = jobID;
        this.jobImage = jobImage;
        this.jobName = jobName;
        this.jobCompany = jobCompany;
        this.jobLocation = jobLocation;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getJobImage() {
        return jobImage;
    }

    public void setJobImage(String jobImage) {
        this.jobImage = jobImage;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobCompany() {
        return jobCompany;
    }

    public void setJobCompany(String jobCompany) {
        this.jobCompany = jobCompany;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }
}
