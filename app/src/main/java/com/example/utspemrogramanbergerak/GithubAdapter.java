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

public class GithubAdapter  extends RecyclerView.Adapter<GithubAdapter.ViewHolder>{
    private List<Account> accounts;

    public GithubAdapter(List<Account> accounts) {
        this.accounts = accounts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_akun, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Account account = accounts.get(position);
        holder.usernameTextView.setText(account.getName());
        Picasso.get().load(account.getAvatarUrl()).into(holder.avatarImageView);

        holder.itemView.setOnClickListener(click -> {
            Intent intent = new Intent(click.getContext(), Detail.class);
            intent.putExtra("nama", account.getLogin());
            intent.putExtra("username", account.getName());
            intent.putExtra("bio", account.getBio());
            intent.putExtra("gambar", account.getAvatarUrl());
            click.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarImageView;
        TextView usernameTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.imgprofile);
            usernameTextView = itemView.findViewById(R.id.tvusername);
        }
    }

}
