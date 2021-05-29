package com.example.tv365.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tv365.R;
import com.example.tv365.adapter.CandidateNewsBannerAdapter;
import com.example.tv365.model.CandidateNews;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;

public class CandidateNewsBannerFragment extends Fragment {
    private View view;
    private ViewPager2 viewPager2RN;
    private CandidateNewsBannerAdapter candidateNewsBannerAdapter;
    private ArrayList<CandidateNews> candidateNewsArrayList;
    private WormDotsIndicator dotsIndicator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_candidate_news_banner, container, false);

        mapping();
        getDataRN();
        initView();

        return view;
    }

    private void initView() {
        candidateNewsBannerAdapter = new CandidateNewsBannerAdapter(getActivity(), candidateNewsArrayList);
        viewPager2RN.setAdapter(candidateNewsBannerAdapter);
        dotsIndicator.setViewPager2(viewPager2RN);
    }

    private void getDataRN() {
        candidateNewsArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            candidateNewsArrayList.add(new CandidateNews(i, "VIỆC LÀM - TIN TUYỂN DỤNG", "Tìm thấy công việc phù hợp trong vài phút", "Tổng thống Mỹ", "", "1 việc"));
        }
    }


    private void mapping() {
        viewPager2RN = view.findViewById(R.id.viewPager2RN);
        dotsIndicator = view.findViewById(R.id.dots_indicator);
    }
}
