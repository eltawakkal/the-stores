package com.example.thebestone.thestores.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.thebestone.thestores.R;

/**
 * Created by thebestone on 10/8/17.
 */

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_spalsh);

        new CountDownTimer(3000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        }.start();
    }
}
