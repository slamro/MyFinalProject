package com.example.myfinalproject;

import android.os.AsyncTask;
import android.util.Log;

import com.example.myfinalproject.db.Images;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class GetNasaImages extends AsyncTask<String, Integer, String> {
    private String rawJson, Sdata;
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
                    //Log.d("test","doInBackground " + rawJson);
                    JSONObject nasaBase = new JSONObject(rawJson);
                    //Log.d("test","doInBackground " + nasaBase);

                    JSONObject nasaColle = new JSONObject(nasaBase.getString("collection"));
                    //JSONObject nasaImages = new JSONObject(Images);
                    //Log.d("JSON Array", "nasaImages" + nasaColle);
                    JSONArray nasaItems = nasaColle.getJSONArray("items");
                    Log.d("JSON Array", "nasaImages" + nasaItems);
                    JSONObject nasaData = new JSONObject(nasaItems.getString(2));
                    //Log.d("JSON Array", "nasaImages" + nasaImages);
                    Sdata = nasaData.getString("data");
//                    JSONArray data = nasaData.getJSONArray("data");
//                    JSONObject newData = data.getJSONObject(0);
//                    String id = newData.getString("nasa_id");
//                    Log.d("JSON Array", "nasaData" + id);

//                    Log.d( "id", "nasa ID: " + data);

//                    for (int i = 0; i < nasaImages.length(); i++){
//                        Log.d("JSON object", "Image Object: " + nasaImages.getJSONObject(i));
//                    }

            }
        }
        catch(Exception e){
            Log.d("failed", "doInBackground " + e.toString());

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
            images = gson.fromJson(Sdata, Images[].class);
            Log.d("images", "Images: "+ images);

        } catch (Exception e) {

        }
        return images;
    }
}
