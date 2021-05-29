package com.example.tv365.Recruiters.fragment;

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
import com.example.tv365.Recruiters.adapter.CandidateSubmitted_Adapter;
import com.example.tv365.Recruiters.model.NewsCandidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateSubmitted_Fragment extends Fragment {
    private View view;
    private RecyclerView rcCandiSubmit;
    private List<NewsCandidate> candidateListSubmit;
    private CandidateSubmitted_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(inflater.getContext()).inflate(R.layout.candidate_submitted, container, false);

        initView();
        recyListNewsCandidate();

        return view;
    }

    private void initView() {
        rcCandiSubmit = view.findViewById(R.id.rcSubmitCandi_CandidateSubmitted);
    }

    private void recyListNewsCandidate() {
        candidateListSubmit = new ArrayList<NewsCandidate>();
        //Tự phát sinh 6 dữ liệu mẫu
        for (int i = 0; i <= 5; i++) {
            candidateListSubmit.add(new NewsCandidate());
        }

        adapter = new CandidateSubmitted_Adapter(getContext(), candidateListSubmit);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcCandiSubmit.setAdapter(adapter);
        rcCandiSubmit.setLayoutManager(linearLayoutManager);
    }
}
