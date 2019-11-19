package com.example.myfinalproject.db;


import androidx.room.Entity;

@Entity
public class Purchases {

    public Purchases(String id, String title, String desc){
        this.pkid = id;
        this.title = title;
        this.desc = desc;
    }
    private String pkid;
    private String title;
    private String desc;

    public String getPkid(){return pkid;}

    public String getTitle(){return title;}

    public String getDesc(){return desc;}
}
