package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tv365.R;
import com.example.tv365.adapter.CandidateGetNotifyAdapter;
import com.example.tv365.model.CandidateGetNotify;

import java.util.ArrayList;

public class NotificationManagementActivity extends AppCompatActivity {

    private CandidateGetNotifyAdapter getNotifyAdapter;
    private ArrayList<CandidateGetNotify> getNotifyArrayList;
    private RecyclerView recyclerViewNM;
    private Toolbar toolbarGetNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_management);

        mapping();
        actionToolbar();
        getDataNM();
        initViewNM();
    }

    private void actionToolbar() {
        setSupportActionBar(toolbarGetNotify);
        getSupportActionBar();
        toolbarGetNotify.setNavigationIcon(R.drawable.arrow_left_white);
    }

    private void initViewNM() {
        getNotifyAdapter = new CandidateGetNotifyAdapter(NotificationManagementActivity.this, getNotifyArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NotificationManagementActivity.this, RecyclerView.VERTICAL, false);
        recyclerViewNM.setLayoutManager(linearLayoutManager);
        recyclerViewNM.setAdapter(getNotifyAdapter);
    }

    private void getDataNM() {
        getNotifyArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            getNotifyArrayList.add(new CandidateGetNotify(i, "", "Bạn đã ứng tuyển vị trí NV Kinh Doanh tại Hà Nội. Xem chi tiết!"));
        }
    }

    private void mapping() {
        recyclerViewNM = findViewById(R.id.recyclerviewNM);
        toolbarGetNotify = findViewById(R.id.toolbarGetNotify);
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
}