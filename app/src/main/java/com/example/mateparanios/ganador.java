package com.example.mateparanios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ganador extends AppCompatActivity {
    MediaPlayer ganador;
    Button btninicio,btnretry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganador);
        ganador = MediaPlayer.create(this,R.raw.yei);
        ganador.start();
        ganador.setLooping(true);
        btnretry=findViewById(R.id.btnretry);
        btninicio=findViewById(R.id.btninicio);
        btnretry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dosjugadores= new Intent(getApplicationContext(),dosjugadores.class);
                startActivity(dosjugadores);
                ganador.stop();
                ganador.release();
                finish();

            }
        });
        btninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio= new Intent(getApplicationContext(), com.example.mateparanios.Principal.class);
                startActivity(inicio);
                ganador.stop();
                ganador.release();
                finish();
            }
        });
    }
    public void onBackPressed(){

    }


}