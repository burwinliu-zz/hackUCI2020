package com.example.hackuci2020;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    private static final String TAG = "RecycleViewAdapter";
    private ArrayList<String> ImageNames = new ArrayList<>();
    private ArrayList<String> Images = new ArrayList<>();
    private Context mContext;

    public RecycleViewAdapter(Context mcontext, ArrayList<String> imageNames, ArrayList<String> images) {
        ImageNames = imageNames;
        Images = images;
        mContext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listhours_item, parent, false );
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(Images.get(position))
                .into(holder.image);
        holder.imageName.setText(ImageNames.get(position));

        //on click thing hear to open up either fragment or activity showing the event's details
    }

    @Override
    public int getItemCount() {
        return ImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView imageName;
        ConstraintLayout parentLayout;
        public ViewHolder(View itemView) {

            super(itemView);
            image = itemView.findViewById(R.id.hour_image);
            imageName = itemView.findViewById(R.id.time);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
