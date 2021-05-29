package com.example.tv365.config;

import android.app.ProgressDialog;

/**
 * Created by Dell Precision on 03/08/2018.
 */

public class ConfigProgressDialog {
    public static void showProgressDialog(ProgressDialog progressDialog, String message){
        if (!progressDialog.isShowing()){
            progressDialog.setMessage(message);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();
        }
    }
    public static void dismissProgressDialog(ProgressDialog progressDialog){
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
}
