package com.lestat.halconmilenario;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final int segundos = 4;
    public static final int milisegundos = 1000*segundos;

    public void cuenta(){
        new CountDownTimer(milisegundos, 1000){
            public void onTick(long millisUntilFinished){

            }
            public void onFinish(){
                Intent login = new Intent(MainActivity.this, login.class);
                startActivity(login);
                finish();
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        cuenta();
    }
}
