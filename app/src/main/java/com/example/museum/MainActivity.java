package com.example.museum;

import android.content.Intent;
import android.os.Bundle;


import com.example.museum.database.MongoDBConnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.view.View;

import android.widget.Button;


import io.realm.Realm;

public class MainActivity extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        MongoDBConnection.connect();

        setContentView(R.layout.splash_first);

        Button nextButton = findViewById(R.id.button1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, SplashSecond.class);
                intent.setClass(MainActivity.this, MainRun.class);
                startActivity(intent);
            }
        });
    }

}
