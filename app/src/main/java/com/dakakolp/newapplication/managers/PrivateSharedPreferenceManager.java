package com.dakakolp.newapplication.managers;

import android.content.SharedPreferences;

import com.dakakolp.newapplication.NewApplicationApp;
import com.dakakolp.newapplication.utils.ConstantManager;

import java.util.ArrayList;
import java.util.List;

public class PrivateSharedPreferenceManager {
    private SharedPreferences mPrivateSharedPreferences;

    public PrivateSharedPreferenceManager(SharedPreferences sharedPreferences) {
        mPrivateSharedPreferences = sharedPreferences;
    }

    public void saveUserProfile(String username, String password) {
        SharedPreferences.Editor editor = mPrivateSharedPreferences.edit();
        editor.putString(ConstantManager.USER_NAME, username);
        editor.putString(ConstantManager.USER_PASSWORD, password);
        editor.apply();
    }

    public List<String> loadUserProfile() {
        List<String> usersData = new ArrayList<>();
        usersData.add(mPrivateSharedPreferences.getString(ConstantManager.USER_NAME, null));
        usersData.add(mPrivateSharedPreferences.getString(ConstantManager.USER_PASSWORD, null));
        return usersData;
    }
}