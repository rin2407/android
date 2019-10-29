package com.rin2407.demon_getjson;

import com.rin2407.models.Data;
import com.rin2407.models.Image;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface requestAPI {
    @GET("data/data.json")
    Call<Data> getImages();
}
