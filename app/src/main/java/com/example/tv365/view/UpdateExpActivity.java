package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tv365.R;

public class UpdateExpActivity extends AppCompatActivity {

    private ImageView btnBack;

    private EditText editDayStart , editDayEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_exp);

        initView();
        initAction();
    }

    private void initView(){
        btnBack = this.findViewById(R.id.back_arrow);
        editDayEnd = this.findViewById(R.id.edit_day_end);
        editDayStart = this.findViewById(R.id.edit_day_start);

    }

    @SuppressLint("SetTextI18n")
    private void initAction(){
        btnBack.setOnClickListener(v ->
                UpdateExpActivity.this.onBackPressed());


        editDayStart.setOnClickListener(v -> new DatePickerDialog(this,
                (view, year, month, dayOfMonth) -> editDayStart
                        .setText(dayOfMonth + "/" + (month + 1) + "/" + year),2000, 1, 1)
                .show());

        editDayEnd.setOnClickListener(v -> new DatePickerDialog(this,
                (view, year, month, dayOfMonth) -> editDayEnd
                        .setText(dayOfMonth + "/" + (month + 1) + "/" + year),2000, 1, 1)
                .show());
    }
}