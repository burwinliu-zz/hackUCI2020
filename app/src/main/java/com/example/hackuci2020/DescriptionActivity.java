package com.example.hackuci2020;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DescriptionActivity extends AppCompatActivity {
    private static final String TAG = "DescriptionActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_description);
        Log.d(TAG, "onCreate: started");

        getIncomingIntent();


    }
    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: checking for incoming intent.");
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")) {
            Log.d(TAG, "getIncomingIntent: found intent extras");

            String imageURL = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");

            setImage(imageURL, imageName);

        }

    }
    private void setImage(String imageURL, String imageName) {
        Log.d(TAG, "setImage: setting the image and name to widgets");

        TextView name = findViewById(R.id.textView7);
        name.setText(imageName);
        TextView start = findViewById(R.id.Starttime);
        start.setText(imageName);
        TextView end = findViewById(R.id.endTime);
        end.setText(imageName);
        TextView location = findViewById(R.id.location);
        location.setText(imageName);
        TextView alert = findViewById(R.id.alertTime);
        alert.setText(imageName);
        TextView descrip = findViewById(R.id.description);
        descrip.setText(imageName);

        ImageView whitrect = findViewById(R.id.imageView2);
        Glide.with(this)
                .asBitmap().load(imageURL).into(whitrect);
    }

}
