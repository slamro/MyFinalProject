package com.example.myfinalproject.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ImagesDao {
    @Query("select * from Images")
    LiveData<List<Images>> getAll();

    @Insert
    void insert (Images images);

    @Insert
    void insert(ArrayList<Images> images);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCourses(Images...images);

    @Query("select * from Images where pkid =:pid")
    Images getbyID(int pid);


}
