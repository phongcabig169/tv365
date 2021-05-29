package com.example.tv365.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tv365.R;
import com.example.tv365.view.UpdateAcademicActivity;
import com.example.tv365.view.UpdateDesireJobProfileActivity;
import com.example.tv365.view.UpdateExpActivity;
import com.example.tv365.view.UpdateInformationProfileActivity;
import com.example.tv365.view.UpdateReferencePersonActivity;
import com.example.tv365.view.UpdateWorkSkillActivity;
import com.example.tv365.view.UpdateWorkTargetActivity;

public class DetailUVProfileFragment extends Fragment {

    private View rootView;

    private ImageView btnEditInformation;

    private Button btnDesireJob, btnTargetJob, btnWorkSkill, btnAcademic, btnExp, btnPerson;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detail_profile, container,false);
        initView();
        initAction();

        return rootView;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(){
        btnEditInformation = rootView.findViewById(R.id.edit_information_profile);
        btnDesireJob = rootView.findViewById(R.id.update_desire_job);
        btnTargetJob = rootView.findViewById(R.id.btn_update_target_job);
        btnWorkSkill = rootView.findViewById(R.id.btn_work_skill);
        btnAcademic = rootView.findViewById(R.id.btn_update_academic);
        btnExp = rootView.findViewById(R.id.btn_update_exp);
        btnPerson = rootView.findViewById(R.id.btn_update_person);

    }

    private void initAction(){
        btnEditInformation.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), UpdateInformationProfileActivity.class);
            startActivity(i);
        });

        btnDesireJob.setOnClickListener(v-> {
            Intent i = new Intent(getActivity(), UpdateDesireJobProfileActivity.class);
            startActivity(i);
        });

        btnTargetJob.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), UpdateWorkTargetActivity.class);
            startActivity(i);
        });

        btnWorkSkill.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), UpdateWorkSkillActivity.class);
            startActivity(i);
        });

        btnAcademic.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), UpdateAcademicActivity.class);
            startActivity(i);
        });
        btnExp.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), UpdateExpActivity.class);
            startActivity(i);
        });
        btnPerson.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), UpdateReferencePersonActivity.class);
            startActivity(i);
        });
    }
}
