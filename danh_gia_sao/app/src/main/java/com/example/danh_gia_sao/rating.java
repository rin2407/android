package com.example.danh_gia_sao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class rating extends AppCompatActivity {
    private  String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        //Get data from MainActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra("nameUser");
        String Des = intent.getStringExtra("nameDes");
        final product theselect = (product) intent.getSerializableExtra("objPro");
        int image = intent.getIntExtra("nameImg", 0);
        float rating = intent.getFloatExtra("rating", 0);
        final int number = intent.getIntExtra("number", 0);
        // Set Data for View
        TextView DesTV = findViewById(R.id.des);
        ImageView imgView = findViewById(R.id.image_rating);
        imgView.setImageResource(image);
        DesTV.setText(Des);
        // Get rating
        final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        simpleRatingBar.setRating(rating);
        // Event change rating
        simpleRatingBar.setOnRatingBarChangeListener(
            new RatingBar.OnRatingBarChangeListener(){

                @Override
                public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                    // Get count rating
                    float numberOfStars = simpleRatingBar.getRating();
                    // Get data from share..
                    ArrayList<product> products;
                    products = getArrayList("tri");
                    // update rating when user change rating
                    products.get(number).setRating(numberOfStars);
                    // save share..
                    saveArrayList(products, "tri");
                }

                public ArrayList<product> getArrayList(String key){
                    SharedPreferences prefs = getSharedPreferences("USER",MODE_PRIVATE);
                    Gson gson = new Gson();
                    String json = prefs.getString(key, null);
                    Type type = new TypeToken<ArrayList<product>>() {}.getType();
                    return gson.fromJson(json, type);
                }

                public void saveArrayList(ArrayList<product> list, String key){
                    SharedPreferences prefs = getSharedPreferences("USER",MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    Gson gson = new Gson();
                    String json = gson.toJson(list);
                    editor.putString(key, json);
                    editor.apply();     // This line is IMPORTANT !!!
                }
            }
        );
    }
    @Override
    public void onBackPressed() {
        Intent profileIntent = new Intent(rating.this, MainActivity.class);
        startActivity(profileIntent);
    }
}
