package com.dakakolp.newapplication;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.dakakolp.newapplication.managers.ConstantManager;

public class NewApplicationApp extends Application {
    private static SharedPreferences sPrivatePreferences;


    @Override
    public void onCreate() {
        super.onCreate();
        sPrivatePreferences = getSharedPreferences(ConstantManager.PRIVATE_INFO_PREFERENCE, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getPrivateSharedPreferences() {
        return sPrivatePreferences;
    }
}
