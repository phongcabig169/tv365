package com.example.tv365.model.init.City;

public class District{

    String id;

    String district;

    public District(String id, String name) {
        this.id = id;
        this.district = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


}
