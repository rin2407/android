package com.rin2407.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Country> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new CustomListAdapter(this,image_details));

        // Khi người dùng click vào các ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Country country = (Country) o;
                Toast.makeText(MainActivity.this, "Selected :" + " " + country, Toast.LENGTH_LONG).show();
            }
        });
    }

    private  List<Country> getListData() {
        List<Country> list = new ArrayList<Country>();
        Country luffy = new Country("Monkey D. Luffy", "luffy", 1500000000);
        Country zoro = new Country("Roronoa Zoro", "zoro1", 320000000);
        Country sanji = new Country("Sanji", "sanji", 330000000);
        Country brook = new Country("Brook", "brook", 120000000);
        Country chopper = new Country("Tony Tony Chopper", "chopper", 50);


        list.add(luffy);
        list.add(zoro);
        list.add(sanji);
        list.add(brook);
        list.add(chopper);

        return list;
    }
}
