package com.example.tv365.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tv365.R;

import java.util.Objects;

public class ChooseBranchFragment extends Fragment {

    private Button btnCandidate, btnEmployer;

    private View rootView;

    public ChooseBranchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_choose_branch, container, false);
        initView();
        initAction();
        return rootView;
    }


    private void initView(){
        btnCandidate = rootView.findViewById(R.id.btn_candidate);
        btnEmployer =rootView.findViewById(R.id.btn_employer);

    }

    private void initAction(){
        btnCandidate.setOnClickListener(v -> requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.login_container, new ChooseLoginTypeFragment(), null)
                .addToBackStack("login")
                .commit());

        btnEmployer.setOnClickListener(new View.OnClickListener() {

            final LoginWithAccountFragment loginWithAccountFragment = new LoginWithAccountFragment();

            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt("code", 1);
                loginWithAccountFragment.setArguments(b);
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.login_container, loginWithAccountFragment, null)
                        .addToBackStack("login")
                        .commit();
            }
        });
    }
}