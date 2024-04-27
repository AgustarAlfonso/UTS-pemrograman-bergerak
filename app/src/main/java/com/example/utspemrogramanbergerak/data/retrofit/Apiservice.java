package com.example.utspemrogramanbergerak.data.retrofit;

import com.example.utspemrogramanbergerak.data.response.Account;
import com.example.utspemrogramanbergerak.data.response.AccountResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Apiservice {
    @Headers({"Authorization: token <MY_TOKEN>"})
    @GET("search/users")
    Call<AccountResponse> searchUsers(@Query("q") String query);

    @Headers({"Authorization: token <MY_TOKEN>"})
    @GET("users/{username}")
    Call<Account> getUser(@Path("username") String username);

}
