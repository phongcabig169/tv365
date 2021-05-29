package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.tv365.R;
import com.example.tv365.dialog.UpdateSuccessDialog;

public class UpdateDesireJobProfileActivity extends AppCompatActivity {

    private Button btnUpdate;

    private ImageView btnBack;

    private EditText editWorkRank , editSalary, editWorkExp, editWorkType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_desire_job_profile);

        initView();
        initAction();
    }

    private void initView(){
        btnBack = this.findViewById(R.id.back_arrow);
        btnUpdate = this.findViewById(R.id.btn_update);
        editWorkRank = this.findViewById(R.id.choose_work_rank);
        editSalary = this.findViewById(R.id.choose_salary);
        editWorkType = this.findViewById(R.id.choose_job_type);
        editWorkExp = this.findViewById(R.id.choose_work_exp);
    }

    @SuppressLint("NewApi")
    private void initAction(){
        btnBack.setOnClickListener(v ->
                UpdateDesireJobProfileActivity.this.onBackPressed());

        btnUpdate.setOnClickListener(v ->
                new UpdateSuccessDialog(UpdateDesireJobProfileActivity.this).show());

        editWorkRank.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(UpdateDesireJobProfileActivity.this, editWorkRank);
            popupMenu.inflate(R.menu.popup_work_rank);
            popupMenu.setGravity(Gravity.CENTER);
            popupMenu.setOnMenuItemClickListener(item -> {
                editWorkRank.setText(item.getTitle());
                return false;
            });
            popupMenu.show();
        });

        editSalary.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(UpdateDesireJobProfileActivity.this, editSalary);
            popupMenu.inflate(R.menu.popup_salary);
            popupMenu.setOnMenuItemClickListener(item -> {
                editSalary.setText(item.getTitle());
                return false;
            });
            popupMenu.show();
        });

        editWorkType.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(UpdateDesireJobProfileActivity.this, editWorkType);
            popupMenu.inflate(R.menu.popup_work_type);
            popupMenu.setOnMenuItemClickListener(item -> {
                editWorkType.setText(item.getTitle());
                return false;
            });
            popupMenu.show();
        });

        editWorkExp.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(UpdateDesireJobProfileActivity.this, editWorkExp);
            popupMenu.inflate(R.menu.popup_work_exp);
            popupMenu.setOnMenuItemClickListener(item -> {
                editWorkExp.setText(item.getTitle());
                return false;
            });
            popupMenu.show();
        });

    }
}