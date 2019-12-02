package com.example.myfinalproject.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Images {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    private String pkid;


    public Images(){}
    public Images(String id, String title, String desc, String uri, int cart, int purchased){
        this.pkid = id;
        this.title = title;
        this.desc = desc;
        URI = uri;
        this.cart = cart;
        this.purchased = purchased;
    }

    private String title;
    private String desc;
    private String URI;
    private int cart;
    private int purchased;

    public String getPkid(){return pkid;}
    public void setPkid(String id){pkid = id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}
    public String getDesc(){return desc;}
    public void setDesc(String desc){this.desc = desc;}
    public String getURI(){return URI;}
    public void setURI(String uri){URI = uri;}
    public int getCart(){return cart;}
    public void setCart(int cart){this.cart = cart;}
    public int getPurchased(){return purchased;}
    public void setPurchased(int purchased){this.purchased = purchased;}

}
