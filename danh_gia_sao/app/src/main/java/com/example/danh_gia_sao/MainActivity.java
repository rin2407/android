package com.example.danh_gia_sao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity   {
    GridView BrandsLV;
    ArrayList<product> brands;
    private  String TAG = "ProductActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get gridView
        BrandsLV=findViewById(R.id.gridview);
        // get Data from share .. if data == null we will get from to product and get it
        brands = getArrayList("tri");
        if(brands == null) {
            saveArrayList(product.generateDataSource(), "tri");
        }
        brands = getArrayList("tri");

        // display view
        Intent intent = getIntent();
        item theAdapter = new item(brands, this);
        BrandsLV.setAdapter(theAdapter);
        BrandsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                product theSelecteCity = brands.get(i);
                Log.d(TAG, String.valueOf(theSelecteCity.getImage()));
                Intent profileIntent = new Intent(MainActivity.this, rating.class);
                profileIntent.putExtra("nameUser", theSelecteCity.getName());
                profileIntent.putExtra("nameDes", theSelecteCity.getDescription());
                profileIntent.putExtra("nameImg",theSelecteCity.getImage());
                profileIntent.putExtra("rating", theSelecteCity.getRating());
                profileIntent.putExtra("objPro", (Serializable) theSelecteCity);
                profileIntent.putExtra("number", i);
                startActivity(profileIntent);
            }
        });
    }
    public void saveArrayList(ArrayList<product> list, String key){
        SharedPreferences prefs = getSharedPreferences("USER",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public ArrayList<product> getArrayList(String key){
        SharedPreferences prefs = getSharedPreferences("USER",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<product>>() {}.getType();
        return gson.fromJson(json, type);
    }

}
