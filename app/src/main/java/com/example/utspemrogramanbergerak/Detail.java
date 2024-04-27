package com.example.utspemrogramanbergerak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utspemrogramanbergerak.data.response.Account;
import com.example.utspemrogramanbergerak.data.retrofit.Apiconfig;
import com.example.utspemrogramanbergerak.data.retrofit.Apiservice;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail extends AppCompatActivity {

    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        progressBar = findViewById(R.id.progressBar);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String username = extras.getString("username");
            Apiservice apiService = Apiconfig.getApiservice();
            Call<Account> userCall = apiService.getUser(username);

            TextView textView = findViewById(R.id.tvname);
            TextView textView2 = findViewById(R.id.tvusername);
            TextView textView3 = findViewById(R.id.tvbio);
            ImageView imageView = findViewById(R.id.imgprofile);

            showLoading(true);
            userCall.enqueue(new Callback<Account>() {
                @Override
                public void onResponse(Call<Account> call, Response<Account> response) {
                    if (response.isSuccessful()){

                        Account user = response.body();
                        if (user != null){
                            showLoading(false);
                            String name = "Name: " + user.getName();
                            String usernames = "Username: " + user.getLogin();
                            String bio = "Bio: " + user.getBio();
                            String gambar = user.getAvatarUrl();

                            textView.setText(name);
                            textView2.setText(usernames);
                            textView3.setText(bio);
                            Picasso.get().load(gambar).into(imageView);
                        }else {
                            Toast.makeText(Detail.this, "Failed to get user data", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Account> call, Throwable t) {
                    Toast.makeText(Detail.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void showLoading(Boolean isLoading) {
        if (isLoading) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}