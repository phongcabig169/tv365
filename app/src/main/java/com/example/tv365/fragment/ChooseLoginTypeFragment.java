package com.example.tv365.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.tv365.R;

import java.util.Objects;

public class ChooseLoginTypeFragment extends Fragment {

    private Button btnLogin, btnLoginNoAccount;

    private View rootView;

    public ChooseLoginTypeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_choose_login_type, container, false);
        initView();
        initAction();
        return rootView;
    }

    private void initView(){
        btnLogin = rootView.findViewById(R.id.btn_login);
        btnLoginNoAccount =rootView.findViewById(R.id.btn_login_without_acc);

    }


    private void initAction(){
        btnLoginNoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            final LoginWithAccountFragment loginWithAccountFragment = new LoginWithAccountFragment();
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt("code", 2);
                loginWithAccountFragment.setArguments(b);
                Objects.requireNonNull(getActivity()).getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.login_container, loginWithAccountFragment, null)
                        .addToBackStack("login")
                        .commit();
            }
        });
    }
}