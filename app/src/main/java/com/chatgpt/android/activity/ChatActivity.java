package com.chatgpt.android.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.chatgpt.android.ApiController;
import com.chatgpt.android.AppConstants;
import com.chatgpt.android.ChatAdapter;
import com.chatgpt.android.ChatModel;
import com.chatgpt.android.databinding.ActivityChatBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatActivity extends AppCompatActivity {

    ActivityChatBinding binding;
    List<ChatModel> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setAdapter();
        binding.sendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = binding.chatTv.getText().toString();
                if(!query.equals("")){
                    ChatModel model =new ChatModel(AppConstants.SENDER_TYPE,query);
                    getDataFromAPI(query);
                    modelList.add(model);
                }
            }
        });
    }
    private void getDataFromAPI(String query){
        Call<String> call = ApiController.getInstance().getApiSets().getDataFromApi(query);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String data = response.body();
                if(response.isSuccessful()){
                    ChatModel model = new ChatModel(AppConstants.RECEIVER_TYPE,data);
                    modelList.add(model);

                }else
                    Log.d("failure_response",response.message());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("error",t.getMessage());
            }
        });
    }
    private void setAdapter(){
        ChatAdapter adapter = new ChatAdapter(ChatActivity.this,modelList);
        binding.chatRecyclerView.setAdapter(adapter);
    }
}