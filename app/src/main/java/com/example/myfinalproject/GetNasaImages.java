package com.example.myfinalproject;

import android.os.AsyncTask;
import android.util.Log;

import com.example.myfinalproject.db.Images;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetNasaImages extends AsyncTask<String, Integer, String> {
    private String rawJson;
    private OnImageListComplete mCallBack;

    public interface OnImageListComplete{
        void processImageList(Images[] images);
    }

    public void setOnImageListComplete(OnImageListComplete listener){
        mCallBack= listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL("https://images-api.nasa.gov/search?q=nebula");
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + "ldlwUNG7oGU0mvJiBeUGSwqYB1Z2a5OysaJWr1YF");

            int status = connection.getResponseCode();
            switch(status){
                case 200:
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    rawJson = br.readLine();
                    Log.d("test","doInBackground " + rawJson);
            }
        }
        catch(Exception e){
            Log.d("test", "doInBackground " + e.toString());

        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        Images[] images;
        try{
            images = parseJson(result);
            mCallBack.processImageList(images);
        }catch(Exception e){

        }
    }
    private Images[] parseJson(String result) {
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        Images[] images = null;
        try {
            images = gson.fromJson(rawJson, Images[].class);

        } catch (Exception e) {

        }
        return images;
    }
}
