package com.example.myfinalproject;

import androidx.appcompat.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.DialogFragment;

import com.example.myfinalproject.db.AppDatabase;
import com.example.myfinalproject.db.Images;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ProductDetails extends DialogFragment {
    private ImageView imgView;
    private String imgURL;
    private TextView imgID, imgTitle, imgDetails;
    private View root;
    Images image;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.dialog_image_details, container, false);

        imgView = (ImageView)root.findViewById(R.id.Image);
        imgTitle = root.findViewById(R.id.ImgTitle);
        imgDetails = root.findViewById(R.id.ImgDesc);
        imgURL = "";

        Bundle bundle = this.getArguments();
        if(bundle !=null){
            final String imgID = bundle.getString("Image_pk");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    image = AppDatabase.getInstance(getContext())
                            .imagesDAO()
                            .getbyID(imgID);
                    imgURL = image.getURI();
                    imgTitle.setText(image.getTitle());
                    imgDetails.setText(image.getDesc());
                    URL newURL = null;
                    Bitmap iconVal = null;
                    try {
                        newURL = new URL(imgURL);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    try {
                        iconVal = BitmapFactory.decodeStream(newURL.openConnection().getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imgView.setImageBitmap(iconVal);

                }
            }).start();
        }


        return root;
    }

}
