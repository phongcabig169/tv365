package com.example.tv365.view;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.tv365.R;
import com.example.tv365.adapter.ViewPagerAdapterCandidate;
import com.example.tv365.fragment.CandidateManagerJobFragment;
import com.example.tv365.fragment.CandidateNewsFragment;
import com.example.tv365.fragment.HomeCandidateFragment;
import com.example.tv365.fragment.UVProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPagerCandidate;
    private ViewPagerAdapterCandidate viewPagerAdapterCandidate;
    private BottomNavigationView bottomNavigationView;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        initView();
    }

    private void initView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeCandidateFragment());
        fragmentList.add(new CandidateManagerJobFragment());
        fragmentList.add(new CandidateNewsFragment());
        fragmentList.add(new HomeCandidateFragment());
        fragmentList.add(new UVProfileFragment());

        viewPagerAdapterCandidate = new ViewPagerAdapterCandidate(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragmentList);
        viewPagerCandidate.setOffscreenPageLimit(4);
        viewPagerCandidate.setAdapter(viewPagerAdapterCandidate);

        viewPagerCandidate.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_seen).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_news).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_map).setChecked(true);
                        break;
                    case 4:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_profile).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        viewPagerCandidate.setCurrentItem(0);
                        break;
                    case R.id.navigation_seen:
                        viewPagerCandidate.setCurrentItem(1);
                        break;
                    case R.id.navigation_news:
                        viewPagerCandidate.setCurrentItem(2);
                        break;
                    case R.id.navigation_map:
                        viewPagerCandidate.setCurrentItem(3);
                        break;
                    case R.id.navigation_profile:
                        viewPagerCandidate.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });
    }

    private void mapping() {
        viewPagerCandidate = findViewById(R.id.viewPagerCandidate);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}