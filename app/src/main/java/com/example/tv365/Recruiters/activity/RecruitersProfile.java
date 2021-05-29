package com.example.tv365.Recruiters.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tv365.R;

public class RecruitersProfile extends AppCompatActivity implements View.OnClickListener {
    private Button btnEditCompanyInfo, btnEditReferePerson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruiters_profile);

        initView();
    }

    private void initView() {
        btnEditCompanyInfo = findViewById(R.id.btnEditCompanyInfo_RecruitersProfile);
        btnEditReferePerson = findViewById(R.id.btnReferePersonEdit_RecruitersProfile);
    }

    @Override
    public void onClick(View v) {
        if (btnEditCompanyInfo.getId() == v.getId()){
            startActivity(new Intent(this, Updated_Company_Info.class));
        }else if (btnEditReferePerson.getId() == v.getId()){
            startActivity(new Intent(this, Update_Reference_Person_Recruiters.class));
        }
    }
}
