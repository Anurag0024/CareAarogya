package com.example.care_arogya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash_Screen extends AppCompatActivity {
    private ImageView logo2;
    private static int splashTimeout= 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        logo2= findViewById(R.id.id2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(Splash_Screen.this, MainActivity.class);
                startActivity(in);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        },splashTimeout);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mysplashanimation);
        logo2.startAnimation(myanim);
    }
}