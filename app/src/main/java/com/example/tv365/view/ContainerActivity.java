package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tv365.R;
import com.example.tv365.fragment.CandidateManagerJobFragment;
import com.example.tv365.fragment.JobManagerFragment;
import com.example.tv365.fragment.UVProfileFragment;

public class ContainerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_container, new CandidateManagerJobFragment(), null)
//                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new UVProfileFragment(), null)
                .commit();
    }
}