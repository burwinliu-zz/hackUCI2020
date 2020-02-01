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

        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83283376_3117181288316161_5247461579053596672_n.jpg?_nc_cat=104&_nc_ohc=IxSXks2dtOIAX_xgHla&_nc_ht=scontent-lax3-1.xx&oh=7d4a5631876a0cf07a06ec2484edcbd1&oe=5ED979F1");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83259395_3117181294982827_915053949327769600_n.jpg?_nc_cat=102&_nc_ohc=FLSYumnOWzcAX9FUY0w&_nc_ht=scontent-lax3-1.xx&oh=f686bc1c074a26c47c8d9235444be5b5&oe=5ED1921C");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83704618_3117181231649500_3814580594126356480_n.jpg?_nc_cat=102&_nc_ohc=om_hJl3SZzEAX9bvGCe&_nc_ht=scontent-lax3-1.xx&oh=8b4b658bbc5c9639408c355d4171c705&oe=5E8ED40D");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83620699_3117181224982834_8202386318353760256_n.jpg?_nc_cat=109&_nc_ohc=DX57ol3SIUQAX_0ozVq&_nc_ht=scontent-lax3-1.xx&oh=451917e46970c3514bae910ac048fcf8&oe=5E93B483");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-2.xx.fbcdn.net/v/t1.0-9/83484288_3117181168316173_1863350202497236992_n.jpg?_nc_cat=107&_nc_ohc=ASB3vxwngWQAX_OdM7c&_nc_ht=scontent-lax3-2.xx&oh=a2a4253be04c2d33dbbf6369fd85879d&oe=5E8F2124");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83515972_3117181178316172_2000158577460772864_n.jpg?_nc_cat=102&_nc_ohc=2W6zxYLMgRYAX9NvThK&_nc_ht=scontent-lax3-1.xx&oh=8592d0ce338736ce2fed53d36dd68542&oe=5EC6BB26");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83289843_3117173938316896_4972520523205443584_n.jpg?_nc_cat=100&_nc_ohc=jj4BbtOI15gAX9EhJwZ&_nc_ht=scontent-lax3-1.xx&oh=0a92c3979655290ca40fcc114378dd40&oe=5ED1D783");
        Names.add("Event");
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
