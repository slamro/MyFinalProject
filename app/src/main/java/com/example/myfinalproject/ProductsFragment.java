package com.example.myfinalproject;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {

    View root;
    private ImageView imageView;
    private TextView title, description, nasaID;



    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_products, container, false);


        return root;
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//
//        Context context = getContext();
//        RecyclerViewAdapter = new CourseRecyclerViewAdapter(new ArrayList<Course>());
//
//        if (columnCount <=1 ){
//            recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        }
//        else{
//            recyclerView.setLayoutManager(new GridLayoutManager(context, columnCount));
//        }
//        recyclerView.setAdapter(courseRecyclerViewAdapter);
//        recyclerView.setHasFixedSize(false);
//
//        ViewModelProviders.of(this)
//                .get(AllCoursesViewModel.class)
//                .getCourseList(context)
//                .observe(this, new Observer<List<Course>>() {
//                    @Override
//                    public void onChanged(List<Course> courses) {
//                        if (courses !=null){
//                            courseRecyclerViewAdapter.addItems(courses);
//                        }
//                    }
//                });
//    }

}
