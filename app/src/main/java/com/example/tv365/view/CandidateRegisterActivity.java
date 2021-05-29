package com.example.tv365.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tv365.R;
import com.example.tv365.fragment.SelectCityFragment;
import com.example.tv365.fragment.SelectWorkPlaceFragment;
import com.example.tv365.dialog.CVDialog;
import com.example.tv365.dialog.ValidateDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CandidateRegisterActivity extends AppCompatActivity {

    private Button btnNext;

    private TextInputEditText editEmail, editPass, editConfirmPass, editName, editNum, editCity,editAddress, editWorkPlace,editJob, editNameJob;

    private TextInputLayout layoutEmail, layoutPass, layoutConfirmPass, layoutName, layoutNum, layoutCity, layoutAddress, layoutWorkPlace, layoutJob, layoutNameJob;

    private CheckBox checkBox;

    private TextView txtLogin;

    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (!isTaskRoot())
        {
            String intentAction = getIntent().getAction();
            if (getIntent().hasCategory(Intent.CATEGORY_LAUNCHER) && intentAction != null && intentAction.equals(Intent.ACTION_MAIN)) {
                finish();
                return;
            }
        }
        initView();
        initAction();
        initData();
    }

    private void initView(){
        btnNext = this.findViewById(R.id.btn_next_register);

        editEmail = this.findViewById(R.id.edit_email_register);
        editPass = this.findViewById(R.id.edit_pass_register);
        editConfirmPass = this.findViewById(R.id.edit_confirm_pass_register);
        editName = this.findViewById(R.id.edit_name_register);
        editNum = this.findViewById(R.id.edit_num_register);
        editCity = this.findViewById(R.id.edit_city_register);
        editAddress = this.findViewById(R.id.edit_address_register);
        editWorkPlace = this.findViewById(R.id.edit_workplace_register);
        editNameJob = this.findViewById(R.id.edit_job_name_register);
        editJob = this.findViewById(R.id.edit_job_register);

        layoutEmail = this.findViewById(R.id.layout_email);
        layoutPass = this.findViewById(R.id.layout_pass);
        layoutConfirmPass = this.findViewById(R.id.layout_confirm_pass);

        checkBox = this.findViewById(R.id.checkbox_register);
        txtLogin = this.findViewById(R.id.txt_login);

        btnBack = this.findViewById(R.id.img_arrow_back);
    }

    private void initData(){
        Intent i = getIntent();
        if(i!=null) {
            Log.d("TAG", "initData: " + i.getStringExtra("city"));
            String city = i.getStringExtra("city");
            editCity.setText(city);
        }
    }

    private void initAction(){

        txtLogin.setOnClickListener(v -> {
            Intent i = new Intent(CandidateRegisterActivity.this, HomeLoginActivity.class);
            startActivity(i);
        });

        btnBack.setOnClickListener(v -> CandidateRegisterActivity.this.onBackPressed());

        editCity.setOnClickListener(v -> {
            SelectCityFragment selectCityFragment = new SelectCityFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack("chooser")
                    .replace(R.id.select_spinner_container, selectCityFragment, null)
                    .commit();

            selectCityFragment.setItemClick(value -> {
                editCity.setText(value);
                CandidateRegisterActivity.this.onBackPressed();
            });
        });

        editWorkPlace.setOnClickListener(v -> {
            SelectWorkPlaceFragment selectWorkPlaceFragment = new SelectWorkPlaceFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack("chooser")
                    .replace(R.id.select_spinner_container, selectWorkPlaceFragment, null)
                    .commit();

            selectWorkPlaceFragment.setItemClick(value -> {
                CandidateRegisterActivity.this.onBackPressed();
                editWorkPlace.setText(value);
            });

        });
        editJob.setOnClickListener(v -> {

        });

        btnNext.setOnClickListener(v -> {
            validateRegister();
        });
    }

    private void validateRegister(){
        boolean isDone = true;
        ValidateDialog validateDialog;
        if(editEmail.getText().toString().equals("")){
            isDone = false;
            editEmail.setError("Trường này không được bỏ trống");
        }
        if(editPass.getText().toString().equals("")){
            isDone = false;
            layoutPass.setError("Bạn chưa nhập mật khẩu");
        }
        else if(!editConfirmPass.getText().toString().equals(editPass.getText().toString())){
            isDone = false;
            layoutPass.setErrorEnabled(false);
            layoutConfirmPass.setError("Mật khẩu không khớp");
        }else layoutConfirmPass.setErrorEnabled(false);

        if(editName.getText().toString().equals("")){
            isDone = false;
            editName.setError("Trường này không được bỏ trống");

        }if(editNum.getText().toString().equals("")){
            isDone = false;
            editNum.setError("Trường này không được bỏ trống");

        }if(editAddress.getText().toString().equals("")){
            isDone = false;
            editAddress.setError("Trường này không được bỏ trống");

        }if(editNameJob.getText().toString().equals("")) {
            isDone = false;
            editNameJob.setError("Trường này không được bỏ trống");
        }

        if(isDone){
            if(editCity.getText().toString().equals("")){
                isDone = false;
                validateDialog = new ValidateDialog(this, "Bạn chưa chọn tỉnh/thành phố");
                validateDialog.show();
            }else if(editWorkPlace.getText().toString().equals("")){
                isDone = false;
                validateDialog = new ValidateDialog(this, "Bạn chưa chọn nơi làm việc");
                validateDialog.show();
            }else if(editJob.getText().toString().equals("")){
                isDone = false;
                validateDialog = new ValidateDialog(this, "Bạn chưa chọn ngành nghề");
                validateDialog.show();
            } else if(!checkBox.isChecked()){
                isDone = false;
                validateDialog = new ValidateDialog(this, "Bạn vui lòng đồng ý các quy định và điều khoản");
                validateDialog.show();
            }
        }

        if(isDone){
            CVDialog CVDialog = new CVDialog(this);
            CVDialog.show();
        }
    }

}