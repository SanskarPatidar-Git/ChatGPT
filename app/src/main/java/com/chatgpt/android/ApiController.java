package com.chatgpt.android;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiController {

    private Retrofit retrofit;
    public static ApiController controller;

    public ApiController(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.writeTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        //httpClient.retryOnConnectionFailure(true);
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static ApiController getInstance(){
        if(controller!=null)
            return controller;
        else
            return new ApiController();
    }

    public ApiSets getApiSets(){
        return retrofit.create(ApiSets.class);
    }
}
