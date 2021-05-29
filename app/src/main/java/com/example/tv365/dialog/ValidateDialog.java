package com.example.tv365.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tv365.R;

import java.util.List;

public class ValidateDialog extends Dialog implements View.OnClickListener {

    private Context context;

    private Button btnOk;

    private String note;

    private TextView txtVal;

    public ValidateDialog(@NonNull Context context, String note) {
        super(context);
        this.note = note;
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.validate_dialog);

        btnOk = this.findViewById(R.id.btn_ok_validate);
        btnOk.setOnClickListener(this);

        txtVal = this.findViewById(R.id.validate_text);
        if(note != null){
            txtVal.setText(note);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_ok_validate){
            dismiss();
        }
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
