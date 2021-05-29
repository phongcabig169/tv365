package com.example.tv365.Recruiters.model;

import android.widget.ImageView;

public class RecruitmentNews {
    private ImageView imgAvatar;
    private String RecruiTitle;
    private String NumberOfApply;
    private String Address;
    private String Salary;
    private String View;
    private String UpDate_Date;

    public RecruitmentNews() {
    }

    public RecruitmentNews(ImageView imgAvatar, String recruiTitle, String numberOfApply, String address, String salary, String view, String upDate_Date) {
        this.imgAvatar = imgAvatar;
        RecruiTitle = recruiTitle;
        NumberOfApply = numberOfApply;
        Address = address;
        Salary = salary;
        View = view;
        UpDate_Date = upDate_Date;
    }

    public ImageView getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(ImageView imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getRecruiTitle() {
        return RecruiTitle;
    }

    public void setRecruiTitle(String recruiTitle) {
        RecruiTitle = recruiTitle;
    }

    public String getNumberOfApply() {
        return NumberOfApply;
    }

    public void setNumberOfApply(String numberOfApply) {
        NumberOfApply = numberOfApply;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getView() {
        return View;
    }

    public void setView(String view) {
        View = view;
    }

    public String getUpDate_Date() {
        return UpDate_Date;
    }

    public void setUpDate_Date(String upDate_Date) {
        UpDate_Date = upDate_Date;
    }
}
