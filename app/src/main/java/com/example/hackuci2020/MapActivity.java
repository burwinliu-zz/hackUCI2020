package com.example.hackuci2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MapActivity extends AppCompatActivity {

    Button btn;
    MapFragment m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //m = findViewById(R.id.map);

        btn = findViewById(R.id.submitBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });
    }
}