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
import com.example.tv365.Recruiters.adapter.CandidateSave_Adapter;
import com.example.tv365.Recruiters.model.NewsCandidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateSave_Fragment extends Fragment {
    private View view;
    private RecyclerView rcCandiSave;
    private List<NewsCandidate> candidateListSave;
    private CandidateSave_Adapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(inflater.getContext()).inflate(R.layout.candidate_save, container, false);

        initView();
        recyListNewsCandidate();

        return view;
    }

    private void initView() {
        rcCandiSave = view.findViewById(R.id.rcSaveCandi_CandidateSeen);
    }

    private void recyListNewsCandidate() {
        candidateListSave = new ArrayList<NewsCandidate>();
        //Tự phát sinh 6 dữ liệu mẫu
        for (int i = 0; i <= 5; i++) {
            candidateListSave.add(new NewsCandidate());
        }

        adapter = new CandidateSave_Adapter(getContext(), candidateListSave);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcCandiSave.setAdapter(adapter);
        rcCandiSave.setLayoutManager(linearLayoutManager);
    }
}
