package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tv365.R;

public class CompleteProfileActivity extends AppCompatActivity {

    private EditText editDoBProfile;

    private ImageView btnBack;

    private TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile);

        initView();
        initAction();
    }

    private void initView(){
        editDoBProfile = this.findViewById(R.id.edit_dob_profile);
        btnBack = this.findViewById(R.id.img_arrow_back);
        txtLogin = this.findViewById(R.id.txt_login);

    }

    private void initAction(){
        editDoBProfile.setOnClickListener(v -> {

        });

        btnBack.setOnClickListener(v -> CompleteProfileActivity.this.finish());

        txtLogin.setOnClickListener(v ->{
            Intent i = new Intent(CompleteProfileActivity.this, HomeLoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(new Intent(i));

        });
    }

}