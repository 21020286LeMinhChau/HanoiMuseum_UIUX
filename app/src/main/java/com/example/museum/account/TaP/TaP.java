package com.example.museum.account.TaP;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.museum.MainRun;
import com.example.museum.R;
import com.example.museum.Trangchu.Home;
import com.example.museum.account.createAccount.CreateAccount;
import com.example.museum.account.profile.profile;

public class TaP extends AppCompatActivity {

    Button closeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privary_condition);
        closeBtn = findViewById(R.id.closeBtn);

        // Chuỗi HTML của Điều khoản và Điều kiện sử dụng
        String termsHtml = getString(R.string.terms_and_conditions_content);

        // Chuỗi HTML của Chính sách Bảo mật
        String privacyHtml = getString(R.string.privacy_policy_content);

        // Chuyển đổi HTML thành Spanned
        Spanned termsSpanned = Html.fromHtml(termsHtml);
        Spanned privacySpanned = Html.fromHtml(privacyHtml);

        // Hiển thị trong TextView
        TextView termsTextView = findViewById(R.id.termsTextView);
        TextView privacyTextView = findViewById(R.id.privacyTextView);

        termsTextView.setText(termsSpanned);
        privacyTextView.setText(privacySpanned);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String sourceActivity = intent.getStringExtra("from");
                Log.v("test",sourceActivity);
                if(sourceActivity.equals("Signup")){
                    Intent nIntent = new Intent(TaP.this, CreateAccount.class);
                    startActivity(nIntent);
                }else{
                    MainRun.fromTaP = true;
                    Intent nIntent = new Intent(TaP.this, MainRun.class);
                    startActivity(nIntent);
                }
            }
        });

    }
}
