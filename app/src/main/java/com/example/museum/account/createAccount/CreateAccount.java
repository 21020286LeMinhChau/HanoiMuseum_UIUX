package com.example.museum.account.createAccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.museum.Gioithieu.SplashThird;
import com.example.museum.MainActivity;
import com.example.museum.R;

import com.example.museum.Trangchu.Home;
import com.example.museum.account.Account;
import com.example.museum.account.PasswordEncryption;
import com.example.museum.account.TaP.TaP;
import com.google.android.material.textfield.TextInputLayout;
import androidx.annotation.Nullable;

public class CreateAccount extends AppCompatActivity {
    private Account account;

    TextInputLayout email;
    TextInputLayout password;
    Button signUpBtn;
    Button backBtn;
    Button TaCBtn;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        email = (TextInputLayout) findViewById(R.id.email);
        password = (TextInputLayout) findViewById(R.id.password);

        signUpBtn = (Button) findViewById(R.id.createAcc_btn);
        backBtn = (Button)  findViewById(R.id.back_btn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread mainThread = new Thread(new Runnable() {
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(AccountValidation.isEmailInvalid(email)||
                                        AccountValidation.isPasswordInvalid(password)){
                                    password.getEditText().setText("");
                                    return;
                                }
                                account = new Account(email.getEditText().getText().toString(), PasswordEncryption.encrypt(password.getEditText().getText().toString()));
                                account.addNewUserToDB();

                                Toast.makeText(getApplicationContext(), "Sign Up Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(CreateAccount.this, Home.class);
                                startActivity(intent);
                            }
                        });
                    }
                });
                mainThread.start();
            }

        });
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccount.this, SplashThird.class);
                startActivity(intent);
            }
        });

        TaCBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccount.this, TaP.class).putExtra("from", "Signup");
                startActivity(intent);
            }
        });
    }
}
