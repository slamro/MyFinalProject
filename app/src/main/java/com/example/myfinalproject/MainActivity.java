package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.myfinalproject.db.AppDatabase;
import com.example.myfinalproject.db.Images;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GetNasaImages Nasa;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);
        bnv.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new HomeFragment())
                .commit();

        Nasa = new GetNasaImages();
        Log.d("GetNasaImages","Done " + Nasa);
        Nasa.setOnImageListComplete(new GetNasaImages.OnImageListComplete() {
            @Override
            public void processImageList(Images[] images) {
                final ArrayList<Images> imageList = new ArrayList<>();
                for (Images image:images){
                    Log.d("ItemList", "Item: " + imageList);
                    imageList.add(image);
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AppDatabase.getInstance(getApplicationContext())
                                .imagesDAO()
                                .insert(imageList);
                    }
                }).start();
            }
        });

        Nasa.execute("");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.menu_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.menu_products:

                            selectedFragment = new ProductsFragment();
                            break;
                        case R.id.menu_my_cart:
                            selectedFragment = new MyCartFragment();
                            break;
                        case R.id.menu_account:
                            selectedFragment = new AccountFragment();
                            break;

                    }

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, selectedFragment)
                            .commit();

                    return true;
                }
            };
}
