package com.example.museum;

import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;


import com.example.museum.Gioithieu.SplashSecond;
import com.example.museum.Khampha.DanhGia.CommentsMuseum;
import com.example.museum.account.Account;
import com.example.museum.account.LoginAccount;
import com.example.museum.database.MongoDBConnection;
import com.example.museum.database.query.CommentQuery;
import com.example.museum.database.query.MuseumQuery;
import com.example.museum.database.query.ObjectQuery;
import com.example.museum.database.query.TopicQuery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.util.Log;
import android.view.View;

import android.widget.Button;


import org.json.JSONException;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        MongoDBConnection.connect();

        ExecuteGetDataMuseum excecuteGetDataMuseum = new ExecuteGetDataMuseum();
        excecuteGetDataMuseum.execute();

        ExecuteGetDataTopic excecuteGetDataTopic = new ExecuteGetDataTopic();
        excecuteGetDataTopic.execute();

        ExecuteGetDataObject excecuteGetDataObject = new ExecuteGetDataObject();
        excecuteGetDataObject.execute();

        ExecuteGetDataComment excecuteGetDataComment = new ExecuteGetDataComment();
        excecuteGetDataComment.execute();

        //first time using?
        SharedPreferences sharedPreferences = getSharedPreferences("firstTime", Context.MODE_PRIVATE);
        boolean firstTimeUsing = sharedPreferences.getBoolean("firstTimeUsing", true);
        if (!firstTimeUsing) {
            SharedPreferences sharedPreferences1 = getSharedPreferences("login", Context.MODE_PRIVATE);
            boolean isLoggedIn = sharedPreferences1.getBoolean("isLoggedIn", false);
            String result = String.valueOf(isLoggedIn);
            Log.v("check:", result);
            if (isLoggedIn) {
                String email = sharedPreferences1.getString("email", "");
                String password = sharedPreferences1.getString("password", "");
                LoginAccount.account = new Account(email, password);
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

    public class ExecuteGetDataMuseum extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            MuseumQuery.getAllMuseums_StartProgram();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

        }
    }

    public class ExecuteGetDataTopic extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            TopicQuery.getAllTopics_StartProgram();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

        }
    }

    public class ExecuteGetDataObject extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            ObjectQuery.getAllHienvat_StartProgram();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

        }
    }

    public class ExecuteGetDataComment extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                CommentQuery.getAllCommentsMuseum_StartProgram();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

        }
    }

}
