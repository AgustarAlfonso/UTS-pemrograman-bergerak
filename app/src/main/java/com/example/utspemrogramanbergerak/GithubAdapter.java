package com.example.utspemrogramanbergerak;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utspemrogramanbergerak.data.response.Account;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.ViewHolder> {
    private List<Account> users;
    public GithubAdapter(List<Account> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_akun, parent, false);
        return new GithubAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Account user = users.get(position);
        holder.username.setText(user.getLogin());
        Picasso.get().load(user.getAvatarUrl()).into(holder.images);

        holder.itemView.setOnClickListener(click -> {
            Intent intent = new Intent(click.getContext(), Detail.class);
            intent.putExtra("nama", user.getName());
            intent.putExtra("username", user.getLogin());
            intent.putExtra("link", user.getHtml_url());
            intent.putExtra("bio", user.getBio());
            intent.putExtra("gambar", user.getAvatarUrl());
            click.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView username;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.imgprofile);
            username = itemView.findViewById(R.id.tvusername);
        }
    }
}