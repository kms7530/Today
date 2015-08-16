package com.thepabix.today.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.thepabix.today.R;

import org.androidannotations.annotations.EActivity;

@EActivity()
public class IntroActivity extends Activity {
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        pref = getSharedPreferences("setting", MODE_PRIVATE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent;
                boolean isFirstTime = pref.getBoolean("isFirstTime", true);

                if(isFirstTime) {
                    intent = new Intent(IntroActivity.this, MainActivity.class);
                }
                else {
                    intent = new Intent(IntroActivity.this, MainActivity.class);
                }

                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
