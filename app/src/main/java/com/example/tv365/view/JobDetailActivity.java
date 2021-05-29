package com.example.tv365.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.tv365.R;
import com.example.tv365.dialog.SuccessSubmissionDialog;

public class JobDetailActivity extends AppCompatActivity {

    private Toolbar toolbarJobDetail;
    private TextView tvApplyJobDetail;
    private TextView tvSaveJobDetail;
    private SuccessSubmissionDialog successSubmissionDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        mapping();
        actionToolbar();
        eventClick();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void eventClick() {
        tvApplyJobDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFeedbackDialog();
//                successSubmissionDialog = new SuccessSubmissionDialog(JobDetailActivity.this, "");
//                successSubmissionDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//                successSubmissionDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                successSubmissionDialog.show();
            }
        });
    }

    private void actionToolbar() {
        setSupportActionBar(toolbarJobDetail);
        toolbarJobDetail.setNavigationIcon(R.drawable.arrow_left_blue);
//        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#0E7DC2'>Chi tiết việc làm</font>"));
    }

    private void mapping() {
        toolbarJobDetail = findViewById(R.id.toolbarJobDetail);
        tvApplyJobDetail = findViewById(R.id.tvApplyJobDetail);
        tvSaveJobDetail = findViewById(R.id.tvSaveJobDetail);

    }

    private void openFeedbackDialog(){
        successSubmissionDialog = new SuccessSubmissionDialog(JobDetailActivity.this, "");
        Window window = successSubmissionDialog.getWindow();
        if (window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        window.setAttributes(windowAttributes);

        successSubmissionDialog.setCancelable(true);

        successSubmissionDialog.show();
    }
}