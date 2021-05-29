package com.example.tv365.Recruiters.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.Recruiters.activity.See_Candidates_NearYou;
import com.example.tv365.Recruiters.activity.WebCreateCVActivity;
import com.example.tv365.Recruiters.adapter.LastestNews_Adapter;
import com.example.tv365.Recruiters.model.LastestNews;

import java.util.ArrayList;
import java.util.List;

public class Job_Info_fragment extends Fragment implements View.OnClickListener {
    private View view;
    private ImageView imgCreateCv, imgJobMap;
    private RecyclerView rcRepresentative;
    private RecyclerView rcLatestNews;
    private List<LastestNews> lastestNewsList;
    private LastestNews_Adapter lastestNewsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(inflater.getContext()).inflate(R.layout.job_information, container, false);

        initView();
        RecyListLastestNews();
        RecyListRepresentative();

        imgCreateCv.setOnClickListener(this);
        imgJobMap.setOnClickListener(this);

        return view;
    }

    private void initView() {
        rcRepresentative = view.findViewById(R.id.rcRepresentative_JobInfo);
        rcLatestNews = view.findViewById(R.id.rcLatestNew_JobInfo);
        imgCreateCv = view.findViewById(R.id.imgBgCreateCv_JobInfo);
        imgJobMap = view.findViewById(R.id.imgJobMap_JobInfo);
    }

    private void RecyListLastestNews() {
        lastestNewsList = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            lastestNewsList.add(new LastestNews());
        }
        lastestNewsAdapter = new LastestNews_Adapter(getContext(), lastestNewsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcLatestNews.setAdapter(lastestNewsAdapter);
        rcLatestNews.setLayoutManager(linearLayoutManager);

    }

    private void RecyListRepresentative() {
        lastestNewsList = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            lastestNewsList.add(new LastestNews());
        }
        lastestNewsAdapter = new LastestNews_Adapter(getContext(), lastestNewsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcRepresentative.setAdapter(lastestNewsAdapter);
        rcRepresentative.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onClick(View v) {
        if (imgCreateCv.getId() == v.getId()) {
            getContext().startActivity(new Intent(getActivity(), WebCreateCVActivity.class));
        } else if (imgJobMap.getId() == v.getId()) {
            getContext().startActivity(new Intent(getActivity(), See_Candidates_NearYou.class));
        }
    }
}
