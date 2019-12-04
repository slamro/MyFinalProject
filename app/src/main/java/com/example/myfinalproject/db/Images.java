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
    public Images(String nasa_id, String title, String description, String href, int cart, int purchased){
        this.pkid = nasa_id;
        this.title = title;
        this.desc = description;
        this.Url = href;
        this.cart = cart;
        this.purchased = purchased;
    }

    private String title;
    private String desc;
    private String Url;
    private int cart = 0;
    private int purchased = 0;

    public String getPkid(){return pkid;}
    public void setPkid(String id){pkid = id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}
    public String getDesc(){return desc;}
    public void setDesc(String desc){this.desc = desc;}
    public String getUrl(){return Url;}
    public void setUrl(String url){this.Url = url;}
    public int getCart(){return cart;}
    public void setCart(int cart){this.cart = cart;}
    public int getPurchased(){return purchased;}
    public void setPurchased(int purchased){this.purchased = purchased;}


}
