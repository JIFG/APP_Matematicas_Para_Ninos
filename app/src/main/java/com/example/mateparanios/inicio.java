package com.example.mateparanios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class inicio extends AppCompatActivity {
Button btnentrar,btnfacil,btnmedio,btndificil;
MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        btnfacil=findViewById(R.id.btnfacil);
        btnmedio=findViewById(R.id.btnmedio);
        btndificil=findViewById(R.id.btndificl);
        mp= MediaPlayer.create(this,R.raw.musicafondo1);
        mp.start();
        mp.setLooping(true);
        btnfacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facil();
            }
        });
        btnmedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medio();
            }
        });
    }
    public void onBackPressed(){
        Intent div= new Intent(getApplicationContext(), Principal.class);
        startActivity(div);
        finish();
        mp.stop();
    }
    public void onPause() {
        super.onPause();
        mp.pause();
    }
    public void onResume() {
        super.onResume();
        mp.start();
    }


            public void facil(){
            Intent div= new Intent(getApplicationContext(), Sumas.class);
            startActivity(div);
            finish();
            mp.stop();
            }
            public void medio(){
        Toast.makeText(this, "Modo 2 Jugadores",
                        Toast.LENGTH_SHORT).show();
            Intent medio= new Intent(getApplicationContext(),Sumas1medio.class);
            startActivity(medio);
            finish();
                mp.stop();
            }

    }
