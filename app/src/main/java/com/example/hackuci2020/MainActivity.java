package com.example.hackuci2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button butn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TESTING_KEY", BuildConfig.bingAPIKey);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butn = findViewById(R.id.btn);
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EventActivity.class));
            }
        });
    }

}
