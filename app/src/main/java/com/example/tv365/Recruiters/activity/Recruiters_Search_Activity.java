package com.example.tv365.Recruiters.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tv365.R;
import com.example.tv365.Recruiters.adapter.ListCandidate_SearchRecruiters_Adapters;
import com.example.tv365.Recruiters.model.NewsCandidate;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class Recruiters_Search_Activity extends AppCompatActivity implements View.OnClickListener {
    private SwitchCompat switchCompat;
    private TextView tvCancel;
    private ListView lvListSearch;
    private ArrayAdapter<CharSequence> adapter;
    private TextInputEditText edtCareer, edtProvince;
    private ImageView imgTurnBack;
    private ListCandidate_SearchRecruiters_Adapters listsearchadapters;
    private List<NewsCandidate> candidateListSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruiters__search_);

        initView();

        tvCancel.setOnClickListener(this);
        edtCareer.setOnClickListener(this);
        edtProvince.setOnClickListener(this);
        imgTurnBack.setOnClickListener(this);

    }

    private void initView() {
        switchCompat = findViewById(R.id.swcSearch_RecruitersSearch);
        tvCancel = findViewById(R.id.tvCancel_RecruitersSearch);
        lvListSearch = findViewById(R.id.lvListSearch_RecruitersSearch);
        edtCareer = findViewById(R.id.edtCareer_RecruitersSearch);
        edtProvince = findViewById(R.id.edtProvince_RecruitersSearch);
        imgTurnBack = findViewById(R.id.imgTurnBack_RecruitersSearch);
    }

    @Override
    public void onClick(View v) {
        if (tvCancel.getId() == v.getId()) {
            onBackPressed();
        } else if (edtCareer.getId() == v.getId()) {
            adapter = ArrayAdapter.createFromResource(this, R.array.strCareer_CreateRecruiters, android.R.layout.simple_list_item_1);
            lvListSearch.setAdapter(adapter);
            lvListSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String strCareer = parent.getItemAtPosition(position).toString();
                    edtCareer.setText(strCareer);
                }
            });
        } else if (edtProvince.getId() == v.getId()) {
            adapter = ArrayAdapter.createFromResource(this, R.array.strAddress_CreateRecruiters, android.R.layout.simple_list_item_1);
            lvListSearch.setAdapter(adapter);
            lvListSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String strProvince = parent.getItemAtPosition(position).toString();
                    edtProvince.setText(strProvince);
                }
            });
        } else if (imgTurnBack.getId() == v.getId()) {
            candidateListSearch = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                candidateListSearch.add(new NewsCandidate());
            }
            listsearchadapters = new ListCandidate_SearchRecruiters_Adapters(this, candidateListSearch);
            lvListSearch.setAdapter(listsearchadapters);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}