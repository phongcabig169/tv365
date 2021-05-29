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

import java.util.ArrayList;
import java.util.List;

public class JobIncludeFragment extends Fragment {

    private View rootView;

    private List<String> list = new ArrayList<String>();

    private RecyclerView recyclerView;

    private FrameLayout frameLayout;

    public static JobIncludeFragment newInstance(int page, String title) {
        JobIncludeFragment fragmentFirst = new JobIncludeFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_job_included, container, false);
        frameLayout = rootView.findViewById(R.id.frame_on_null_item);
        int size = 3;
        if(size >0){
            frameLayout.setVisibility(View.GONE);
        }
        recyclerView = rootView.findViewById(R.id.candidate_manager_job_container);
        CandidateManagerJobAdapter candidateJobAdapter = new CandidateManagerJobAdapter(getActivity(),3);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(candidateJobAdapter);

        return rootView;

    }
}
