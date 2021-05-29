package com.example.tv365.Recruiters.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tv365.R;

public class Update_Reference_Person_Recruiters extends AppCompatActivity implements View.OnClickListener{
    private ImageView imgBack;
    private EditText edtName, edtPhone, edtAddress, edtEmail;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference__person__recruiters);

        initView();

        imgBack.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
    }

    private void initView() {
        imgBack = findViewById(R.id.imgBack_ReferencePerson_Recruiters);
        edtName = findViewById(R.id.edtName_ReferencePerson_Recruiters);
        edtPhone = findViewById(R.id.edtPhone_ReferencePerson_Recruiters);
        edtAddress = findViewById(R.id.edtAddress_ReferencePerson_Recruiters);
        edtEmail = findViewById(R.id.etdEmail_ReferencePerson_Recruiters);
        btnUpdate = findViewById(R.id.btnUpdate_ReferencePerson_Recruiters);
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