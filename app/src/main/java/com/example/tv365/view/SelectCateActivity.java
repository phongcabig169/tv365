package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.tv365.R;
import com.example.tv365.adapter.ChooseCateAdapter;
import com.example.tv365.adapter.ChooseCityAdapter;
import com.example.tv365.init.DAO;
import com.example.tv365.model.init.Cate.CateInfo;
import com.example.tv365.model.init.City.CityDistrictInfo;

import java.util.ArrayList;
import java.util.List;

public class SelectCateActivity extends AppCompatActivity {

    private CateInfo cateInfo;

    private List<CateInfo> ls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cate);

        initData();
        initAdapter();
    }

    private void initData(){
        ls.addAll(new DAO().getCateList(this));
    }

    private void initAdapter(){
        RecyclerView recyclerView = this.findViewById(R.id.city_card_container);
        ChooseCateAdapter chooseCateAdapter = new ChooseCateAdapter(this, ls);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chooseCateAdapter);

        chooseCateAdapter.setOnItemClick(cityDistrictInfo -> {
            this.cateInfo = cityDistrictInfo;
            Intent i = new Intent();
            i.putExtra("cate", cateInfo);
            setResult(33, i);
            SelectCateActivity.this.finish();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(33, null);
    }
}
