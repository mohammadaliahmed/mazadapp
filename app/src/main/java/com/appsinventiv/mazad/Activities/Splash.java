package com.appsinventiv.mazad.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.appsinventiv.mazad.Activities.Registration.SelectUserType;
import com.appsinventiv.mazad.R;
import com.appsinventiv.mazad.Utils.SharedPrefs;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                if (SharedPrefs.getUser() == null) {
                    Intent i = new Intent(Splash.this, SelectUserType.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(Splash.this, MainActivity.class);
                    startActivity(i);
                }

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
