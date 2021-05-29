package com.example.tv365.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tv365.R;
import com.example.tv365.view.CompleteProfileActivity;
import com.example.tv365.view.UploadCVActivity;

import org.w3c.dom.Text;

public class UpdateSuccessDialog extends Dialog{

    private Context context;

    private TextView ok;

    public UpdateSuccessDialog(@NonNull Context context) {
        super(context);
        this.context = context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.update_success_dialog);

        ok = this.findViewById(R.id.ok);
        ok.setOnClickListener(v -> {
            dismiss();
        });
    }
}
