package com.santosh.vseeit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2000;

    Animation topanimation,bottomanimation,sideanimate;
    ImageView img;
    TextView txt1,txt2;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        topanimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanimation = AnimationUtils.loadAnimation(this, R.anim.bottomtotop);
        sideanimate = AnimationUtils.loadAnimation(this,R.anim.sideanimation);
        firebaseAuth = FirebaseAuth.getInstance();

        img = findViewById(R.id.img_view);
        txt1 = findViewById(R.id.txt_1);
        txt2 = findViewById(R.id.txt_2);

        txt1.setAnimation(topanimation);
        txt2.setAnimation(bottomanimation);
        img.setAnimation(sideanimate);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser currentUser = firebaseAuth.getCurrentUser();

                if (currentUser == null) {
                    Intent registerintent = new Intent(SplashScreen.this, register.class);
                    startActivity(registerintent);
                    finish();
                } else {
                    Intent mainintent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(mainintent);
                    finish();

                }
            }
        },SPLASH_SCREEN);
    }

}

