package com.rin2407.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class HomeTicTocToe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tic_toc_toe);
       Button btnHome= findViewById(R.id.btn_newgame);
       btnHome.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intentNewGame=new Intent(HomeTicTocToe.this,MainActivity.class);
               startActivity(intentNewGame);
           }
       });
       Button btnQuit= findViewById(R.id.btn_quitgame);
       btnQuit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               AlertDialog.Builder builder= new AlertDialog.Builder(HomeTicTocToe.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
               builder.setTitle("Bạn chắc chắn muốn đóng ứng dụng");
               builder.setMessage("Hãy lựa chọn bên dưới để xác nhận");
               builder.setIcon(android.R.drawable.ic_dialog_alert);
               builder.setPositiveButton("có", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                       homeIntent.addCategory( Intent.CATEGORY_HOME );
                       homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                       startActivity(homeIntent);
                   }
               });
               builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {

                   }
               });
               builder.show();
           }
       });
    }
}
