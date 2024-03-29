package com.example.museum.account.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.museum.Gioithieu.SplashThird;
import com.example.museum.MainActivity;
import com.example.museum.MainRun;
import com.example.museum.R;

import com.example.museum.Trangchu.Home;
import com.example.museum.account.Account;
import com.example.museum.account.LoginAccount;
import com.google.android.material.textfield.TextInputLayout;

public class LoginAction  extends AppCompatActivity {
    TextInputLayout email;
    TextInputLayout password;

    ProgressBar progressBar;
    ConstraintLayout loading;

    Button backBtn;
    Button loginBtn;
    Button forgetBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email = (TextInputLayout) findViewById(R.id.email);
        password = (TextInputLayout) findViewById(R.id.password);

        backBtn = findViewById(R.id.back_btn);
        loginBtn = findViewById(R.id.login_btn);
        forgetBtn = findViewById(R.id.forget_btn);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        loading = (ConstraintLayout) findViewById(R.id.loadingFrame);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                loading.setVisibility(View.VISIBLE);
                Execute execute = new Execute();
                execute.execute();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAction.this, SplashThird.class);
                startActivity(intent);
            }
        });

    }

    public class Execute extends AsyncTask<Void,Void,Boolean>{

        @Override
        protected Boolean doInBackground(Void... voids) {
            boolean resutl = LoginValidation.isAccountValid(email,password);
            return resutl;
        }


        @Override
        protected void onPostExecute(Boolean aVoid) {
            progressBar.setVisibility(View.GONE);
            loading.setVisibility(View.GONE);
            if(aVoid==true){
                Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                password.getEditText().setText("");
            }else{
                Toast.makeText(getApplicationContext(), "Login Successfully!", Toast.LENGTH_SHORT).show();
                LoginAccount.account = new Account(email.getEditText().getText().toString(),password.getEditText().getText().toString());
                SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", true);
                editor.putString("email",LoginAccount.account.getEmail());
                editor.putString("password",LoginAccount.account.getPassword());
                editor.putBoolean("firstTimeUsing", false);
                editor.apply();
                Log.v("test","yes");
                Intent intent = new Intent(LoginAction.this, MainRun.class);
                startActivity(intent);
            }
        }
    }
}
