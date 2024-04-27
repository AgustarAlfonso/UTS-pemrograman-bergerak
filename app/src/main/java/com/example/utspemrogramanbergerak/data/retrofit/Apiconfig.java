package com.example.utspemrogramanbergerak.data.retrofit;

import androidx.viewbinding.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiconfig {
    public static Apiservice getApiservice(){
        HttpLoggingInterceptor loggingInterceptor;

        if (BuildConfig.DEBUG)
        {
            loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        else {
            loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        Retrofit retrofit = new retrofit2.Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).client(client).build();

        return retrofit.create(Apiservice.class);



    }
}
