package com.dakakolp.newapplication.managers;

public class DataManager {
    private static DataManager sDataManagerInstance = null;
    private PrivateSharedPreferenceManager mPreferenceManager;


    private DataManager(){
        this.mPreferenceManager = new PrivateSharedPreferenceManager();
    }

    public static DataManager getInstance(){
        if(sDataManagerInstance == null){
            sDataManagerInstance = new DataManager();
        }
        return sDataManagerInstance;
    }

    public PrivateSharedPreferenceManager getPreferenceManager() {
        return mPreferenceManager;
    }
}