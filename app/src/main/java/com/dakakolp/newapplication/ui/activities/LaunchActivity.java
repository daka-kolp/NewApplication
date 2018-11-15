package com.dakakolp.newapplication.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dakakolp.newapplication.managers.DataManager;

public class LaunchActivity extends AppCompatActivity {

    private DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //проверка зарегистировался ли пользователь ранее
        boolean isRegistered = (mDataManager.getPreferenceManager().loadUserProfile().get(0) == null)
                && (mDataManager.getPreferenceManager().loadUserProfile().get(1) == null);
        Intent intent;
        if (isRegistered) {
            intent = new Intent(this, RegistrationActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }

}

