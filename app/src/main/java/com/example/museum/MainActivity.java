package com.example.museum;

import android.content.Context;
import static java.security.AccessController.getContext;
import static io.realm.Realm.getApplicationContext;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import com.example.museum.Gioithieu.SplashSecond;
import com.example.museum.account.Account;
import com.example.museum.account.LoginAccount;
import com.example.museum.database.MongoDBConnection;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.util.Log;
import android.view.View;

import android.widget.Button;


import io.realm.Realm;

public class MainActivity extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Realm.init(this);
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//        MongoDBConnection.connect();



        //first time using?
        SharedPreferences sharedPreferences = getSharedPreferences("firstTime", Context.MODE_PRIVATE);
        boolean firstTimeUsing = sharedPreferences.getBoolean("firstTimeUsing", true);
        if(!firstTimeUsing){
            SharedPreferences sharedPreferences1 = getSharedPreferences("login", Context.MODE_PRIVATE);
            boolean isLoggedIn = sharedPreferences1.getBoolean("isLoggedIn", false);
            String result = String.valueOf(isLoggedIn);
            Log.v("check:", result);
            if(isLoggedIn){
                String email = sharedPreferences1.getString("email", "");
                String password = sharedPreferences1.getString("password", "");
                LoginAccount.account = new Account(email,password);
            }
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, MainRun.class);
            startActivity(intent);
        }
        setContentView(R.layout.splash_first);

        Button nextButton = findViewById(R.id.button1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //first time using?
                SharedPreferences sharedPreferences = getSharedPreferences("firstTime", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("firstTimeUsing", false);
                editor.apply();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SplashSecond.class);
                //intent.setClass(MainActivity.this, MainRun.class);
                startActivity(intent);
            }
        });
    }

}
