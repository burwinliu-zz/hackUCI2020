package com.example.hackuci2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BurwinsHome2 extends AppCompatActivity {

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burwins_home2);
        dbManager = new DBManager(getApplicationContext());

    }
}
