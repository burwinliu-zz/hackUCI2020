package com.example.hackuci2020;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "HorizontalRecyclerViewA";
    //vars
    private ArrayList<String> mNames= new ArrayList<>();
    private ArrayList<String> mImageURLs = new ArrayList<>();
    private Context mContext;

    public HorizontalRecyclerViewAdapter(Context context, ArrayList<String> mNames, ArrayList<String> mImageURLs) {
        this.mNames = mNames;
        this.mImageURLs = mImageURLs;
        this.mContext = context;
    }

    @Override
    
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder:  called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_horizontal_days, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext).asBitmap().load(mImageURLs.get(position)).into(holder.image);
        holder.name.setText(mNames.get(position));


    }

    @Override
    public int getItemCount() {
        return mImageURLs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.name);


        }
    }
}
