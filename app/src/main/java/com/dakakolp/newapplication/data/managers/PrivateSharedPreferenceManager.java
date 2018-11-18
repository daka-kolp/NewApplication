package com.dakakolp.newapplication.data.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.dakakolp.newapplication.data.classes.User;
import com.dakakolp.newapplication.utils.ConstantManager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class PrivateSharedPreferenceManager {
    private SharedPreferences mSharedPreferences;
    private String mFileNameSharedPreferences;

    public PrivateSharedPreferenceManager(Context context, String fileName) {
        mFileNameSharedPreferences = fileName;
        mSharedPreferences = context.getSharedPreferences(mFileNameSharedPreferences, Context.MODE_PRIVATE);
    }

    public void saveUserData(String username, String password) {
        User user = new User(username, password);
        Gson gson = new Gson();
        String strUser = gson.toJson(user);

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER, strUser);
        editor.apply();
    }

    public User loadUserData() {
        String strUser = mSharedPreferences.getString(ConstantManager.USER, null);

        Gson gson = new Gson();
        User user = gson.fromJson(strUser, User.class);
        return user;
    }

    public void deleteUserData() {
        mSharedPreferences
                .edit()
                .remove(ConstantManager.USER)
                .apply();
    }
}
