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

public class CandidateNewsTypicalFragment extends Fragment {

    private View view;
    private RecyclerView recyclerViewTypical;
    private CandidateNewsTypicalAdapter candidateNewsTypicalAdapter;
    private ArrayList<CandidateTypicalNews> candidateTypicalNewsArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_candidate_news_typical, container, false);

        mapping();
        getDataTypical();
        initViewTypical();

        return view;

    }

    private void initViewTypical() {
        candidateNewsTypicalAdapter = new CandidateNewsTypicalAdapter(getActivity(), candidateTypicalNewsArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recyclerViewTypical.setLayoutManager(linearLayoutManager);
        recyclerViewTypical.setAdapter(candidateNewsTypicalAdapter);
    }

    private void getDataTypical() {
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
        recyclerViewTypical = view.findViewById(R.id.recyclerviewTypical);
    }
}