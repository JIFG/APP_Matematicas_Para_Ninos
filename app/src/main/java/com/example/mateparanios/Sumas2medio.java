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

public class Sumas2medio extends AppCompatActivity {
    TextView cuadro3,cuadro4,resultado2;
    ImageView iv_vidas,iv_aciertos;
    int var1,var2,var3,res1,res2,res3,res4,res5;
    Button btnevaluar2, btnsum21,btnsum22,btnsum23;
    MediaPlayer mp,mpbien,mpmal,mpbtn;
    String string_vidas;
    int vidas=3,intentos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumas2medio);
        //recuperar vidas
        iv_vidas=findViewById(R.id.iv_vidas);
        string_vidas=getIntent().getStringExtra("vidas");
        Toast.makeText(this, "Nivel 2-Encuentra el valor", Toast.LENGTH_SHORT).show();
        vidas=Integer.parseInt(string_vidas);
        if(vidas==3){
            iv_vidas.setImageResource(R.drawable.tresvidas);
        }if(vidas==2){
            iv_vidas.setImageResource(R.drawable.dosvidas);
        }
        if(vidas==1){
            iv_vidas.setImageResource(R.drawable.unavidat);
        }
        //canciones
        mp= MediaPlayer.create(this,R.raw.goats);
        mp.start();
        mp.setLooping(true);
        //sonidos
        mpbien= MediaPlayer.create(this,R.raw.sonidowin2);
        mpmal=MediaPlayer.create(this,R.raw.bad);
        mpbtn=MediaPlayer.create(this,R.raw.clickk);

        btnevaluar2=findViewById(R.id.btnevaluar);
        btnsum21=findViewById(R.id.btnsum1);
        btnsum22=findViewById(R.id.btnsum2);
        btnsum23=findViewById(R.id.btnsum3);
        cuadro3=findViewById(R.id.cuadro1);
        cuadro4=findViewById(R.id.cuadro2);
        resultado2=findViewById(R.id.resultado1);
        iv_aciertos=findViewById(R.id.iv_aciertos2);
        cuadro4.setText("");
        String VAR1 = Integer.toString(var1);
        String VAR2 = Integer.toString(var2);
        String resultado = String.valueOf(res1);
        aleatorios();
        ordenbtns();
        btnevaluar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(cuadro4.getText()==Integer.toString(res2)) {
                        intentos++;
                        switch (intentos){
                            case 1:
                                mpbien.start();

                                Toast acierto1= Toast.makeText(getApplicationContext(),"Excelente",Toast.LENGTH_LONG);
                                acierto1.show();
                                iv_aciertos.setImageResource(R.drawable.unaciertot);
                                nuevosnum();
                                break;
                            case 2:
                                mpbien.start();
                                Toast acierto2= Toast.makeText(getApplicationContext(),"Muy Bien",Toast.LENGTH_LONG);
                                acierto2.show();
                                iv_aciertos.setImageResource(R.drawable.dosaciertost);
                                nuevosnum();
                                break;
                            case 3:
                                mpbien.start();
                                iv_aciertos.setImageResource(R.drawable.tresaciertos);
                                dialogpersonalizado();

                                break;
                        }
                    }else{
                        if(cuadro4.getText()==("")){
                            mpmal.start();
                            Toast vacio= Toast.makeText(getApplicationContext(),"Presiona Un Resultado",Toast.LENGTH_LONG);
                            vacio.show();
                        }else{
                            cuadro4.setText("");
                            mpmal.start();
                            vidas--;
                            switch (vidas){
                                case 3:

                                    iv_vidas.setImageResource(R.drawable.tresvidas);
                                    mpmal.start();
                                    nuevosnum();
                                    break;
                                case 2:
                                    iv_vidas.setImageResource(R.drawable.dosvidas);
                                    mpmal.start();
                                    Toast dosvidas= Toast.makeText(getApplicationContext(),"Te quedan 2 vidas",Toast.LENGTH_SHORT);
                                    dosvidas.show();
                                    vaciarnumeros();
                                    aleatorios();
                                    ordenbtns();
                                    break;
                                case 1:
                                    iv_vidas.setImageResource(R.drawable.unavidat);
                                    mpmal.start();
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
                                    finish();
                                    mp.stop();
                                    mp.release();
                                    break;

                            }



                        }}
                }catch (Exception e){
                    Toast error= Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT);
                    error.show();
                }
            }});
        btnsum21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpbtn.start();
                cuadro4.setText(btnsum21.getText());
            }
        });
        btnsum22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpbtn.start();
                cuadro4.setText(btnsum22.getText());
            }
        });
        btnsum23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpbtn.start();
                cuadro4.setText(btnsum23.getText());
            }
        });
    }
    public void onBackPressed(){

    }


    public void dialogpersonalizado() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Sumas2medio.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogopersonalizado, null);
        builder.setView(view);
        //Btn retry
        AlertDialog dialog = builder.create();
        dialog.show();
        TextView txt = view.findViewById(R.id.text_dialog);
        txt.setText("");
        //btn Dialog
        Button btncontinuar = view.findViewById(R.id.btncontinuar);
        btncontinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restasfacil= new Intent(getApplicationContext(),Restas2medio.class);
                string_vidas= String.valueOf(vidas);
                restasfacil.putExtra("vidas",string_vidas);
                startActivity(restasfacil);
                finish();
                mp.stop();
                mp.release();
            }
        });
    }
    public void nuevosnum(){
        vaciarnumeros();
        aleatorios();
        ordenbtns();
    }
    //vaciar
    public void vaciarnumeros(){
        cuadro3.setText("");
        cuadro4.setText("");
        btnsum21.setText("");
        btnsum22.setText("");
        btnsum23.setText("");
        resultado2.setText("");
    }
    public void aleatorios(){
        var1 = (int) Math.floor(Math.random()*(50-1+1)+1);
        var2 = (int) Math.floor(Math.random()*(50-1+1)+1);
        var3 = (int) Math.floor(Math.random()*(50-1+1)+1);
        res1=var1+var2;//resultado suma
        res2=Math.abs(var1-res1);//resultado cuadro faltante
        res3=Math.abs(res2-2);
        res4=Math.abs(res2-3);
        res5=Math.abs(res1-5);
        String VAR1=Integer.toString(var1);
        String VAR2=Integer.toString(res1);
        cuadro3.setText(VAR1);
        resultado2.setText(VAR2);

    }
    private void ordenbtns() {
        String VAR1 = Integer.toString(res4);
        String VAR2 = Integer.toString(res5);
        String VAR3 = Integer.toString(res2);
        String VAR4 = Integer.toString(res3);

        if(res2<=3){
            btnsum21.setText(VAR3);
            btnsum22.setText(VAR2);
            btnsum23.setText(VAR4);
        }else{
            btnsum21.setText(VAR1);
            btnsum22.setText(VAR3);
            btnsum23.setText(VAR4);
        }if(res2>=6){
            btnsum21.setText(VAR4);
            btnsum22.setText(VAR1);
            btnsum23.setText(VAR3);
        }
    }

}

