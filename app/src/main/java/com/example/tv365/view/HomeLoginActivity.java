package com.example.tv365.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tv365.R;
import com.example.tv365.fragment.ChooseBranchFragment;
import com.example.tv365.model.init.Gender.Gender;

public class HomeLoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_login);

        initFragment();
    }

    private void initFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.login_container,new ChooseBranchFragment(),null)
                .commit();
    }
}