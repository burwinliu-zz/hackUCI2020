package com.example.hackuci2020;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {
    private static final String TAG = "DescriptionActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_description);
        Log.d(TAG, "onCreate: started");


    }

}
