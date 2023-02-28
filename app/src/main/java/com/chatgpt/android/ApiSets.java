package com.chatgpt.android;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiSets {

    @POST("abc")
    Call<String> getDataFromApi(@Body String question);
}
