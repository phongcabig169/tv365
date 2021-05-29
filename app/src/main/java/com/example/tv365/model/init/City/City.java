package com.example.tv365.model.init.City;

import java.util.ArrayList;
import java.util.List;

public class City {
    String id;
    String nameCity;
    List<District> listDistrict = new ArrayList<>();

    public List<District> getListDistrict() {
        return listDistrict;
    }

    public void setListDistrict(List<District> listDistrict) {
        this.listDistrict = listDistrict;
    }

    public City(String id, String name, List<District> districts){
        this.id = id;
        this.nameCity = name;
        this.listDistrict.addAll(districts);
    }

    public City(String id,String name){
        this.id = id;
        this.nameCity = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }
}
