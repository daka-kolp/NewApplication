package com.dakakolp.newapplication.data.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.dakakolp.newapplication.data.classes.User;
import com.dakakolp.newapplication.utils.ConstantManager;
import com.google.gson.Gson;

public class PrivateSharedPreferenceManager {
    private SharedPreferences mSharedPreferences;

    public PrivateSharedPreferenceManager(Context context, String fileName) {
        mSharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
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
        if (strUser == null) return null;
        Gson gson = new Gson();
        return gson.fromJson(strUser, User.class);
    }

    public void deleteUserData() {
        mSharedPreferences
                .edit()
                .remove(ConstantManager.USER)
                .apply();
    }
}
