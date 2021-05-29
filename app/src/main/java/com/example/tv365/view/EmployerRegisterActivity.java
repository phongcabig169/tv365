package com.example.tv365.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tv365.R;
import com.example.tv365.init.DAO;
import com.example.tv365.model.init.Cate.CateInfo;
import com.example.tv365.model.init.City.CityDistrictInfo;
import com.google.android.material.textfield.TextInputEditText;

public class EmployerRegisterActivity extends AppCompatActivity {

    private ImageView btnBack;

    private TextInputEditText edtCity, edtDistrict, edtCate;

    private CityDistrictInfo city, district;

    private CateInfo cate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_register);

        initView();
        initAction();
    }

    private void initView() {
        btnBack = this.findViewById(R.id.img_arrow_back);

        edtCity = this.findViewById(R.id.edit_city_register);
        edtDistrict = this.findViewById(R.id.edit_district_register);
        edtCate = this.findViewById(R.id.edit_job_register);
    }

    private void initAction(){
        btnBack.setOnClickListener(v -> EmployerRegisterActivity.this.onBackPressed());

        edtCity.setOnClickListener(v -> {
            Intent i = new Intent(EmployerRegisterActivity.this, SelectCityActivity.class);
            startActivityForResult(i,11);

        });
        edtDistrict.setOnClickListener(v -> {
            if(city != null && edtCity.getText() != null && !edtCity.getText().toString().equals("")) {
                Intent i = new Intent(EmployerRegisterActivity.this, SelectDistrictActivity.class);
                i.putExtra("parent", city);
                startActivityForResult(i, 22);
            }else {
                Toast.makeText(this, "Vui lòng chọn tỉnh thành trước", Toast.LENGTH_SHORT).show();
            }
        });
        edtCate.setOnClickListener(v -> {
            Intent i = new Intent(EmployerRegisterActivity.this, SelectCateActivity.class);
            startActivityForResult(i,33);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 11){
            if(data != null) {
                city = (CityDistrictInfo) data.getSerializableExtra("city");
                edtCity.setText(city.getCitName());
            }
        }
        if(requestCode == 22){
            if(data != null) {
                district = (CityDistrictInfo) data.getSerializableExtra("district");
                edtDistrict.setText(district.getCitName());
            }
        }
        if(requestCode == 33){
            if(data != null) {
                cate = (CateInfo) data.getSerializableExtra("cate");
                edtCate.setText(cate.getCatName());
            }
        }
    }
}