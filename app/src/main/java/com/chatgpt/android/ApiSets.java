package com.chatgpt.android;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiSets {

    @POST("abc")
    Call<ResponseBody> getDataFromApi(@Body Data question);
}
