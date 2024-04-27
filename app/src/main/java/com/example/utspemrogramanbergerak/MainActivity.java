package com.example.utspemrogramanbergerak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utspemrogramanbergerak.data.response.Account;
import com.example.utspemrogramanbergerak.data.response.AccountResponse;
import com.example.utspemrogramanbergerak.data.retrofit.Apiconfig;
import com.example.utspemrogramanbergerak.data.retrofit.Apiservice;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GithubAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleview);

        Apiservice apiService = Apiconfig.getApiservice();
        Call<AccountResponse> call = apiService.searchUsers("diki");

        call.enqueue(new Callback<AccountResponse>() {
            @Override
            public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Account> users = response.body().getAccounts();
                    adapter = new GithubAdapter(users);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                } else {
                    Toast.makeText(MainActivity.this, "Failed to get users", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AccountResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}