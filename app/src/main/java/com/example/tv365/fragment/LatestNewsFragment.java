package com.example.tv365.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tv365.R;
import com.example.tv365.adapter.CandidateNewsTypicalAdapter;
import com.example.tv365.model.CandidateTypicalNews;

import java.util.ArrayList;

public class LatestNewsFragment extends Fragment {

    private View view;
    private CandidateNewsTypicalAdapter candidateNewsTypicalAdapter;
    private ArrayList<CandidateTypicalNews> candidateTypicalNewsArrayList;
    private RecyclerView recyclerViewLatest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_latest_news, container, false);

        mapping();
        getDataLatest();
        initViewLatest();

        return view;
    }

    private void initViewLatest() {
        candidateNewsTypicalAdapter = new CandidateNewsTypicalAdapter(getActivity(), candidateTypicalNewsArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recyclerViewLatest.setLayoutManager(linearLayoutManager);
        recyclerViewLatest.setAdapter(candidateNewsTypicalAdapter);
    }

    private void getDataLatest() {
        candidateTypicalNewsArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            candidateTypicalNewsArrayList.add(new CandidateTypicalNews(i, "",
                    "Dấu Giáp Lai là gì?",
                    "Trên giấy tờ, tài liệu quan trọng bạn thường thấy có dấu giáp lai đỏ",
                    "Trương Diệp Chi",
                    " - 05/01/2020"));
        }
    }

    private void mapping() {
        recyclerViewLatest = view.findViewById(R.id.recyclerviewLatest);

    }
}