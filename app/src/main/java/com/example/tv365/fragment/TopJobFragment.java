package com.example.tv365.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.tv365.R;
import com.example.tv365.adapter.CandidateTopJobAdapter;
import com.example.tv365.model.Job;

import java.util.ArrayList;

public class TopJobFragment extends Fragment {
    private View view;
    private CandidateTopJobAdapter topJobAdapter;
    private RecyclerView recyclerviewTopJob;
    private ArrayList<Job> jobArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top_job, container, false);

        mapping();
        getDataCandidateBanner();
        initViewPager();
        return view;
    }

    private void getDataCandidateBanner() {
        jobArrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            jobArrayList.add(new Job(i, "", "Nhân viên Kinh doanh", "Công ty CP Thanh toán Hưng Hà", "Hà Nội"));
        }
    }

    private void initViewPager() {
        topJobAdapter = new CandidateTopJobAdapter(getActivity(), jobArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recyclerviewTopJob.setLayoutManager(linearLayoutManager);
        recyclerviewTopJob.setAdapter(topJobAdapter);

    }

    private void mapping() {
        recyclerviewTopJob = view.findViewById(R.id.recyclerviewTopJob);
    }
}
