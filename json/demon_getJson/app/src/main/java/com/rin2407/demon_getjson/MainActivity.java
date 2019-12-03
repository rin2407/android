package com.rin2407.demon_getjson;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rin2407.demon_getjson.Main2Activity;
import com.rin2407.demon_getjson.R;

public class MainActivity extends AppCompatActivity {
    EditText edtLink;
    Button btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyGet();
            }
        });
    }

    private void xuLyGet() {
        if (edtLink.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Hãy nhập link!", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra("link",edtLink.getText().toString());
            startActivity(intent);
        }
    }

    private void addControls() {
        edtLink = findViewById(R.id.edtLink);
        btnGet = findViewById(R.id.btnGet);
    }
}
