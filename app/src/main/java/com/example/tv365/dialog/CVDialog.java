package com.example.tv365.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.tv365.R;
import com.example.tv365.view.CompleteProfileActivity;
import com.example.tv365.view.UploadCVActivity;

public class CVDialog extends Dialog{

    private Context context;

    private Button btnUploadCV;

    private Button btnCreateCV;

    private Button btnCompleteProfile;

    public CVDialog(@NonNull Context context) {
        super(context);
        this.context = context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.get_cv_dialog);

        btnCompleteProfile = this.findViewById(R.id.btn_complete_profile);
        btnUploadCV = this.findViewById(R.id.btn_upload_cv);
        btnCreateCV = this.findViewById(R.id.btn_create_cv);
        btnUploadCV.setOnClickListener(v -> {
            Intent i = new Intent(context, UploadCVActivity.class);
            context.startActivity(i);
            dismiss();
        });

        btnCreateCV.setOnClickListener(v -> {

        });

        btnCompleteProfile.setOnClickListener(v -> {
            Intent i = new Intent(context, CompleteProfileActivity.class);
            context.startActivity(i);
            dismiss();
        });
    }
}
