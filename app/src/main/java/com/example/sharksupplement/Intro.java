package com.example.sharksupplement;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Intro extends AppCompatActivity {

    private static int SPLASH_SCREEN=3500;

    //Variables
    Animation topAmin, bottomAmin;
    ImageView logo;
    TextView tenapp, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_intro);

        //Animations
        topAmin = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAmin = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks
        logo = findViewById(R.id.imageView);
        tenapp = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView2);

        logo.setAnimation(topAmin);
        tenapp.setAnimation(bottomAmin);
        slogan.setAnimation(bottomAmin);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Intro.this,Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}