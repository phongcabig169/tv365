package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.tv365.R;
import com.example.tv365.adapter.ChooseCityAdapter;
import com.example.tv365.config.ConfigRetrofitApi;
import com.example.tv365.config.InterfaceAPI;
import com.example.tv365.init.DAO;
import com.example.tv365.model.init.City.CityDistrict;
import com.example.tv365.model.init.City.CityDistrictInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SelectDistrictActivity extends AppCompatActivity {

    private List<CityDistrictInfo> ls = new ArrayList<>();

    private CityDistrictInfo cityDistrictInfo;

    private CityDistrictInfo cityParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_district);

        initData();
//        initAdapter();
    }

    private void initData(){
        cityParent = (CityDistrictInfo) getIntent().getSerializableExtra("parent");
        Log.d("TAG", "initData: " + cityParent.getCitName());

        if(cityParent != null) {
            Retrofit retrofit = ConfigRetrofitApi.getInstance();
            retrofit.create(InterfaceAPI.class)
                    .getCity(cityParent.getCitId())
                    .enqueue(new Callback<CityDistrict>() {
                        @Override
                        public void onResponse(Call<CityDistrict> call, Response<CityDistrict> response) {
                            if (response.body().getData() != null) {
                                CityDistrict cd = response.body();
                                ls.addAll(cd.getData().getQuanhuyen());
                                initAdapter();
                            } else {

                            }
                        }

                        @Override
                        public void onFailure(Call<CityDistrict> call, Throwable t) {
                            Toast.makeText(SelectDistrictActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                    Toast.LENGTH_LONG).show();
                            Log.e("aab", t.getMessage());
                        }
                    });
        }
    }

    private void initAdapter(){
        RecyclerView recyclerView = this.findViewById(R.id.city_card_container);
        ChooseCityAdapter chooseCityAdapter = new ChooseCityAdapter(this, ls);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chooseCityAdapter);

        chooseCityAdapter.setOnItemClick(cityDistrictInfo -> {
            this.cityDistrictInfo = cityDistrictInfo;
            Intent i = new Intent();
            i.putExtra("district", cityDistrictInfo);
            setResult(22, i);
            SelectDistrictActivity.this.finish();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(22, null);
    }
}