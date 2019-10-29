package com.rin2407.models;

import java.util.List;

import lombok.Builder;

public class Data {
    private String name;
    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public String getName() {
        return name;
    }
}
