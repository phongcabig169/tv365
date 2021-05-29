package com.example.tv365.Recruiters.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.tv365.R;
import com.example.tv365.Recruiters.fragment.HomeRecruiters_Fragment;
import com.example.tv365.Recruiters.fragment.Job_Info_fragment;
import com.example.tv365.Recruiters.fragment.MapsFragment;
import com.example.tv365.Recruiters.fragment.RecruitersHistory_Fragment;
import com.example.tv365.Recruiters.fragment.RecruitersProfile_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ScreenManagement_Activity extends AppCompatActivity {
    private BottomNavigationView navigation;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getWindow();
//            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        }
        setContentView(R.layout.activity_screen_management);

        initView();

        fragment = new HomeRecruiters_Fragment();
        loadFragment(fragment);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void initView() {
        navigation = (BottomNavigationView) findViewById(R.id.nav_container);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_IconHome:
                    fragment = new HomeRecruiters_Fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_IconHistory:
                    fragment = new RecruitersHistory_Fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_IconNews:
                    fragment = new Job_Info_fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_IconMaps:
                    fragment = new MapsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_IconProfile:
                    fragment = new RecruitersProfile_Fragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_left_to_right);
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}