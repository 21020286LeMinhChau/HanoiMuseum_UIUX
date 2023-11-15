package com.example.museum.account.profile;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.museum.R;
import com.example.museum.account.Account;

import at.markushi.ui.CircleButton;
import de.hdodenhof.circleimageview.CircleImageView;

public class profile extends  AppCompatActivity{

   Account account = new Account("abc@gmail.com","123456");

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

        }else{
            username.setText(account.getEmail());
        }

    }


    public void setAccount(Account account){
        this.account = account;
    }

}
