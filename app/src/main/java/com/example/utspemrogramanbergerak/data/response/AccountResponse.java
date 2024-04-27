package com.example.utspemrogramanbergerak.data.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AccountResponse {
    @SerializedName("items")
    private List<Account> accounts;

    public List<Account> getAccounts()
    {
        return  accounts;
    }
}
