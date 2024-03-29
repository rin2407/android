package com.rin2407.models;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Image /*implements Parcelable*/ {
    private String name;
    
    private String description;


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

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
