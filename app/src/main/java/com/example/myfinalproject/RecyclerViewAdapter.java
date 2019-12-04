package com.example.myfinalproject;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.myfinalproject.db.Images;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<Images> images;


    public RecyclerViewAdapter(List<Images> nasa){images = nasa;}

    public void addItems(List<Images> nasa) {
        this.images.clear();
        this.images.addAll(nasa);
        notifyDataSetChanged();
    }
//    public RecyclerViewAdapter(Context context, ArrayList values, ItemListener itemListener) {
//
//        mValues = values;
//        mContext = context;
//        mListener=itemListener;
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View root;
        public Images nasa;
        public TextView textView;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
//        DataModel item;

        public ViewHolder(View itemView) {

            super(itemView);
            root = itemView;


            textView = root.findViewById(R.id.textView);
            imageView = root.findViewById(R.id.imageView);
//            relativeLayout = root.findViewById(R.id.relativeLayout);

        }

    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        final Images image = images.get(position);
        if (image != null){
            holder.nasa = image;
//            holder.imageView.setImageURI(image.getURI());
            holder.textView.setText(image.getTitle());
            Log.d("Title", "Nasa ID " + image.getTitle());

            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Image_pk", image.getPkid());

                    ProductDetails pDetails = new ProductDetails();
                    pDetails.setArguments(bundle);

                    AppCompatActivity activity = (AppCompatActivity)view.getContext();
                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(android.R.id.content, pDetails)
                            .addToBackStack(null)
                            .commit();

                }
            });
        }

    }



    @Override
    public int getItemCount() {

        return images.size();
    }

}
