package com.example.thebestone.thestores.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.thebestone.thestores.R;

import java.util.List;

/**
 * Created by thebestone on 10/22/17.
 */

public class AdapterPhotoDagang extends RecyclerView.Adapter<AdapterPhotoDagang.ViewHolder> {

    List<Bitmap> mList;
    Activity activity;

    public AdapterPhotoDagang(List<Bitmap> mList, Activity activity) {
        this.mList = mList;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_photo_add, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imgCaptured.setImageBitmap(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCaptured;

        public ViewHolder(View v) {
            super(v);

            imgCaptured = (ImageView) v.findViewById(R.id.imgCaptured);
        }
    }
}
