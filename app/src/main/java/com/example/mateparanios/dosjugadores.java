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

public class dosjugadores extends AppCompatActivity {

    TextView cuadrodown1,cuadrodown2,result1,cuadroup1,cuadroup2,resup;
    ImageView iv_aciertos,iv_aciertos2;
    int var1,var2,var3,var4,var5,res1,res2,res3,res4;
    Button evaup,btnup1,btnup2,btnup3;
    Button evadown,btndown1,btndown2,btndown3;
    MediaPlayer mp,mpbien,mpmal,mpbtn;
    int  aciertos= 0,aciertos2=0;
    String string_vidas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dosjugadores);
        //canciones
        mp= MediaPlayer.create(this,R.raw.goats);
        mp.start();
        mp.setLooping(true);
        //sonidos
        mpbien= MediaPlayer.create(this,R.raw.sonidowin2);
        mpmal=MediaPlayer.create(this,R.raw.bad);
        mpbtn=MediaPlayer.create(this,R.raw.clickk);
        resup=findViewById(R.id.resup);
        cuadroup1=findViewById(R.id.cuadroup1);
        cuadroup2=findViewById(R.id.cuadroup2);
        resup.setText("");
        btnup1=findViewById(R.id.btn1);
        btnup2=findViewById(R.id.btn2);
        btnup3=findViewById(R.id.btn3);
        btndown1=findViewById(R.id.btn4);
        btndown2=findViewById(R.id.btn5);
        btndown3=findViewById(R.id.btn6);
        cuadrodown1=findViewById(R.id.cuadrodown1);
        cuadrodown2=findViewById(R.id.cuadrodown2);
        result1=findViewById(R.id.result1);
        iv_aciertos=findViewById(R.id.iv_aciertos5);
        iv_aciertos2=findViewById(R.id.iv_aciertos6);
        aleatorios();
        ordenbtns();
        btndown1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result1.setText(btndown1.getText());
                mpbtn.start();
                if(result1.getText()==Integer.toString(res1)) {
                intentos();
                aleatorios();
                ordenbtns();
                    mp.stop();
            }else{
                mpmal.start();
                }
            }
        });
        btndown2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result1.setText(btndown2.getText());
                mpbtn.start();
                if(result1.getText()==Integer.toString(res1)) {
                intentos();
                    aleatorios();
                    ordenbtns();
                    mp.stop();
                }else{
                    mpmal.start();
                }}
        });
        btndown3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result1.setText(btndown3.getText());
                mpbtn.start();
                if(result1.getText()==Integer.toString(res1)) {
                    intentos();
                    aleatorios();
                    ordenbtns();
                    mp.stop();
                }else {
                    mpmal.start();
                }}
        });
        btnup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resup.setText(btnup1.getText());
                mpbtn.start();
                if(resup.getText()==Integer.toString(res1)) {
                intentos2();
                    aleatorios();
                    ordenbtns();
                mp.stop();

               }else{
                    mpmal.start();}
            }
        });
        btnup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resup.setText(btnup2.getText());
                mpbtn.start();
                if(resup.getText()==Integer.toString(res1)) {
                intentos2();
                    aleatorios();
                    ordenbtns();
                }else{
                    mpmal.start();}}
        });
        btnup3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resup.setText(btnup3.getText());
                mpbtn.start();
                if(resup.getText()==Integer.toString(res1)) {
                    intentos2();
                    aleatorios();
                    ordenbtns();
                    mp.stop();
                }else{
                    mpmal.start();}
                }
        });
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
    public void intentos() {
        mpbien.start();
        aciertos++;
        switch (aciertos) {
            case 1:
                iv_aciertos.setImageResource(R.drawable.unaciertot);
                break;
            case 2:
                iv_aciertos.setImageResource(R.drawable.dosaciertost);
                break;
            case 3:
                iv_aciertos.setImageResource(R.drawable.tresaciertos);
                Intent intent= new Intent(getApplicationContext(),ganador.class);
                startActivity(intent);
                finish();
                mp.stop();

                break;
        }
    }
    public void intentos2() {
        mpbien.start();
        aciertos2++;
        switch (aciertos2) {
            case 1:
                iv_aciertos2.setImageResource(R.drawable.unaciertot);
                break;
            case 2:
                iv_aciertos2.setImageResource(R.drawable.dosaciertost);
                break;
            case 3:
                iv_aciertos2.setImageResource(R.drawable.tresaciertos);
                Intent intent= new Intent(getApplicationContext(),winnerup.class);
                startActivity(intent);
                finish();
                mp.stop();

                break;
        }
    }


    public void aleatorios(){
        var1 = (int) Math.floor(Math.random()*(10-1+1)+1);
        var2 = (int) Math.floor(Math.random()*(10-1+1)+1);
        var3 = (int) Math.floor(Math.random()*(10-1+1)+1);
        var4 = (int) Math.floor(Math.random()*(10-1+1)+1);
        var5 = (int) Math.floor(Math.random()*(10-1+1)+1);
        res1=var1+var2;
        res2=Math.abs(res1-5);
        res3=Math.abs(res1-2);
        res4=Math.abs(res1-7);
        String VAR1 = Integer.toString(var1);
        String VAR2 = Integer.toString(var2);

        cuadroup1.setText(VAR1);
        cuadroup2.setText(VAR2);

        cuadrodown1.setText(VAR1);
        cuadrodown2.setText(VAR2);
    }
    public void ordenbtns(){
        String VAR3 = Integer.toString(res4);
        String VAR4 = Integer.toString(res3);
        String VAR5 = Integer.toString(res2);
        String resultado = String.valueOf(res1);
        if(res1<=5){
            btnup1.setText(resultado);
            btnup2.setText(VAR4);
            btnup3.setText(VAR3);

            btndown1.setText(resultado);
            btndown2.setText(VAR4);
            btndown3.setText(VAR3);

        }else{
            btnup1.setText(VAR5);
            btnup3.setText(VAR4);
            btnup2.setText(resultado);

            btndown1.setText(VAR5);
            btndown3.setText(VAR4);
            btndown2.setText(resultado);

        }if(res1>10){
            btnup1.setText(VAR3);
            btnup2.setText(VAR4);
            btnup3.setText(resultado);

            btndown1.setText(VAR3);
            btndown2.setText(VAR4);
            btndown3.setText(resultado);
        }
    }

}