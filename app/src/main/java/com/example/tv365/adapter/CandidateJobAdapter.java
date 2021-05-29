package com.example.tv365.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tv365.fragment.JobIncludeFragment;
import com.example.tv365.fragment.JobSavedFragment;
import com.example.tv365.fragment.JobViewedFragment;

public class CandidateJobAdapter extends FragmentPagerAdapter {

    public CandidateJobAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{
                return JobViewedFragment.newInstance(0,"0");
            }
            case 1:{
                return JobSavedFragment.newInstance(1,"0");
            }
            case 2:{
                return JobIncludeFragment.newInstance(2,"0");
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
