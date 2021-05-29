package com.example.tv365.init.sharedPref;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    int PRIVATE_MODE = 0;

    public static final String PREF_FIRST_START = "welcome to job365.net";
    public static final String IS_FIRST_TIME_LAUNCH = "IsFirstTime";

    @SuppressLint("CommitPrefEdits")
    public SharedPref (Context context, String sharedName){
        this.context = context ;
        pref = context.getSharedPreferences(sharedName, PRIVATE_MODE);
        editor = pref.edit();
    }

    public boolean isFirstTimeLaunch(){
        return  pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setFirstTimeLaunch(boolean b) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, b);
        editor.commit();
    }


}
