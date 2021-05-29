package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.media.Image;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tv365.R;

public class UpdateAcademicActivity extends AppCompatActivity {

    private EditText editDayStart , editDayEnd;

    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_academic);

        initView();
        initAction();
    }

    private void initView(){
        editDayEnd = this.findViewById(R.id.edit_day_end);
        editDayStart = this.findViewById(R.id.edit_day_start);

        btnBack = this.findViewById(R.id.back_arrow);

    }

    @SuppressLint("SetTextI18n")
    private void initAction(){
        editDayStart.setOnClickListener(v -> {
            new DatePickerDialog(this,
                    (view, year, month, dayOfMonth) -> editDayStart
                            .setText(dayOfMonth + "/" + (month + 1) + "/" + year),2000, 1, 1)
            .show();

        });

        editDayEnd.setOnClickListener(v -> new DatePickerDialog(this,
                (view, year, month, dayOfMonth) ->
                        editDayEnd
                        .setText(dayOfMonth + "/" + (month + 1) + "/" + year),2000, 1, 1)
                            .show());

        btnBack.setOnClickListener(v -> UpdateAcademicActivity.this.onBackPressed());
    }
}