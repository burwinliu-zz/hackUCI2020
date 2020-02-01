package com.example.hackuci2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    // vars
    private ArrayList<String> Names = new ArrayList<>();
    private ArrayList<String> internetURLs = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
<<<<<<< HEAD

=======
>>>>>>> 7365d5cf62c3cbda6f04b78f9491e79d58bd07c0
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");
        Button createButton = findViewById(R.id.add_event);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EventActivity.class));
            }
        });
        initImageBitmaps();

    }
    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        internetURLs.add("shutterstock.com/blog/wp-content/uploads/sites/5/2019/07/Man-Silhouette.jpg");
        Names.add("Moon");
        initRecyclerView();


    }
    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.recylerview);
        RecycleViewAdapter adapter = new RecycleViewAdapter(this, Names, internetURLs);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
