package com.rin2407.layoutexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void choiceCL(View view) {
        TextView choice=findViewById(R.id.choiceTV);
        ImageView turtleImage =findViewById(R.id.turtleImage);
        switch (view.getId()){
            case R.id.idluffy:
                choice.setText("This is Luffy");
                turtleImage.setImageDrawable(getResources().getDrawable(R.drawable.luffy));
                break;
            case R.id.idnami:
                choice.setText("This is Nami");
                turtleImage.setImageDrawable(getResources().getDrawable(R.drawable.nami));
                break;
            case R.id.idzoro:
                choice.setText("This is zoro");
                turtleImage.setImageDrawable(getResources().getDrawable(R.drawable.zoro));
                break;
            case R.id.idrobin:
                choice.setText("This is Robin");
                turtleImage.setImageDrawable(getResources().getDrawable(R.drawable.robin));
                break;
                default:
                    break;
        }
    }

    public void imageDisplay(View view) {
        Switch theSwitch= findViewById(R.id.displaySwitch);
        ImageView turtleImage = findViewById(R.id.turtleImage);
        if(theSwitch.isChecked()){
            turtleImage.setVisibility(view.VISIBLE);
        }
        else{
            turtleImage.setVisibility(view.INVISIBLE);
        }
    }
}
