package com.example.hackuci2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;

import com.example.hackuci2020.MapFragment;
import com.example.hackuci2020.DBManager;

public class MainActivity extends AppCompatActivity{

    DBManager db;

    private static final String TAG = "MainActivity";
    // vars
    private ArrayList<String> Names = new ArrayList<>();
    private ArrayList<String> internetURLs = new ArrayList<>();


    private int version;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        Button createButton = findViewById(R.id.add_event);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EventActivity.class);
                startActivity(i);
            }
        });

        db = new DBManager(getApplicationContext());

        db.open();
        initImageBitmaps();
        db.close();

        version = 0;

    }

    @Override
    public void startActivity(Intent intent){
        super.startActivity(intent);
        if(version == 0) {
            version = 1;
            Log.d("activity" , "Good log");
        }
        if(version == 1) {

        }
        if(version == 2) {

        }
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        TimeRepresentation tr = new TimeRepresentation(0, 1, 0, 0, 0);
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83691170_3117173931650230_3437677482822598656_n.jpg?_nc_cat=105&_nc_ohc=szftTcVtXFcAX9wGmyR&_nc_ht=scontent-lax3-1.xx&oh=1500789deabfbd5dbe65b31fd9966c31&oe=5ECE1603");
        //Names.add(db.getEvent(tr).getName());
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

        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83996659_3117234971644126_7160266684991799296_n.jpg?_nc_cat=100&_nc_ohc=FVw0OOl1VOgAX_87Zmr&_nc_ht=scontent-lax3-1.xx&oh=66af598da892418b480a842974bd69ec&oe=5ECCAA8F");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83637058_3117235028310787_8202038529081999360_n.jpg?_nc_cat=103&_nc_ohc=3_lcbzhEZIMAX9yXMK6&_nc_ht=scontent-lax3-1.xx&oh=304bf98f2d2831d5cca52cfd4a6da003&oe=5EC4DC75");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83290189_3117235181644105_7096867465849733120_n.jpg?_nc_cat=104&_nc_ohc=9EL_fSO0qu8AX-jnFvr&_nc_ht=scontent-lax3-1.xx&oh=347df3884d70be91e261231f5a003ab4&oe=5E935482");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83692122_3117235178310772_518267415776198656_n.jpg?_nc_cat=110&_nc_ohc=YyCdKbyEYn4AX905yzs&_nc_ht=scontent-lax3-1.xx&oh=7b9d0b0055ed7226a2c64dd3751ac5b9&oe=5EC8FE7C");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/84026281_3117235394977417_2014105375652970496_n.jpg?_nc_cat=100&_nc_ohc=MAjUmPr83UYAX8ftNq2&_nc_ht=scontent-lax3-1.xx&oh=824c4510a6a0c5e86c3c0e05ebc17eda&oe=5ED14732");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83615950_3117235388310751_827445356747816960_n.jpg?_nc_cat=104&_nc_ohc=kgRKok-LClUAX_rM4Ym&_nc_ht=scontent-lax3-1.xx&oh=347dfc3952ef895ac67d7d9f4d2053ef&oe=5ECF506F");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83216024_3117235398310750_2657031571495714816_n.jpg?_nc_cat=108&_nc_ohc=kT7Q_iZ2O-MAX_f5mEC&_nc_ht=scontent-lax3-1.xx&oh=b767b07bf72df61fa4b2d6b65aea26db&oe=5EC9A697");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83396707_3117235391644084_8887954697562882048_n.jpg?_nc_cat=102&_nc_ohc=FX0wDhTXXhsAX8XsrsU&_nc_ht=scontent-lax3-1.xx&oh=fd1a10787201eecb43623171c94ab84e&oe=5EDACDA2");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-2.xx.fbcdn.net/v/t1.0-9/83322042_3117235274977429_6437117642590388224_n.jpg?_nc_cat=111&_nc_ohc=9JMjLtau6KkAX_TGAie&_nc_ht=scontent-lax3-2.xx&oh=7716a39fe0c182e8ce3fb607a3671304&oe=5E93ADE0");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/81428637_3117235278310762_1204707492957782016_n.jpg?_nc_cat=104&_nc_ohc=J0jGSKw2f5gAX9eUBR-&_nc_ht=scontent-lax3-1.xx&oh=f0913ccc7ee240d04ddcc83421f9ec3e&oe=5E903A5B");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83592559_3117235294977427_3172851465798549504_n.jpg?_nc_cat=102&_nc_ohc=TyZgncjVqdIAX-vx-8G&_nc_ht=scontent-lax3-1.xx&oh=4ce588a1921c0d977fc18ea2df545c77&oe=5EBCD5FC");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-2.xx.fbcdn.net/v/t1.0-9/83455411_3117235271644096_5443069606782566400_n.jpg?_nc_cat=106&_nc_ohc=kOQW4mgSKBMAX9dT_JE&_nc_ht=scontent-lax3-2.xx&oh=38eb936f57dd8ebd3f547bf1e3c32067&oe=5E916AD5");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-2.xx.fbcdn.net/v/t1.0-9/83965455_3117235291644094_4413707031312072704_n.jpg?_nc_cat=106&_nc_ohc=uLNUE3CQ9nQAX-DmtcQ&_nc_ht=scontent-lax3-2.xx&oh=13a8eaeb7f7b61eb0218beef765d74fb&oe=5EC86DF6");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83378941_3117235168310773_4528631555765043200_n.jpg?_nc_cat=100&_nc_ohc=xVw817kIR_QAX8P4NR0&_nc_ht=scontent-lax3-1.xx&oh=c67f24dcfa929ea588c8c1fc81312329&oe=5EBE1E0C");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-2.xx.fbcdn.net/v/t1.0-9/83826088_3117235174977439_4396268605096853504_n.jpg?_nc_cat=111&_nc_ohc=U_lYP-gNDcoAX8CQCX2&_nc_ht=scontent-lax3-2.xx&oh=d32481202eed07ce53d7c9995eb2058b&oe=5EBFC3A7");
        Names.add("Event");
        internetURLs.add("https://scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/83736863_3117235171644106_3396789162236444672_n.jpg?_nc_cat=100&_nc_ohc=PTNtw7GHWfwAX_jjNlg&_nc_ht=scontent-lax3-1.xx&oh=92374ece21022db07bd9b24335d38e66&oe=5EBFB3CA");
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
