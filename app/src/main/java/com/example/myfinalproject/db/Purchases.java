package com.example.myfinalproject.db;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Purchases {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    private String pkid;

    public Purchases(){}
    public Purchases(String id, String title, String desc){
        this.pkid = id;
        this.title = title;
        this.desc = desc;
    }

    private String title;
    private String desc;

    public String getPkid(){return pkid;}
    public void setPkid(String id){pkid = id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}
    public String getDesc(){return desc;}
    public void setDesc(String desc){this.desc = desc;}
}
