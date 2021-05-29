package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

import com.example.tv365.R;
import com.example.tv365.fragment.SelectCityFragment;
import com.example.tv365.dialog.UpdateSuccessDialog;

public class UpdateInformationProfileActivity extends AppCompatActivity {

    private EditText editDoB, editMarried, editGender, editCity;

    private DatePickerDialog datePickerDialog;

    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_information_profile);

        initView();
        initAction();
        initData();
    }

    private void initData(){
        Intent i = getIntent();
        if(i!=null) {
            Log.d("TAG", "initData: " + i.getStringExtra("city"));
            String city = i.getStringExtra("city");
            editCity.setText(city);
        }
    }

    private void initView(){
        editDoB = this.findViewById(R.id.edit_dob_profile);
        editGender = this.findViewById(R.id.edit_gender_profile);
        editMarried = this.findViewById(R.id.edit_married_status);
        editCity = this.findViewById(R.id.choose_city);
        btnUpdate = this.findViewById(R.id.btn_update);
    }

    @SuppressLint({"NewApi", "SetTextI18n"})
    private void initAction(){
        datePickerDialog = new DatePickerDialog(this,
                (view, year, month, dayOfMonth) -> editDoB
                        .setText(dayOfMonth + "/" + (month + 1) + "/" + year),2000, 1, 1);


        editDoB.setOnClickListener(v -> datePickerDialog.show());

        editMarried.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(UpdateInformationProfileActivity.this, editMarried);
            popupMenu.setGravity(Gravity.TOP);
            popupMenu.setOnMenuItemClickListener(item -> {
                editMarried.setText(item.getTitle());
                return false;
            });

            popupMenu.inflate(R.menu.popup_married_status);
            popupMenu.show();
        });

        editGender.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(UpdateInformationProfileActivity.this,editGender);
            popupMenu.setGravity(Gravity.TOP);
            popupMenu.setOnMenuItemClickListener(item -> {
                editGender.setText(item.getTitle());
                return false;
            });

            popupMenu.inflate(R.menu.popup_gender);
            popupMenu.show();
        });

        editCity.setOnClickListener(v -> {
            SelectCityFragment selectCityFragment = new SelectCityFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack("chooser")
                    .replace(R.id.select_spinner_container, selectCityFragment, null)
                    .commit();

            selectCityFragment.setItemClick(value -> {
                editCity.setText(value);
                onBackPressed();
            });
        });


        btnUpdate.setOnClickListener(v-> {
            UpdateSuccessDialog updateSuccessDialog = new UpdateSuccessDialog(UpdateInformationProfileActivity.this);
            updateSuccessDialog.show();
        });
    }
}