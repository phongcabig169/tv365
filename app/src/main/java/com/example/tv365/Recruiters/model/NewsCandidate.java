package com.example.tv365.Recruiters.model;

import android.widget.ImageView;

public class NewsCandidate {
    private ImageView imgAvatar;
    private String Name;
    private String Career;
    private String Salary;
    private String View;
    private String Address;

    public NewsCandidate() {
    }

    public NewsCandidate(ImageView imgAvatar, String name, String career, String salary, String view, String address) {
        this.imgAvatar = imgAvatar;
        Name = name;
        Career = career;
        Salary = salary;
        View = view;
        Address = address;
    }

    public ImageView getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(ImageView imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCareer() {
        return Career;
    }

    public void setCareer(String career) {
        Career = career;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
