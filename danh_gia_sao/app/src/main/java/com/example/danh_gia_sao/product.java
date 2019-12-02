package com.example.danh_gia_sao;

import android.content.SharedPreferences;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class product implements Serializable {
    String name;
    String description;
    int image;
    float rating;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public product(String name, String description, int image, int rating) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.rating = rating;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static   ArrayList<product> generateDataSource() {
        ArrayList<product> thebrands = new ArrayList<>();
        thebrands.add(
                new product("Mỹ tâm","Phan Thị Mỹ Tâm (sinh ngày 16 tháng 1 năm 1981 là nữ ca sĩ",
                        R.drawable.mitam, 0));
        thebrands.add(
                new product("Sơn Tùng","No 1 social site",
                        R.drawable.sontung1, 0));
        thebrands.add(
                new product("Công Phượng","No 1 social site",
                        R.drawable.congphuong1, 0));
        thebrands.add(
                new product("Văn Toàn","No 1 social site",
                        R.drawable.vantoan, 0));
        thebrands.add(
                new product("Ronaldol","No 1 social site",
                        R.drawable.ronadal, 0));
        thebrands.add(
                new product("Quang Hải","No 1 social site",
                        R.drawable.image3, 0));

        return thebrands;
    }
}
