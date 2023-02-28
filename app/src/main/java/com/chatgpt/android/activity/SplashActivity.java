package com.chatgpt.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.chatgpt.android.SharedPref;
import com.chatgpt.android.databinding.ActivitySplashBinding;


public class SplashActivity extends AppCompatActivity {


    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(SharedPref.checkDataForRequestedOneTime(SplashActivity.this)){
                    Intent intent = new Intent(SplashActivity.this, ChatActivity.class);
                    startActivity(intent);
                    finish();
                }else if(SharedPref.isAppOpened(SplashActivity.this)){
                    Intent intent = new Intent(SplashActivity.this,GetStartedActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(SplashActivity.this,IntroActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },2000);

    }
}