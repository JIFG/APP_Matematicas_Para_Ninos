package com.example.mateparanios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    MediaPlayer mp;
    Button btnunjugador,btndosjugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        mp= MediaPlayer.create(this,R.raw.musicafondo1);
        mp.start();
        mp.setLooping(true);
        btnunjugador=findViewById(R.id.btn1jugador);
        btndosjugadores=findViewById(R.id.btn2jugadores);
        btnunjugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            unjugador();
            }
        });
        btndosjugadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dosjugadores();
            }
        });
    }
    public void unjugador(){
        Intent menu= new Intent(getApplicationContext(), inicio.class);
        startActivity(menu);
        finish();
        mp.stop();
    }
    public void dosjugadores(){
        Toast.makeText(this, "Modo 2 Jugadores",
                Toast.LENGTH_SHORT).show();
        Intent dosjug= new Intent(getApplicationContext(),dosjugadores.class);
        startActivity(dosjug);
        mp.stop();
    }
    public void onBackPressed(){

    }
    public void onPause() {
        super.onPause();
        mp.pause();
    }
    public void onResume() {
        super.onResume();
        mp.start();
    }
}