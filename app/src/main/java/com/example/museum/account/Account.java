package com.example.museum.account;

import android.widget.ImageView;

import com.example.museum.database.insert.MongoDBInsert;
import com.example.museum.database.insert.AddUserToDB;
import org.bson.Document;

public class Account implements AddUserToDB {
    private String id;
    private String email;
    private String password;

    public Account( String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword(){return password;}

    @Override
    public void addNewUserToDB() {
            MongoDBInsert.insertOne("hanoi-museum", "users",
                    new Document()
                            .append("email", this.email)
                            .append("password", this.password)
    );
    }
}
