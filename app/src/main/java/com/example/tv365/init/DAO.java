package com.example.tv365.init;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tv365.model.init.Cate.CateInfo;
import com.example.tv365.model.init.City.CityDistrictInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.tv365.view.SplashActivity.SHARED_SPLASH;

public class DAO {

    public Map<String, String> getCityMap(Context context){
        Map<String, String> map = new HashMap<>();
        List<CityDistrictInfo> cdList = new ArrayList<>();

        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_SPLASH, Context.MODE_PRIVATE);
        if(sharedPreferences.getString("city", null) != null){
            Type type = new TypeToken<List<CityDistrictInfo>>() {
            }.getType();
            String json = sharedPreferences.getString("city", "");
            Gson gson = new Gson();
            cdList = gson.fromJson(json, type);
            for (int i = 0; i < cdList.size(); i++){
                map.put(cdList.get(i).getCitId(),cdList.get(i).getCitName());
            }
        }
        return map;

    }
    public List<CityDistrictInfo> getCityList(Context context){
        List<CityDistrictInfo> cdList = new ArrayList<>();

        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_SPLASH, Context.MODE_PRIVATE);
        if(sharedPreferences.getString("city", null) != null){
            Type type = new TypeToken<List<CityDistrictInfo>>() {
            }.getType();
            String json = sharedPreferences.getString("city", "");
            Gson gson = new Gson();
            cdList = gson.fromJson(json, type);

        }
        return cdList;
    }

    public List<CateInfo> getCateList(Context context){
        List<CateInfo> cdList = new ArrayList<>();

        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_SPLASH, Context.MODE_PRIVATE);
        if(sharedPreferences.getString("city", null) != null){
            Type type = new TypeToken<List<CateInfo>>() {
            }.getType();
            String json = sharedPreferences.getString("cate", "");
            Gson gson = new Gson();
            cdList = gson.fromJson(json, type);

        }
        return cdList;
    }


}
