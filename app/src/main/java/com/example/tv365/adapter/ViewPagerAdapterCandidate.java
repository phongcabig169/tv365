package com.example.tv365.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class ViewPagerAdapterCandidate extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public ViewPagerAdapterCandidate(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList1) {
        super(fm, behavior);
        this.fragmentList = fragmentList1;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        if (fragmentList != null){
            return fragmentList.size();
        }
        return 0;
    }
}
