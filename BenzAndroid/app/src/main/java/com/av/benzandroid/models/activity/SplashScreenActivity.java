package com.av.benzandroid.models.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.av.benzandroid.R;

public class SplashScreenActivity extends AppCompatActivity {

    public static SplashScreenActivity INSTANCE = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        INSTANCE = this;


        int myTimer = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    /* code for interstitial ad redirection */
//                    if(PSingleton.getAdCount() == 1){
//                            Intent intent = new Intent(SplashScreenActivity.INSTANCE, InterstitialsActivity.class);
//                            startActivity(intent);
//                            overridePendingTransition(R.anim.slide_up, R.anim.animate_fade_out);
//                            finish();
//                    } else {
                Intent i = new Intent(SplashScreenActivity.INSTANCE, MainActivity.class);
                startActivity(i);
                finish(); // close this activity
//                    }

            }
        }, myTimer);



    }
}
