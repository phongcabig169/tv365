package com.example.tv365.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tv365.R;
import com.example.tv365.Recruiters.activity.ScreenManagement_Activity;
import com.example.tv365.config.ConfigRetrofitApi;
import com.example.tv365.config.InterfaceAPI;
import com.example.tv365.model.Login.LoginEmployer;
import com.example.tv365.model.init.AcademiRank.AcademicRank;
import com.example.tv365.view.CandidateRegisterActivity;
import com.example.tv365.view.EmployerRegisterActivity;
import com.example.tv365.view.MainActivity;
import com.example.tv365.view.SplashActivity;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginWithAccountFragment extends Fragment {

    private View rootView;

    private Button btnLogin;

    private TextView txtForgotPass;

    private TextView txtRegister;

    private int code = 0;

    private TextInputEditText editEmail, editPass;

    private TextView error;

    public LoginWithAccountFragment() {
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

        Bundle b = getArguments();
        if(b!=null) {
            code = (int) b.get("code");
        }

        rootView = inflater.inflate(R.layout.fragment_login_with_account, container, false);
        initView();
        initAction();
        return rootView;
    }

    private void validate(){
        Intent i;
        if(code == 2) {
            i = new Intent(getActivity(), MainActivity.class);
        }else{
            i = new Intent(getActivity(), ScreenManagement_Activity.class);
        }
//        if(editEmail.getText().toString().equals("1") && editPass.getText().toString().equals("1")){
//            error.setVisibility(View.INVISIBLE);
//            startActivity(i);
//            getActivity().finish();
//        }else {
//            error.setVisibility(View.VISIBLE);
//        }
    }

    private void initView(){
        txtRegister = rootView.findViewById(R.id.txt_register);
        txtForgotPass = rootView.findViewById(R.id.txt_forgot_pass);
        btnLogin = rootView.findViewById(R.id.btn_login);
        error = rootView.findViewById(R.id.error_text);

        editEmail = rootView.findViewById(R.id.edit_email_login);
        editPass = rootView.findViewById(R.id.edit_pass_login);


    }

    private void initAction(){
        btnLogin.setOnClickListener(v -> {
            doOnEmployerLogin();
        });

        txtRegister.setOnClickListener(v -> {
            if(code == 2) {

                Intent i = new Intent(getActivity(), CandidateRegisterActivity.class);
                startActivity(i);
            }else if (code == 1){
                Intent i = new Intent(getActivity(), EmployerRegisterActivity.class);
                startActivity(i);
            }
        });
    }

    private void doOnEmployerLogin(){
        String email = "";
        String pass = "";
        if(editPass.getText()!= null && editEmail.getText()!= null) {
            email = editEmail.getText().toString();
            pass = editPass.getText().toString();
        }
        Log.d("TAG", "doOnEmployerLogin: " + email);
        Log.d("TAG", "doOnEmployerLogin: " + pass);

        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .loginEmployer("bpb75633@eoopy.com", "123456")
                .enqueue(new Callback<LoginEmployer>() {
                    @Override
                    public void onResponse(Call<LoginEmployer> call, Response<LoginEmployer> response) {
                        assert response.body() != null;
                        if (response.body().getError() == null) {
                            LoginEmployer comExp = response.body();
                            String token = comExp.getData().getToken();
                            Log.d("TAG", "login success: " + comExp.getData().getToken());
                            error.setVisibility(View.INVISIBLE);

                            startActivity(new Intent(getActivity(), MainActivity.class));
                        } else {
                            error.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginEmployer> call, Throwable t) {
                        Toast.makeText(requireActivity(), "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }
}