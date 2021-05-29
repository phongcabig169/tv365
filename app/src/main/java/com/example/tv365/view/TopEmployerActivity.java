package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.tv365.R;
import com.example.tv365.adapter.CandidateJobAdapter;
import com.example.tv365.adapter.SameJobCompanyAdapter;
import com.example.tv365.model.CandidateJob;

import java.util.ArrayList;

public class TopEmployerActivity extends AppCompatActivity {

    private Toolbar toolbarTE;
    private RecyclerView recyclerViewTE;
    private SameJobCompanyAdapter sameJobCompanyAdapter;
    private ArrayList<CandidateJob> candidateJobArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_employer);

        mapping();
        actionToolbar();
        getDataTopEmployer();
        initView();
    }

    private void initView() {
        sameJobCompanyAdapter = new SameJobCompanyAdapter(this, candidateJobArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerViewTE.setLayoutManager(linearLayoutManager);
        recyclerViewTE.setAdapter(sameJobCompanyAdapter);

    }

    private void getDataTopEmployer() {
        candidateJobArrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            candidateJobArrayList.add(new CandidateJob(i, "Tuyển công nhân xây dựng", "Công ty CP Thanh toán Hưng Hà", "Hà Nội", "Cập nhật: 08/05/2021", "6 - 7 triệu"));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void actionToolbar() {
        setSupportActionBar(toolbarTE);
        getSupportActionBar();
        toolbarTE.setNavigationIcon(R.drawable.arrow_left_white);
    }

    private void mapping() {
        toolbarTE = findViewById(R.id.toolbarTopEmployer);
        recyclerViewTE = findViewById(R.id.recyclerviewTE);
    }
}