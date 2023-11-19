package com.example.museum.account.profile;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.museum.Gioithieu.SplashSecond;
import com.example.museum.Gioithieu.SplashThird;
import com.example.museum.MainActivity;
import com.example.museum.R;
import com.example.museum.Trangchu.Home;
import com.example.museum.account.Account;

import at.markushi.ui.CircleButton;
import de.hdodenhof.circleimageview.CircleImageView;

public class profile extends  AppCompatActivity{

   Account account = new Account("test","abc") ;

   TextView username;

   Button infoBtn;
   Button editBtn;
   Button policyBtn;
   Button logBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        username = findViewById(R.id.username);
        infoBtn = findViewById(R.id.infoBtn);
        editBtn = findViewById(R.id.editBtn);
        policyBtn = findViewById(R.id.policyBtn);
        logBtn = findViewById(R.id.logoutBtn);

        if(account == null){
            username.setText("xin vui lòng đăng nhập");
            Drawable icon = getResources().getDrawable(R.drawable.ic_log_in);
            editBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(icon,null,null,null);
            editBtn.setText("Đăng nhập");
            infoBtn.setVisibility(infoBtn.GONE);
            policyBtn.setVisibility(policyBtn.GONE);
            logBtn.setVisibility(logBtn.GONE);

            editBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(profile.this, SplashThird.class);
                    startActivity(intent);
                }
            });

        }else{
            username.setText(account.getEmail());
            infoBtn.setVisibility(infoBtn.VISIBLE);
            policyBtn.setVisibility(policyBtn.VISIBLE);
            logBtn.setVisibility(logBtn.VISIBLE);

            logBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    account = null;
                    Intent intent = new Intent();
                    intent.setClass(profile.this, Home.class);
                    startActivity(intent);
                }
            });
        }

    }


    public void setAccount(Account account){
        this.account = account;
    }

}
