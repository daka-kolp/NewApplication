package com.dakakolp.newapplication.ui.activities;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dakakolp.newapplication.NewApplicationApp;
import com.dakakolp.newapplication.R;

public class RegistrationActivity extends BaseActivity {

    private EditText mEditName, mEditPass, mEditPassRep;
    private Button mButtonSingUp;
    private CoordinatorLayout mSingUpCoordinatorLayout;
    private NewApplicationApp mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mApp = NewApplicationApp.getApplicationInstance();

        initViews();
    }

    private void initViews() {
        mSingUpCoordinatorLayout = findViewById(R.id.sign_up_coordinator_layout);
        mEditName = findViewById(R.id.username);
        mEditPass = findViewById(R.id.password);
        mEditPassRep = findViewById(R.id.password_repeat);
        mButtonSingUp = findViewById(R.id.sing_up);

        setSingUpListener(mButtonSingUp);
    }

    private void setSingUpListener(Button buttonSingUp) {
        buttonSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkData()) {
                    saveSharedPref();
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    boolean buttonRefresh = TextUtils.isEmpty(mEditName.getText().toString()) ||
                            TextUtils.isEmpty(mEditPass.getText().toString()) ||
                            TextUtils.isEmpty(mEditPassRep.getText().toString());
                    showShackBarError(R.string.wrong_data, buttonRefresh);
                }

            }
        });
    }

    private void saveSharedPref() {
        mApp.getPrivatePreferenceManager().saveUserData(
                mEditName.getText().toString(), mEditPass.getText().toString());
    }

    private boolean checkData() {
        return mEditPass.getText().toString().equals(mEditPassRep.getText().toString()) &&
                TextUtils.isEmpty(mEditName.getText().toString()) &&
                TextUtils.isEmpty(mEditPass.getText().toString());
    }

    private void showShackBarError(int message, boolean modeRefresh) {
        Snackbar snackbar = Snackbar.make(mSingUpCoordinatorLayout, message, Snackbar.LENGTH_LONG);
        if (modeRefresh) {
            snackbar.setAction(R.string.refresh_fields, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mEditName.getText().clear();
                    mEditPass.getText().clear();
                    mEditPassRep.getText().clear();
                }
            });
        }
        snackbar.show();
    }
}