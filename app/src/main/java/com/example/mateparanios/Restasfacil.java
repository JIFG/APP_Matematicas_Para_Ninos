package com.example.mateparanios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Restasfacil extends AppCompatActivity {
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
        setContentView(R.layout.activity_restasfacil);
        eva=findViewById(R.id.btnevaluar);
        //Nivel
        Toast.makeText(this,"Nivel 3-Restas basicas",Toast.LENGTH_SHORT).show();
        //canciones
        mp= MediaPlayer.create(this,R.raw.goats);
        mp.start();
        mp.setLooping(true);
        //sonidos
        mpbien= MediaPlayer.create(this,R.raw.sonidowin2);
        mpmal=MediaPlayer.create(this,R.raw.bad);
        mpbtn=MediaPlayer.create(this,R.raw.clickk);
        //VIDAS
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
        resultado1=findViewById(R.id.resultado1);
        cuadro1=findViewById(R.id.cuadro1);
        cuadro2=findViewById(R.id.cuadro2);
        resultado1.setText("");
        btnsum1=findViewById(R.id.btnsum1);
        btnsum2=findViewById(R.id.btnsum2);
        btnsum3=findViewById(R.id.btnsum3);
        iv_vidas=findViewById(R.id.iv_vidas);
        iv_aciertos=findViewById(R.id.iv_aciertos3);
        aleatorios();
        ordenbtns();


        eva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(resultado1.getText()==Integer.toString(res1)) {
                        mpbien.start();
                        intentos++;
                        switch (intentos){
                            case 1:
                                Toast acierto1= Toast.makeText(getApplicationContext(),"Excelente",Toast.LENGTH_LONG);
                                acierto1.show();
                                iv_aciertos.setImageResource(R.drawable.unaciertot);
                                nuevosnum();
                                break;
                            case 2:
                                Toast acierto2= Toast.makeText(getApplicationContext(),"Muy Bien",Toast.LENGTH_LONG);
                                acierto2.show();
                                iv_aciertos.setImageResource(R.drawable.dosaciertost);
                                nuevosnum();
                                break;
                            case 3:
                                iv_aciertos.setImageResource(R.drawable.tresaciertos);
                                mostrarDialogoPersonalizado();
                                break;
                        }
                    }else{
                        if(resultado1.getText()==("")){
                            mpmal.start();
                            Toast vacio= Toast.makeText(getApplicationContext(),"Presiona Un Resultado",Toast.LENGTH_LONG);
                            vacio.show();
                        }else{
                            resultado1.setText("");
                            mpmal.start();
                            vidas--;
                            switch (vidas){
                                case 3:
                                    iv_vidas.setImageResource(R.drawable.tresvidas);
                                    nuevosnum();
                                    break;
                                case 2:
                                    iv_vidas.setImageResource(R.drawable.dosvidas);
                                    Toast dosvidas= Toast.makeText(getApplicationContext(),"Te quedan 2 vidas",Toast.LENGTH_SHORT);
                                    dosvidas.show();
                                    vaciarnumeros();
                                    aleatorios();
                                    ordenbtns();
                                    break;
                                case 1:
                                    iv_vidas.setImageResource(R.drawable.unavidat);
                                    Toast unavida= Toast.makeText(getApplicationContext(),"Te queda una vida",Toast.LENGTH_SHORT);
                                    unavida.show();
                                    vaciarnumeros();
                                    aleatorios();
                                    ordenbtns();
                                    break;
                                case 0:
                                    iv_vidas.setImageResource(R.drawable.sinvidast);
                                    Toast sinvidas= Toast.makeText(getApplicationContext(),"Perdiste todas las vidas",Toast.LENGTH_SHORT);
                                    sinvidas.show();
                                    Intent intent= new Intent(getApplicationContext(), inicio.class);
                                    startActivity(intent);

                                    mp.stop();
                                    mp.release();
                                    finish();
                                    break;

                            }



                        }}
                }catch (Exception e){
                    Toast error= Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT);
                    error.show();
                }
            }});
        btnsum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado1.setText(btnsum1.getText());
                mpbtn.start();

            }
        });
        btnsum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado1.setText(btnsum2.getText());
                mpbtn.start();
            }
        });
        btnsum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado1.setText(btnsum3.getText());
                mpbtn.start();
            }
        });

    }


    public void nuevosnum(){
        vaciarnumeros();
        aleatorios();
        ordenbtns();
        resultado1.setText("");
    }
    //vaciar
    public void vaciarnumeros(){
        cuadro1.setText("");
        cuadro2.setText("");
        btnsum1.setText("");
        btnsum2.setText("");
        btnsum3.setText("");
    }
    // Generación Numeros Aleatorios
    public void aleatorios(){
        var1 = (int) Math.floor(Math.random()*(7-1+1)+5);
        var2 = (int) Math.floor(Math.random()*(5-1+1)+1);
        var3 = (int) Math.floor(Math.random()*(5-1+1)+1);
        var4 = (int) Math.floor(Math.random()*(5-1+1)+1);
        var5 = (int) Math.floor(Math.random()*(5-1+1)+1);
        res1=Math.abs(var1-var2);
        res2=Math.abs(res1+5);
        res3=Math.abs(res1+2);
        res4=Math.abs(res1+3);
        String VAR1 = Integer.toString(var1);
        String VAR2 = Integer.toString(var2);

        cuadro1.setText(VAR1);
        cuadro2.setText(VAR2);
    }


    public void onBackPressed(){

    }
    public void mostrarDialogoPersonalizado(){

        AlertDialog.Builder builder= new AlertDialog.Builder(Restasfacil.this);
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
                Intent mayorquefacil= new Intent(getApplicationContext(),mayorque_facil.class);
                string_vidas= String.valueOf(vidas);
                mayorquefacil.putExtra("vidas",string_vidas);
                startActivity(mayorquefacil);
                finish();
                mp.stop();
                mp.release();
            }
        });

    }
    public void ordenbtns(){
        String VAR3 = Integer.toString(res4);
        String VAR4 = Integer.toString(res3);
        String VAR5 = Integer.toString(res2);
        String resultado = String.valueOf(res1);
        if(res1<=15){
            btnsum1.setText(resultado);
            btnsum2.setText(VAR4);
            btnsum3.setText(VAR3);
        }else{
            btnsum1.setText(VAR5);
            btnsum3.setText(VAR4);
            btnsum2.setText(resultado);
        }if(res1>=30){
            btnsum1.setText(VAR3);
            btnsum2.setText(VAR4);
            btnsum3.setText(resultado);
        }
    }


}