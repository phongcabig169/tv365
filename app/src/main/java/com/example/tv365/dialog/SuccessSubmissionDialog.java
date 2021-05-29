package com.example.tv365.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tv365.R;

public class SuccessSubmissionDialog extends Dialog implements View.OnClickListener {
    private Context context;

    private String note;

    private TextView txtVal;

    private ImageButton imgButtonSuccess;

    public SuccessSubmissionDialog(@NonNull Context context, String note) {
        super(context);
        this.note = note;
        this.context = context;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_successful_submission);

        imgButtonSuccess = this.findViewById(R.id.imgButtonSuccess);
        imgButtonSuccess.setOnClickListener(this);

        txtVal = this.findViewById(R.id.tvJobLocation);
        if(note != null){
            txtVal.setText(note);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imgButtonSuccess){
            dismiss();
        }
    }
}
