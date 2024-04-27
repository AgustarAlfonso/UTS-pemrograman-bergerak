package com.example.utspemrogramanbergerak.data.retrofit;

import androidx.viewbinding.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiconfig {
    public static Apiservice getApiService() {

        Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Apiservice.class);
    }
}
