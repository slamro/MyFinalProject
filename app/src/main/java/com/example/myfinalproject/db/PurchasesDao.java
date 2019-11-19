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
public interface PurchasesDao {
    @Query("select * from Purchases")
    LiveData<List<Purchases>> getAll();

    @Insert
    void insert (Purchases purchases);
//
//    @Insert
//    void insert(ArrayList<Purchases> purchases);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertCourses(Purchases...purchases);

    @Query("select * from Purchases where pkid =:pid")
    Purchases getbyID(int pid);

    @Update
    void update(Purchases purchases);

    @Delete
    void delete(Purchases purchases);
}
