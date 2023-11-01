package com.example.museum.Khampha;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.museum.Khampha.Thamquan.ThamquanNew;
import com.example.museum.R;

public class thongtin extends AppCompatActivity {
    public int count = 3;
    ThongtinchungNew thongtinchungNew;
    ThamquanNew thamquanNew;
    TextView thongtinchung;
    TextView thamquan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinf);
        thongtinchungNew = new ThongtinchungNew();
        thamquanNew = new ThamquanNew();
        thongtinchung = findViewById(R.id.thongtinchung);
        thamquan = findViewById(R.id.thamquan);
        thongtinchung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, thongtinchungNew).commit();
                thongtinchung.setTextColor(getResources().getColor(R.color.black));
                thamquan.setTextColor(Color.parseColor("#B9B9B9"));
            }
        });
        thamquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, thamquanNew).commit();
                thamquan.setTextColor(getResources().getColor(R.color.black));
                thongtinchung.setTextColor(Color.parseColor("#B9B9B9"));
            }
        });

        for (int i = 0; i < 5; i++) {
            String IDName = "star" + (i + 1);
            int resID = getResources().getIdentifier(IDName, "id", getPackageName());
            ImageView star = findViewById(resID);
            if(i < count){
                star.setImageDrawable(getResources().getDrawable(R.drawable.starcolor));
            }
            else{
                star.setImageDrawable(getResources().getDrawable(R.drawable.star));
            }
        }
    }
}