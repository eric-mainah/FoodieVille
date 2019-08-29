package com.example.foodieville2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread move = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(1000);
                    Intent endamain = new Intent(SplashAct.this , MainActivity.class);
                    startActivity(endamain);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        move.start();
    }
}
