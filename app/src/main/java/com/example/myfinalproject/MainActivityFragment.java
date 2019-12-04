package com.example.myfinalproject;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.myfinalproject.db.Images;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private View root;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter rva;
    private int columnCount =3;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        Context context = getContext();
        rva = new RecyclerViewAdapter(new ArrayList<Images>());

        if (columnCount <=1 ){
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
        else{
            recyclerView.setLayoutManager(new GridLayoutManager(context, columnCount));
        }
        recyclerView.setAdapter(rva);
        recyclerView.setHasFixedSize(false);

        ViewModelProviders.of(this)
                .get(AllImagesViewModel.class)
                .getImageList(context)
                .observe(this, new Observer<List<Images>>() {
                    @Override
                    public void onChanged(List<Images> images) {
                        if (images !=null){
                            rva.addItems(images);
                        }
                    }
                });
    }
}
