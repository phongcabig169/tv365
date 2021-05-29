package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.tv365.R;
import com.example.tv365.adapter.ChooseCityAdapter;
import com.example.tv365.adapter.itemClick.CityItemClick;
import com.example.tv365.adapter.itemClick.ItemClick;
import com.example.tv365.init.DAO;
import com.example.tv365.model.init.City.CityDistrictInfo;

import java.util.ArrayList;
import java.util.List;

public class SelectCityActivity extends AppCompatActivity {

    private CityDistrictInfo cityDistrictInfo;

    private List<CityDistrictInfo> ls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        initData();
        initAdapter();
    }

    private void initData(){
        ls.addAll(new DAO().getCityList(this));
    }

    private void initAdapter(){
        RecyclerView recyclerView = this.findViewById(R.id.city_card_container);
        ChooseCityAdapter chooseCityAdapter = new ChooseCityAdapter(this, ls);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chooseCityAdapter);

        chooseCityAdapter.setOnItemClick(cityDistrictInfo -> {
            this.cityDistrictInfo = cityDistrictInfo;
            Intent i = new Intent();
            i.putExtra("city", cityDistrictInfo);
            setResult(11, i);
            SelectCityActivity.this.finish();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(11, null);
    }
}