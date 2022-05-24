package com.example.mateparanios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ganador007 extends AppCompatActivity {
    MediaPlayer ganador;
    Button btninicio,btnretry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganador007);
        ganador = MediaPlayer.create(this,R.raw.yei);
        ganador.start();
        ganador.setLooping(true);
        btnretry=findViewById(R.id.btnretry);
        btninicio=findViewById(R.id.btninicio);
        btnretry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent QUIZ= new Intent(getApplicationContext(),Sumas.class);
                startActivity(QUIZ);
                ganador.stop();
                ganador.release();
                finish();

            }
        });
        btninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent principal= new Intent(getApplicationContext(), com.example.mateparanios.Principal.class);
                startActivity(principal);
                ganador.stop();
                ganador.release();
                finish();
            }
        });
    }
    public void onBackPressed(){

    }


}
