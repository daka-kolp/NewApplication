package com.dakakolp.newapplication.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.dakakolp.newapplication.utils.ConstantManager;

import java.util.ArrayList;
import java.util.List;

public class SharedPreferenceManager {
    private SharedPreferences mSharedPreferences;
    private String mFileNameSharedPreferences;

    public SharedPreferenceManager(Context context, String fileName, int modePreference) {
        mFileNameSharedPreferences = fileName;
        mSharedPreferences = context.getSharedPreferences(mFileNameSharedPreferences, modePreference);
    }

    public void saveUserProfile(String username, String password) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_NAME, username);
        editor.putString(ConstantManager.USER_PASSWORD, password);
        editor.apply();
    }

    public List<String> loadUserProfile() {
        List<String> usersData = new ArrayList<>();
        usersData.add(mSharedPreferences.getString(ConstantManager.USER_NAME, null));
        usersData.add(mSharedPreferences.getString(ConstantManager.USER_PASSWORD, null));
        return usersData;
    }

    public void deleteUserProfile() {
        mSharedPreferences
                .edit()
                .remove(mFileNameSharedPreferences)
                .apply();
    }
}
