package com.example.museum.account.profile;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.museum.Gioithieu.SplashThird;
import com.example.museum.R;
import com.example.museum.MainRun;
import com.example.museum.account.Account;
import com.example.museum.account.LoginAccount;
import com.example.museum.account.TaP.TaP;

public class profile extends Fragment {

    Account account = LoginAccount.account;

    ConstraintLayout editScreen;

    TextView username;

    Button editBtn;
    Button policyBtn;
    Button logBtn;
    Button closeBtn;
    Button confirmBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_profile, container, false);
        username = view.findViewById(R.id.username);
        editBtn = view.findViewById(R.id.editBtn);
        policyBtn = view.findViewById(R.id.policyBtn);
        logBtn = view.findViewById(R.id.logoutBtn);
        closeBtn = view.findViewById(R.id.Close_Button);
        editScreen = view.findViewById(R.id.show_screen);
        confirmBtn = view.findViewById(R.id.confirm_btn);

        if (account == null) {
            username.setText("Xin vui lòng đăng nhập");
            Drawable icon = getResources().getDrawable(R.drawable.ic_log_in);
            editBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(icon, null, null, null);
            editBtn.setText("Đăng nhập");
            policyBtn.setVisibility(policyBtn.GONE);
            logBtn.setVisibility(logBtn.GONE);

            editBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(getContext(), SplashThird.class);
                    startActivity(intent);
                }
            });

        } else {
            username.setText(account.getEmail());
            policyBtn.setVisibility(View.VISIBLE);
            logBtn.setVisibility(View.VISIBLE);

            editBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editScreen.setVisibility(View.VISIBLE);
                }
            });

            closeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editScreen.setVisibility(View.GONE);
                }
            });

            policyBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), TaP.class).putExtra("from", "profile");
                    startActivity(intent);
                }
            });

            logBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LoginAccount.account = null;
                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("login",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isLoggedIn", false);
                    editor.apply();
                    MainRun.logOut = true;
                    Intent intent = new Intent();
                    intent.setClass(getContext(), MainRun.class);
                    startActivity(intent);
                }
            });

            confirmBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editScreen.setVisibility(View.GONE);
                }
            });
        }
        return view;
    }


    public void setAccount(Account account) {
        this.account = account;
    }

}
