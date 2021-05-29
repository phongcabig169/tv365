package com.example.tv365.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.adapter.CandidateDialogAdapter;

import java.util.ArrayList;
import java.util.List;

public class CandidateDialog extends Dialog {

    private final Context mContext;
    private CandidateDialogAdapter candidateDialogAdapter;
    private List<String> stringList;
    private RecyclerView recyclerviewDialogCandidate;
    private TextView tvLogout;
    private TextView tvCancel;

    public CandidateDialog(@NonNull Context context) {
        super(context);
        mContext = context;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_candidate);

        mapping();
        initView();
        eventClick();
    }

    private void initView() {
        stringList = new ArrayList<>();
        stringList.add("Trang chủ");
        stringList.add("Quản lý thông báo");
        stringList.add("Hỗ trợ trực tuyến");
        stringList.add("Thỏa thuận sử dụng");

//        candidateDialogAdapter = new CandidateDialogAdapter(mContext, stringList);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
//        recyclerviewDialogCandidate.setLayoutManager(linearLayoutManager);
//        recyclerviewDialogCandidate.setAdapter(candidateDialogAdapter);
    }

    private void eventClick() {
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void mapping() {
        recyclerviewDialogCandidate = findViewById(R.id.recyclerviewDialogCandidate);
        tvLogout = findViewById(R.id.tvLogout);
        tvCancel = findViewById(R.id.tvCancel);
    }

}
