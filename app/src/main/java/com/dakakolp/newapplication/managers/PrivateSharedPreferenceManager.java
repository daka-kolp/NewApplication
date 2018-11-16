package com.dakakolp.newapplication.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.dakakolp.newapplication.utils.ConstantManager;

import java.util.ArrayList;
import java.util.List;

public class PrivateSharedPreferenceManager {
    private SharedPreferences mSharedPreferences;
    private String mFileNameSharedPreferences;

    public PrivateSharedPreferenceManager(Context context, String fileName, int modePreference) {
        mFileNameSharedPreferences = fileName;
        mSharedPreferences = context.getSharedPreferences(mFileNameSharedPreferences, modePreference);
    }

    public void saveUserData(String username, String password) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_NAME, username);
        editor.putString(ConstantManager.USER_PASSWORD, password);
        editor.apply();
    }

    public List<String> loadUserData() {
        List<String> usersData = new ArrayList<>();
        usersData.add(mSharedPreferences.getString(ConstantManager.USER_NAME, null));
        usersData.add(mSharedPreferences.getString(ConstantManager.USER_PASSWORD, null));
        return usersData;
    }

    public void deleteUserData() {
        mSharedPreferences
                .edit()
                .clear()
                .apply();
    }
}
