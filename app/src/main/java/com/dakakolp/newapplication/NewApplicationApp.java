package com.dakakolp.newapplication;

import android.app.Application;
import android.content.Context;

import com.dakakolp.newapplication.managers.SharedPreferenceManager;
import com.dakakolp.newapplication.utils.ConstantManager;

public class NewApplicationApp extends Application {
    private static NewApplicationApp sNewApplicationApp;
    private SharedPreferenceManager mPrivatePreferencesManager;


    @Override
    public void onCreate() {
        super.onCreate();
        sNewApplicationApp = this;
        managersInitialization();
    }

    private void managersInitialization(){
        mPrivatePreferencesManager =
                new SharedPreferenceManager(this, ConstantManager.PRIVATE_INFO_PREFERENCE, Context.MODE_PRIVATE);
    }


    public static NewApplicationApp getApplicationInstance() {
        return sNewApplicationApp;
    }

    public SharedPreferenceManager getPreferenceManager() {
        return mPrivatePreferencesManager;
    }


}
