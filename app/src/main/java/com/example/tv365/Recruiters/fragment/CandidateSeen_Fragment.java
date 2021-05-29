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
import com.example.tv365.Recruiters.adapter.CandidateSeen_Adapter;
import com.example.tv365.Recruiters.model.NewsCandidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateSeen_Fragment extends Fragment {
    private View view;
    private List<NewsCandidate> candidateListSeen;
    private CandidateSeen_Adapter adapter;
    private RecyclerView rcCandiSeen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(inflater.getContext()).inflate(R.layout.candidate_seen, container, false);

        initView();
        recyListNewsCandidate();

        return view;
    }

    private void initView() {
        rcCandiSeen = view.findViewById(R.id.rcViewCandi_CandidateSeen);
    }

    private void recyListNewsCandidate() {
        candidateListSeen = new ArrayList<NewsCandidate>();
        //Tự phát sinh 6 dữ liệu mẫu
        for (int i = 0; i <= 5; i++) {
            candidateListSeen.add(new NewsCandidate());
        }

        adapter = new CandidateSeen_Adapter(getContext(), candidateListSeen);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcCandiSeen.setAdapter(adapter);
        rcCandiSeen.setLayoutManager(linearLayoutManager);
    }
}
