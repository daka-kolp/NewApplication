package com.dakakolp.newapplication.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dakakolp.newapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
    }
}
