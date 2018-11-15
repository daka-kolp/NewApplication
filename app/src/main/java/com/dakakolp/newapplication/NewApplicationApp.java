package com.dakakolp.newapplication;

import android.app.Application;
import android.content.Context;

import com.dakakolp.newapplication.managers.PrivateSharedPreferenceManager;
import com.dakakolp.newapplication.utils.ConstantManager;

public class NewApplicationApp extends Application {
    private static NewApplicationApp sNewApplicationApp;
    private PrivateSharedPreferenceManager mPrivatePreferencesManager;


    @Override
    public void onCreate() {
        super.onCreate();
        sNewApplicationApp = this;
        managersInitialization();
    }

    private void managersInitialization(){
        mPrivatePreferencesManager = new PrivateSharedPreferenceManager(
                getSharedPreferences(ConstantManager.PRIVATE_INFO_PREFERENCE, Context.MODE_PRIVATE
                ));
    }


    public static NewApplicationApp getApplicationInstance() {
        return sNewApplicationApp;
    }

    public PrivateSharedPreferenceManager getPreferenceManager() {
        return mPrivatePreferencesManager;
    }


}
