package com.example.tv365.Recruiters.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tv365.R;
import com.google.android.material.textfield.TextInputEditText;

public class ChangePass_Recruiters extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText edtPass, edtNewPass, edtReNewPass;
    private Button btnChangePass;
    private ImageView imgBack;
    private String strPass, strNewPass, strReNewpass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_recruiters_pass);
        initView();

        btnChangePass.setOnClickListener(this);
        imgBack.setOnClickListener(this);

        strPass = edtPass.getText().toString();
        strNewPass = edtNewPass.getText().toString();
        strReNewpass = edtReNewPass.getText().toString();


    }

    private void validateForm() {
        if (strPass.isEmpty()){
            Toast.makeText(this, "Vui lòng nhập mật khẩu cũ!", Toast.LENGTH_SHORT).show();
        }else if (strNewPass.isEmpty()){
            Toast.makeText(this, "Vui lòng nhập mật khẩu mới!", Toast.LENGTH_SHORT).show();
        }else if (strNewPass.length() <= 5){
            Toast.makeText(this, "Mật khẩu mới nhập tối thiểu 6 ký tự!", Toast.LENGTH_SHORT).show();
        }else if (!strReNewpass.equalsIgnoreCase(strPass)){
            Toast.makeText(this, "Mật khẩu mới nhập lại không khớp!", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        edtPass = findViewById(R.id.edtPass_ChangeRecruitersPass);
        edtNewPass = findViewById(R.id.edtNewPass_ChangeRecruitersPass);
        edtReNewPass = findViewById(R.id.edtReNewPass_ChangeRecruitersPass);
        btnChangePass = findViewById(R.id.btnChangePass_ChangeRecruitersPass);
        imgBack = findViewById(R.id.imgBack_ChangeRecruitersPass);
    }

    @Override
    public void onClick(View v) {
        if (btnChangePass.getId() == v.getId()){
            validateForm();
        }else if (imgBack.getId() == v.getId()){
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        evenBack();
    }

    private void evenBack() {
        finish();
    }
}
