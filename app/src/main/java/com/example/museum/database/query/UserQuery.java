package com.example.museum.database.query;


import android.util.Log;

import com.example.museum.account.Account;

import org.bson.Document;

public class UserQuery {
    public static Account FindByUserName(String email){
        Document userDoc = new Document();
        userDoc = MongoDBQuery.queryOne("hanoi-museum","users",new Document("email",email));
        Account account = new Account(userDoc.getString("email"),userDoc.getString("password"));
        return account;
    }
}
