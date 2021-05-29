package com.example.tv365.fragment;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tv365.R;
import com.example.tv365.adapter.CandidateTopEmployerAdapter;
import com.example.tv365.helper.FixedSpeedScroller;
import com.example.tv365.model.Employer;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TopEmployerFragment extends Fragment {
    private View view;
    private CandidateTopEmployerAdapter candidateTopEmployerAdapter;
    private ArrayList<Employer> employerArrayList;
    private ViewPager2 viewPager2TopEmployer;
    private Handler sliderHandler = new Handler();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top_employer, container, false);
        // anh muon em giup gi
        // em xem giúp a cái viewpager2
        // nó load bị giật ấy
        // ý anh là chuyển tab bị giật à
        // đúng rồi em
        // a code o dau

        mapping();
        getDataTopEmployer();
        initView();

        return view;
    }

    private void getDataTopEmployer() {
        employerArrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            employerArrayList.add(new Employer(i, "",  "Công ty CP Thanh toán Hưng Hà"));
        }
    }

    private void initView() {
        candidateTopEmployerAdapter = new CandidateTopEmployerAdapter(viewPager2TopEmployer, employerArrayList);
        viewPager2TopEmployer.setAdapter(candidateTopEmployerAdapter);
        viewPager2TopEmployer.setClipToPadding(false);
        viewPager2TopEmployer.setClipChildren(false);
        viewPager2TopEmployer.setOffscreenPageLimit(3);
        viewPager2TopEmployer.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(50));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        // cho này em, lúc tự chuyển nó ko được mượt ấy, cứ giật giật
        // a build máy thật chưa
        // a thử rồi
        // để e xem
        // anh đẩy lên git rồi gửi em lên git, em kéo về máy em check cho nhanh, xem qua teamview màn hình bị giật ý
        // ok e
        


        try {
            Field mScroller;
            mScroller = ViewPager2.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            Interpolator sInterpolator = new AccelerateInterpolator();
            FixedSpeedScroller scroller = new FixedSpeedScroller(viewPager2TopEmployer.getContext(), sInterpolator);
            //scroller.setFixedDuration(5000);
            mScroller.set(viewPager2TopEmployer, scroller);
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }

        viewPager2TopEmployer.setPageTransformer(compositePageTransformer);
        viewPager2TopEmployer.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 2000);
            }
        });

    }

    private void mapping() {
        viewPager2TopEmployer = view.findViewById(R.id.viewPager2TopEmployer);
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2TopEmployer.setCurrentItem(viewPager2TopEmployer.getCurrentItem() + 1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        //sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        //sliderHandler.postDelayed(sliderRunnable, 2000);
    }
}
