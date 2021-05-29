package com.example.tv365.Recruiters.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tv365.R;

public class Updated_Company_Info extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgBack;
    private EditText edtNameComapany, edtCompanySize, edtTaxCode, edtAddress, edtProvince, edtPhone, edtWebsite, edtCompanyIntro;
    private Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updated__company__info);

        initView();

        imgBack.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

    }

    private void initView() {
        imgBack = findViewById(R.id.imgBack_UpdateCompanyInfo);
        edtNameComapany = findViewById(R.id.edtNameCompany_UpdateCompanyInfo);
        edtCompanySize = findViewById(R.id.edtCompanySize_UpdateCompanyInfo);
        edtTaxCode= findViewById(R.id.edtTaxcode_UpdateCompanyInfo);
        edtAddress = findViewById(R.id.edtTaxcode_UpdateCompanyInfo);
        edtProvince = findViewById(R.id.edtProvince_UpdateCompanyInfo);
        edtPhone = findViewById(R.id.edtPhone_UpdateCompanyInfo);
        edtWebsite = findViewById(R.id.edtWebsite_UpdateCompanyInfo);
        edtCompanyIntro = findViewById(R.id.edtCompanyIntro_UpdateCompanyInfo);
        btnUpdate = findViewById(R.id.btnUpdate_UpdateCompanyInfo);
    }

    @Override
    public void onClick(View v) {
        if (imgBack.getId() == v.getId()){
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}