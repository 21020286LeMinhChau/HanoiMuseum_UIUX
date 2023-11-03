package com.example.museum.Gioithieu;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.museum.R;


public class SplashThird  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_third);
       Button signUpButton = findViewById(R.id.buttonSignup);
        Button logInButton = findViewById(R.id.buttonLogin);

    }
}




