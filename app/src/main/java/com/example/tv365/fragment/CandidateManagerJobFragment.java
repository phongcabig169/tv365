package com.example.tv365.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.tv365.R;
import com.example.tv365.adapter.CandidateJobAdapter;
import com.google.android.material.tabs.TabLayout;

public class CandidateManagerJobFragment extends Fragment {

    private View rootView;

    private TabLayout mTabLayout;

    private TabLayout.Tab tabViewed, tabSaved, tabSent;

    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_candidate_manager_job, container, false);

        initView();
        initAction();

        return rootView;
    }

    private void initView(){
        viewPager = rootView.findViewById(R.id.view_pager_container);
        mTabLayout = rootView.findViewById(R.id.tab_container);

        for(int i=0; i < mTabLayout.getTabCount(); i++) {
            View tab = ((ViewGroup) mTabLayout.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            p.setMargins(20, 0, 20, 0);
            tab.requestLayout();
        }


        CandidateJobAdapter candidateJobAdapter = new CandidateJobAdapter(getActivity().getSupportFragmentManager(),3);
        viewPager.setAdapter(candidateJobAdapter);
    }


    private void initAction(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.selectTab(mTabLayout.getTabAt(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
