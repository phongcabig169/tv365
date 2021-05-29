package com.example.tv365.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.tv365.R;
import com.example.tv365.adapter.IntroPagerAdapter;
import com.example.tv365.init.sharedPref.SharedPref;

import static com.example.tv365.init.sharedPref.SharedPref.IS_FIRST_TIME_LAUNCH;
import static com.example.tv365.init.sharedPref.SharedPref.PREF_FIRST_START;

public class IntroActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private IntroPagerAdapter introPagerAdapter;

    private boolean isFirstTime = true;

    private int[] listLayout;

    private TextView btnSkip;

    private ImageView btnNext, dotPos;

    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        sharedPref = new SharedPref(this, PREF_FIRST_START);
        isFirstTime = sharedPref.isFirstTimeLaunch();

        if(!isFirstTime){
            launcherHome();
        }else {
            initView();
            initAction();
            changeStatusBarColor();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        sharedPref.setFirstTimeLaunch(false);
    }

    private void initView(){
        btnSkip = this.findViewById(R.id.btn_skip);
        btnNext = this.findViewById(R.id.btn_next);
        listLayout = new int[]{R.layout.intro_slide_1,R.layout.intro_slide_2,R.layout.intro_slide_3,R.layout.intro_slide_4};
        viewPager = this.findViewById(R.id.view_pager_intro);
        dotPos = this.findViewById(R.id.intro_dot);

        introPagerAdapter = new IntroPagerAdapter(this, listLayout);
        if (viewPager == null ) {
            viewPager = this.findViewById(R.id.view_pager_intro);
        }
        viewPager.setAdapter(introPagerAdapter);
    }

    private void initAction() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("TAG", "onPageSelected: " + position);
                if (position == 0){
                    btnSkip.setVisibility(View.GONE);
                }else {
                    btnSkip.setVisibility(View.VISIBLE);
                }
                changeDotPos(position + 1);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnSkip.setOnClickListener(v -> launcherHome());
    }


    private void launcherHome() {
        Intent i = new Intent(this, HomeLoginActivity.class);
        startActivity(i);
        finish();
    }


    private void changeDotPos(int pageNum){
        switch (pageNum){
            case 1: {
                dotPos.setImageResource(R.drawable.intro_dot_1);
                break;
            }
            case 2: {
                dotPos.setImageResource(R.drawable.intro_dot_2);
                break;
            }
            case 3: {
                dotPos.setImageResource(R.drawable.intro_dot_3);
                break;
            }
            case 4: {
                dotPos.setImageResource(R.drawable.intro_dot_4);
                break;
            }
        }
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}