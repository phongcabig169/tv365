package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;

import com.example.tv365.R;

public class CandidateSearchActivity extends AppCompatActivity {

    private SwitchCompat switchCompatCandidateSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_search);

        mapping();
        eventClick();
    }

    private void eventClick() {
        switchCompatCandidateSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCompatCandidateSearch.isChecked()) {

                }else {

                }
            }
        });
    }

    private void mapping() {
        switchCompatCandidateSearch = findViewById(R.id.swCandidateSearch);
    }
}