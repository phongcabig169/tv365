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
import androidx.viewpager2.widget.ViewPager2;

import com.example.tv365.R;
import com.example.tv365.adapter.SuitableJobAdapter;
import com.example.tv365.model.Job;

import java.util.ArrayList;

public class SuitableJobFragment extends Fragment {
    private View view;
    private SuitableJobAdapter suitableJobAdapter;
    private ArrayList<Job> jobArrayList;
    private RecyclerView recyclerViewSJ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_suitable_job, container, false);

        mapping();
        getDataSuitableJob();
        initView();

        return view;
    }

    private void initView() {
        suitableJobAdapter = new SuitableJobAdapter(getActivity(), jobArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recyclerViewSJ.setLayoutManager(linearLayoutManager);
        recyclerViewSJ.setAdapter(suitableJobAdapter);
    }

    private void getDataSuitableJob() {
        jobArrayList = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            jobArrayList.add(new Job(i, "", "Nhân viên Kinh doanh", "Công ty CP Thanh toán Hưng Hà", "Hà Nội"));
        }
    }

    private void mapping() {
        recyclerViewSJ = view.findViewById(R.id.recyclerviewSJ);
    }
}
