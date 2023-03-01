package com.chatgpt.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.chatgpt.android.ApiController;
import com.chatgpt.android.AppConstants;
import com.chatgpt.android.R;
import com.chatgpt.android.SharedPref;
import com.chatgpt.android.databinding.ActivityGetStartedBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetStartedActivity extends AppCompatActivity {

    ActivityGetStartedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGetStartedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(GetStartedActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });

        binding.sendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.chatTv.getText().toString()!=null){
                    String question = binding.chatTv.getText().toString();
                    Call<String> call = ApiController.getInstance().getApiSets().getDataFromApi(question);

                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String answer = response.body();
                            if(response.isSuccessful()){
                                Log.d("answer",answer);
                                //todo

                               // SharedPref.setDataForRequestedOneTime(GetStartedActivity.this);
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.d("failure_api",t.getMessage());
                        }
                    });
                }
            }
        });
    }
}