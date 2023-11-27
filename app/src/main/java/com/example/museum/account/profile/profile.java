package com.example.museum.account.profile;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.museum.Gioithieu.SplashSecond;
import com.example.museum.Gioithieu.SplashThird;
import com.example.museum.MainActivity;
import com.example.museum.R;
import com.example.museum.Main_run;
import com.example.museum.account.Account;
import com.example.museum.account.TaP.TaP;
import com.example.museum.account.createAccount.CreateAccount;

import at.markushi.ui.CircleButton;
import de.hdodenhof.circleimageview.CircleImageView;

public class profile extends Fragment {

   Account account = new Account("test","abc") ;

   ConstraintLayout editScreen;

   TextView username;

   Button editBtn;
   Button policyBtn;
   Button logBtn;
   Button closeBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_profile, container, false);
        username = view.findViewById(R.id.username);
        editBtn = view.findViewById(R.id.editBtn);
        policyBtn = view.findViewById(R.id.policyBtn);
        logBtn = view.findViewById(R.id.logoutBtn);
        closeBtn = view.findViewById(R.id.Close_Button);
        editScreen = view.findViewById(R.id.show_screen);

        if(account == null){
            username.setText("xin vui lòng đăng nhập");
            Drawable icon = getResources().getDrawable(R.drawable.ic_log_in);
            editBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(icon,null,null,null);
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

        }else{
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
                    account = null;
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Main_run.class);
                    startActivity(intent);
                }
            });
        }
        return view;
    }


    public void setAccount(Account account){
        this.account = account;
    }

}
