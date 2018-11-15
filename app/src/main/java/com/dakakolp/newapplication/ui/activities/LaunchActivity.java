package com.dakakolp.newapplication.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dakakolp.newapplication.NewApplicationApp;

public class LaunchActivity extends AppCompatActivity {

    private NewApplicationApp mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = NewApplicationApp.getApplicationInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //проверка зарегистировался ли пользователь ранее
        boolean isNotRegistered = (mApp.getPreferenceManager().loadUserProfile().get(0) == null)
                && (mApp.getPreferenceManager().loadUserProfile().get(1) == null);
        Intent intent;
        if (isNotRegistered) {
            intent = new Intent(this, RegistrationActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }

}

