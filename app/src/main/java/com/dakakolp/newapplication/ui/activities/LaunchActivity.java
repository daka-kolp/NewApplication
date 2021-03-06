package com.dakakolp.newapplication.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dakakolp.newapplication.NewApplicationApp;

public class LaunchActivity extends BaseActivity {

    private NewApplicationApp mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = NewApplicationApp.getApplicationInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        boolean isNotRegistered = mApp.getPrivatePreferenceManager().loadUserData() == null;
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

