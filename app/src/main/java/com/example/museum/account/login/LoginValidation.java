package com.example.museum.account.login;

import com.example.museum.account.PasswordEncryption;
import com.example.museum.database.query.MongoDBQuery;
import com.google.android.material.textfield.TextInputLayout;

import org.bson.Document;

public class LoginValidation {

    public static boolean isAccountValid(TextInputLayout email, TextInputLayout password){
        String e = email.getEditText().getText().toString();
        String p = password.getEditText().getText().toString();
        if (!MongoDBQuery.isExist("hanoi-museum", "users", new Document().append("email", e))) {
            return true;
        } else {
            Document userInfor = MongoDBQuery.queryOne("hanoi-museum", "users", new Document("email", email.getEditText().getText().toString()));
            if (!PasswordEncryption.encrypt(p).equals(userInfor.getString("password"))) {
                return true;
            } else {
                return false;
            }
        }

    }
}
