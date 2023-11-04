package com.example.museum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.museum.account.createAccount.CreateAccount;
import com.example.museum.account.login.LoginAction;


public class SplashThird  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_third);
        Button signUpButton = findViewById(R.id.buttonSignup);
        Button logInButton = findViewById(R.id.buttonLogin);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SplashThird.this, CreateAccount.class);
                startActivity(intent);
            }
        });

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SplashThird.this, LoginAction.class);
                startActivity(intent);
            }
        });

    }
}




