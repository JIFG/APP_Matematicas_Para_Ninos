package com.example.mateparanios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class mayorque_medio extends AppCompatActivity {

        TextView cuadro1,cuadro2,resultado1;
        ImageView iv_vidas,iv_aciertos;
        int var1,var2,var3,var4,var5,res1,res2,res3,res4;
        Button eva,btnsum1,btnsum2,btnsum3;
        MediaPlayer mp,mpbien,mpmal,mpbtn;
        int vidas = 3, intentos= 0;
        String string_vidas;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mayorque_medio);
            eva = findViewById(R.id.btnevaluar);
            iv_vidas=findViewById(R.id.iv_vidas);
            string_vidas=getIntent().getStringExtra("vidas");
            vidas=Integer.parseInt(string_vidas);
            if(vidas==3){
                iv_vidas.setImageResource(R.drawable.tresvidas);
            }if(vidas==2){
                iv_vidas.setImageResource(R.drawable.dosvidas);
            }
            if(vidas==1){
                iv_vidas.setImageResource(R.drawable.unavidat);
            }
            //Nivel
            Toast.makeText(this, "Nivel 4-Comparaciones", Toast.LENGTH_SHORT).show();
            //canciones
            mp = MediaPlayer.create(this, R.raw.goats);
            mp.start();
            mp.setLooping(true);
            //sonidos
            mpbien = MediaPlayer.create(this, R.raw.sonidowin2);
            mpmal = MediaPlayer.create(this, R.raw.bad);
            mpbtn = MediaPlayer.create(this, R.raw.clickk);
            resultado1 = findViewById(R.id.resultado1);
            cuadro1 = findViewById(R.id.cuadro1);
            cuadro2 = findViewById(R.id.cuadro2);
            resultado1.setText("");
            btnsum1 = findViewById(R.id.btnsum1);
            btnsum2 = findViewById(R.id.btnsum2);
            btnsum3 = findViewById(R.id.btnsum3);
            iv_vidas = findViewById(R.id.iv_vidas);
            iv_aciertos=findViewById(R.id.iv_aciertos4);
            aleatorios();
            btnsum1.setText("<");
            btnsum2.setText("=");
            btnsum3.setText(">");

            btnsum1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if( var1 < var2){
                        mpbien.start();
                        resultado1.setText("");
                        resultado1.setText("<");
                        intentos();
                        aleatorios();
                        Toast acierto1 = Toast.makeText(getApplicationContext(), "VALOR 1 MENOR QUE VALOR 2", Toast.LENGTH_LONG);
                        acierto1.show();
                    }else{
                        mpmal.start();
                        vidas();
                        aleatorios();
                        Toast acierto1 = Toast.makeText(getApplicationContext(), "INCORRECTO", Toast.LENGTH_LONG);
                        acierto1.show();
                    }
                }
            });
            btnsum2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if( var1 == var2){
                        mpbien.start();
                        resultado1.setText("");
                        resultado1.setText("=");
                        intentos();
                        aleatorios();
                        Toast acierto2 = Toast.makeText(getApplicationContext(), "VALOR 1 IGUAL QUE VALOR 2", Toast.LENGTH_LONG);
                        acierto2.show();
                    }else{
                        mpmal.start();
                        Toast mal = Toast.makeText(getApplicationContext(), "INCORRECTO", Toast.LENGTH_LONG);
                        mal.show();
                        vidas();
                        aleatorios();
                    }

                }
            });
            btnsum3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if( var1 > var2){
                        mpbien.start();
                        resultado1.setText("");
                        resultado1.setText(">");
                        intentos();
                        aleatorios();
                        Toast acierto1 = Toast.makeText(getApplicationContext(), "VALOR 1 MAYOR QUE VALOR 2", Toast.LENGTH_LONG);
                        acierto1.show();
                    }else{
                        mpmal.start();
                        Toast mal = Toast.makeText(getApplicationContext(), "INCORRECTO", Toast.LENGTH_LONG);
                        mal.show();
                        vidas();
                        aleatorios();
                    }
                }
            });
        }


        public void intentos() {
            mpbien.start();
            intentos++;
            switch (intentos) {
                case 1:
                    iv_aciertos.setImageResource(R.drawable.unaciertot);
                    break;
                case 2:
                    iv_aciertos.setImageResource(R.drawable.dosaciertost);
                    break;
                case 3:
                    iv_aciertos.setImageResource(R.drawable.tresaciertos);
                    mostrarDialogoPersonalizado();
                    break;
            }
        }

        public void vidas(){
            mpmal.start();
            vidas--;
            switch (vidas){
                case 3:
                    iv_vidas.setImageResource(R.drawable.tresvidas);
                    break;
                case 2:
                    iv_vidas.setImageResource(R.drawable.dosvidas);
                    Toast dosvidas= Toast.makeText(getApplicationContext(),"Te quedan 2 vidas",Toast.LENGTH_SHORT);
                    dosvidas.show();
                    break;
                case 1:
                    iv_vidas.setImageResource(R.drawable.unavidat);
                    Toast unavida= Toast.makeText(getApplicationContext(),"Te queda una vida",Toast.LENGTH_SHORT);
                    unavida.show();
                    break;
                case 0:
                    iv_vidas.setImageResource(R.drawable.sinvidast);
                    Toast sinvidas= Toast.makeText(getApplicationContext(),"Perdiste todas las vidas",Toast.LENGTH_SHORT);
                    sinvidas.show();
                    Intent intent= new Intent(getApplicationContext(), inicio.class);
                    startActivity(intent);
                    finish();
                    mp.stop();
                    mp.release();
                    break;

            }}

        // Generación Numeros Aleatorios
        public void aleatorios(){
            var1 = (int) Math.floor(Math.random()*(50-1+1)+1);
            var2 = (int) Math.floor(Math.random()*(50-1+1)+1);
            String VAR1 = Integer.toString(var1);
            String VAR2 = Integer.toString(var2);
            cuadro1.setText(VAR1);
            cuadro2.setText(VAR2);
        }
        public void onBackPressed(){

        }

        public void mostrarDialogoPersonalizado(){

            AlertDialog.Builder builder= new AlertDialog.Builder(com.example.mateparanios.mayorque_medio.this);
            LayoutInflater inflater= getLayoutInflater();
            View view= inflater.inflate(R.layout.dialogopersonalizado,null);
            builder.setView(view);
            //Btn retry
            AlertDialog dialog= builder.create();
            dialog.show();
            TextView txt= view.findViewById(R.id.text_dialog);
            txt.setText("");
            //btn Dialog
            Button btncontinuar= view.findViewById(R.id.btncontinuar);
            btncontinuar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ganador= new Intent(getApplicationContext(),ganador007.class);
                    string_vidas= String.valueOf(vidas);
                    ganador.putExtra("vidas",string_vidas);
                    startActivity(ganador);
                    finish();
                    mp.stop();
                    mp.release();
                }
            });

        }


    }