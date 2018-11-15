package com.dakakolp.newapplication.ui.activities;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dakakolp.newapplication.R;
import com.dakakolp.newapplication.managers.DataManager;

public class RegistrationActivity extends AppCompatActivity {

    private EditText mEditName, mEditPass, mEditPassRep;
    private Button mButtonSingUp;
    private CoordinatorLayout mSingUpCoordinatorLayout;
    private DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mDataManager = DataManager.getInstance();

        mSingUpCoordinatorLayout = findViewById(R.id.sign_up_coordinator_layout);
        mEditName = findViewById(R.id.username);
        mEditPass = findViewById(R.id.password);
        mEditPassRep = findViewById(R.id.password_repeat);

        mButtonSingUp = findViewById(R.id.sing_up);

        mButtonSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkData()) {
                    saveSharedPref();
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    boolean buttonRefresh = !mEditName.getText().toString().equals("") ||
                            !mEditPass.getText().toString().equals("") ||
                            !mEditPassRep.getText().toString().equals("");
                    showShackBarError(R.string.wrong_data, buttonRefresh);
                }

            }
        });
    }

    private void saveSharedPref() {
        mDataManager.getPreferenceManager().saveUserProfile(
                mEditName.getText().toString(), mEditPass.getText().toString());
    }

    private boolean checkData() {
        return mEditPass.getText().toString().equals(mEditPassRep.getText().toString()) &&
                !mEditName.getText().toString().equals("") &&
                !mEditPass.getText().toString().equals("");
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