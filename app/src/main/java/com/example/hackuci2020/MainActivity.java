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
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83691170_3117173931650230_3437677482822598656_n.jpg?_nc_cat=105&_nc_ohc=szftTcVtXFcAX9wGmyR&_nc_ht=scontent-lax3-1.xx&oh=1500789deabfbd5dbe65b31fd9966c31&oe=5ECE1603");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83289843_3117173938316896_4972520523205443584_n.jpg?_nc_cat=100&_nc_ohc=jj4BbtOI15gAX9EhJwZ&_nc_ht=scontent-lax3-1.xx&oh=0a92c3979655290ca40fcc114378dd40&oe=5ED1D783");
        Names.add("Event");
        internetURLs.add("");
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
