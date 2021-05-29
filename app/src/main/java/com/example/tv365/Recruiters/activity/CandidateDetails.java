package com.example.tv365.Recruiters.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.Recruiters.adapter.CandidateSeen_Adapter;
import com.example.tv365.Recruiters.model.NewsCandidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateDetails extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rcSimilar;
    private List<NewsCandidate> candidateListSimilar;
    private CandidateSeen_Adapter adapter;
    private ImageView imgBack, imgAvatar;
    private TextView tvName, tvJob, tvAddress,tvUpdate_Date, tvView, tvProfileCode, tvDateBirth, tvGender, tvMarital, tvCareer, tvLocation, tvExp, tvForwork, tvLevel, tvSalary, tvPhone, tvCareerGoals, tvPersonaSkills, tvWorkExp, tvEdu;
    private Button btnSave, btnApply;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.candidate_details);

        initView();
        recySimilarCandidates();

        imgBack.setOnClickListener(this);

    }

    private void initView() {
        imgBack = findViewById(R.id.imgBack_CandidateDetails);
        rcSimilar = findViewById(R.id.rcSimilarCandidates_CandidateDetails);
    }

    private void recySimilarCandidates() {
        candidateListSimilar = new ArrayList<>();
        //Tự phát sinh 6 dữ liệu mẫu
        for (int i = 0; i <= 5; i++) {
            candidateListSimilar.add(new NewsCandidate());
        }

        adapter = new CandidateSeen_Adapter(this, candidateListSimilar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcSimilar.setAdapter(adapter);
        rcSimilar.setLayoutManager(linearLayoutManager);
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
