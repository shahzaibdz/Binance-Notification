package com.example.binancenotificaton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        int secondDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              startActivity(new Intent(Splash_activity.this, MainActivity.class));
                finish();
            }
        }, secondDelayed * 2500);

    }
}