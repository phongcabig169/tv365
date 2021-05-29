package com.example.tv365.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.adapter.CandidateManagerJobAdapter;

public class JobViewedFragment extends Fragment {

    private View rootView;

    private FrameLayout frameLayout;

    private RecyclerView recyclerView;

    public static JobViewedFragment newInstance(int page, String title) {
        JobViewedFragment fragmentFirst = new JobViewedFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_job_viewed, container,false);

        frameLayout = rootView.findViewById(R.id.frame_on_null_item);
        int size = 7;
        if(size >0){
            frameLayout.setVisibility(View.GONE);
        }
        recyclerView = rootView.findViewById(R.id.candidate_manager_job_container);
        CandidateManagerJobAdapter candidateJobAdapter = new CandidateManagerJobAdapter(getActivity(),size);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(candidateJobAdapter);

        return rootView;
    }

}
