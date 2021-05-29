package com.example.tv365.Recruiters.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.Recruiters.adapter.RecruimentNews_Adapter;
import com.example.tv365.Recruiters.model.RecruitmentNews;

import java.util.ArrayList;
import java.util.List;

public class Manage_RecruimentNews extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rcListRecruiment;
    private Button btnCreate;
    private ImageView imgBack;
    private List<RecruitmentNews> recruitmentNewsList;
    private RecruimentNews_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__manage_recruiment__news);

        initView();
        rcShow_RecruimentNews();

        btnCreate.setOnClickListener(this);
        imgBack.setOnClickListener(this);
    }

    private void initView() {
        rcListRecruiment = findViewById(R.id.rcListRecruiment_RecruimentNewManage);
        btnCreate = findViewById(R.id.btnCreate_RecruimentNewManage);
        imgBack = findViewById(R.id.imgBack_RecruimentNewManage);
    }

    private void rcShow_RecruimentNews() {
        recruitmentNewsList = new ArrayList<RecruitmentNews>();
        //Tự phát sinh 6 dữ liệu mẫu
        for (int i = 0; i <= 5; i++) {
            recruitmentNewsList.add(new RecruitmentNews());
        }

        adapter = new RecruimentNews_Adapter(this, recruitmentNewsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcListRecruiment.setAdapter(adapter);
        rcListRecruiment.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        if (btnCreate.getId() == v.getId()){
            startActivity(new Intent(this, Create_RecruimentNews.class));
        }else if (imgBack.getId() == v.getId()){
            evenBack();
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