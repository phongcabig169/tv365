package com.example.tv365.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tv365.R;

public class JobManagerFragment extends Fragment {


    private Button btnViewed, btnSaved, btnIncluded;

    private View rootView;

    private Fragment fragment;

    private JobViewedFragment jobViewedFragment;

    private JobIncludeFragment jobIncludeFragment;

    private JobSavedFragment jobSavedFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_job_manager, container, false);
        initView();
        initAction();
        initFragment(jobViewedFragment);

        return rootView;
    }

    private void initAction() {
        btnViewed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnViewed.setBackgroundResource(R.drawable.bg_btn_round_on_click);
                btnViewed.setTextColor(Color.WHITE);

                btnIncluded.setBackgroundResource(R.drawable.bg_btn_round_non_click);
                btnIncluded.setTextColor(getResources().getColor(R.color.blue));
                btnSaved.setBackgroundResource(R.drawable.bg_btn_round_non_click);
                btnSaved.setTextColor(getResources().getColor(R.color.blue));

                initFragment(jobViewedFragment);
            }
        });
        btnIncluded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnIncluded.setBackgroundResource(R.drawable.bg_btn_round_on_click);
                btnIncluded.setTextColor(Color.WHITE);
                btnSaved.setBackgroundResource(R.drawable.bg_btn_round_non_click);
                btnSaved.setTextColor(getResources().getColor(R.color.blue));
                btnViewed.setBackgroundResource(R.drawable.bg_btn_round_non_click);
                btnViewed.setTextColor(getResources().getColor(R.color.blue));

                initFragment(jobIncludeFragment);
            }
        });
        btnSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSaved.setBackgroundResource(R.drawable.bg_btn_round_on_click);
                btnSaved.setTextColor(Color.WHITE);

                btnIncluded.setBackgroundResource(R.drawable.bg_btn_round_non_click);
                btnIncluded.setTextColor(getResources().getColor(R.color.blue));
                btnViewed.setBackgroundResource(R.drawable.bg_btn_round_non_click);
                btnViewed.setTextColor(getResources().getColor(R.color.blue));

                initFragment(jobSavedFragment);
            }
        });
    }

    private void initFragment(Fragment fragment){
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.job_manager_container, fragment, null)
                .commit();

    }

    private void initView(){
        jobSavedFragment = new JobSavedFragment();
        jobIncludeFragment = new JobIncludeFragment();
        jobViewedFragment = new JobViewedFragment();

        btnIncluded = rootView.findViewById(R.id.btn_included);
        btnSaved = rootView.findViewById(R.id.btn_saved);
        btnViewed = rootView.findViewById(R.id.btn_viewed);

    }

}
