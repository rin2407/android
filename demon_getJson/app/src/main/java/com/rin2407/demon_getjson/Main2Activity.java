package com.rin2407.demon_getjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rin2407.adapter.ImageAdapter;
import com.rin2407.models.Data;
import com.rin2407.models.Image;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {
    TextView txtName, txtDescription;
    ImageView imgHinh;
    Button btnNhan;
    Data d;
    ProgressBar mProgressBar;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
//        Toast.makeText(Main2Activity.this, "" + link, Toast.LENGTH_LONG).show();
        addControls();
        addEvents();

        mProgressBar = findViewById(R.id.progress);

        /*RETROFIT*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://"+link+"/")
//                .baseUrl("http://nopbai.live/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        requestAPI request = retrofit.create(requestAPI.class);
        Call<Data> call = request.getImages();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(Main2Activity.this, "CODE " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                mProgressBar.setVisibility(View.GONE);
                Data data = response.body();
                d = data;
                if (data != null && data.getImages() != null && data.getImages().size() > 0) {
                    txtName.setText(data.getName());
//                    Glide.with(Main2Activity.this).load(data.getImages().get(0).getName()).into(imgHinh);
//                    txtDescription.setText(data.getImages().get(0).getDescription());
//                    for (Image image : data.getImages()) {
//                        String content="";
//                        content += "Link: " + image.getDescription() + "\n";
//                        txtDescription.append(content);
//                    }
                    setUpAdapter();

                }

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(Main2Activity.this, "AHIHI " + t.getMessage(), Toast.LENGTH_LONG).show();
                mProgressBar.setVisibility(View.GONE);
            }

        });
        /*END*/
//        btnNhan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                i++;
//                Glide.with(Main2Activity.this).load(d.getImages().get(i).getName()).into(imgHinh);
//                txtDescription.setText(d.getImages().get(i).getDescription());
//            }
//        });

    }

    private void setUpAdapter() {
        ImageAdapter imageAdapter = new ImageAdapter(getSupportFragmentManager(), 1, d.getImages());
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(imageAdapter);

    }

    private void addEvents() {

    }

    private void addControls() {
        txtName = findViewById(R.id.txtName);
//        txtDescription = findViewById(R.id.txtDescription);
//        imgHinh = findViewById(R.id.imgHinh);
//        btnNhan = findViewById(R.id.btnNhan);
    }
}
