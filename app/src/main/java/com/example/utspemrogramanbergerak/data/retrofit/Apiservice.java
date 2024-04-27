package com.example.utspemrogramanbergerak.data.retrofit;

import com.example.utspemrogramanbergerak.data.response.Account;
import com.example.utspemrogramanbergerak.data.response.AccountResponse;

import retrofit2.Call;

import retrofit2.http.*;

public interface Apiservice {

    @GET("search/users")
    Call<AccountResponse> searchUsers(@Query("q") String query);

    @GET("users/{username}")
    Call<Account> getUser(@Path("username") String username);

}