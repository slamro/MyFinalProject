package com.example.myfinalproject;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myfinalproject.db.AppDatabase;
import com.example.myfinalproject.db.Images;

import java.util.List;

public class AllImagesViewModel extends ViewModel {
    private LiveData<List<Images>> imageList;
    public LiveData<List<Images>> getImageList(Context c){
        if (imageList != null){
            return imageList;
        }
        else {
            return imageList = AppDatabase.getInstance(c).imagesDAO().getAll();
        }
    }
}
