package com.example.tv365.Recruiters.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.tv365.R;
import com.example.tv365.Recruiters.adapter.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class RecruitersHistory_Fragment extends Fragment {
    private View view;
    private ViewPager pager;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = LayoutInflater.from(inflater.getContext()).inflate(R.layout.recruiters_history, container, false);

        initView();
        ViewPagerAndTabLayout();
        SetSpaceTabLayout();

        return view;
    }

    private void SetSpaceTabLayout() {
        int betweenSpace = 50;
        ViewGroup slidingTabStrip = (ViewGroup) tabLayout.getChildAt(0);

        for (int i = 0; i < slidingTabStrip.getChildCount() - 1; i++) {
            View v = slidingTabStrip.getChildAt(i);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.rightMargin = betweenSpace;
        }
    }

    private void initView() {
        pager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
    }

    private void ViewPagerAndTabLayout() {
        PagerAdapter adapter = new PagerAdapter(getActivity().getSupportFragmentManager());

        adapter.AddFragment(new CandidateSeen_Fragment(), "Đã xem");
        adapter.AddFragment(new CandidateSave_Fragment(), "Đã lưu");
        adapter.AddFragment(new CandidateSubmitted_Fragment(), "Đã nộp");

        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
    }

}
