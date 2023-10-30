package com.example.museum;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class    ThongTinChung extends AppCompatActivity{
    public int count = 3;
    BottomNavigationView bottomNavigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinchung);
        TextView xemThem1 = findViewById(R.id.xemthem1);
        TextView xemThem2 = findViewById(R.id.xemthem2);
        TextView xemThem3 = findViewById(R.id.xemthem3);
        TextView thoiGian = findViewById(R.id.thoigian);
        TextView thongTinChung = findViewById(R.id.thongtinchungreal);
        TextView giaVe = findViewById(R.id.giave);
        thoiGian.setVisibility(TextView.GONE);
        giaVe.setVisibility(TextView.GONE);
//        bottomNavigationView
//                = findViewById(R.id.bottomNavigationView);
//
//        bottomNavigationView
//                .setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);
//        bottomNavigationView.setSelectedItemId(R.id.explore);
        modifiedLayout(count);
    }
    TextView thamQuan;
    @SuppressLint("UseCompatLoadingForDrawables")
    public void modifiedLayout(int count) {
        TextView xemThem1 = findViewById(R.id.xemthem1);
        TextView xemThem2 = findViewById(R.id.xemthem2);
        TextView xemThem3 = findViewById(R.id.xemthem3);
        TextView thoiGian = findViewById(R.id.thoigian);
        TextView thongTinChung = findViewById(R.id.thongtinchungreal);
        TextView giaVe = findViewById(R.id.giave);
        thamQuan =  findViewById(R.id.thamquan);
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
            if (i < 3) {
                String IDName2 = "xemthem" + (i + 1);
                int resID2 = getResources().getIdentifier(IDName2, "id", getPackageName());
                TextView textView = findViewById(resID2);
                textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            }
        }
        xemThem1.setOnClickListener(v -> {
            if(thoiGian.getVisibility() == TextView.VISIBLE){
                thoiGian.setVisibility(TextView.GONE);
                xemThem1.setText("Xem thêm");
            }
            else if(thoiGian.getVisibility() == TextView.GONE){
                thoiGian.setVisibility(TextView.VISIBLE);
                xemThem1.setText("Thu gọn");
            }

        });
        xemThem3.setOnClickListener(v -> {
            Log.d("maxLinesdo", String.valueOf(thongTinChung.getMaxLines()));
            if(thongTinChung.getMaxLines() == 2){
                thongTinChung.setMaxLines(100);
                xemThem3.setText("Thu gọn");
            }
            else if(thongTinChung.getMaxLines() == 100){
                thongTinChung.setMaxLines(2);
                xemThem3.setText("Xem thêm");
            }

        });
        xemThem2.setOnClickListener(v -> {
            if(giaVe.getVisibility() == TextView.VISIBLE){
                giaVe.setVisibility(TextView.GONE);
                xemThem2.setText("Xem thêm");
            }
            else if(giaVe.getVisibility() == TextView.GONE){
                giaVe.setVisibility(TextView.VISIBLE);
                xemThem2.setText("Thu gọn");
            }
        });
        thamQuan.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(ThongTinChung.this, ThongTinRieng.class);
            startActivity(intent);
        });
    }



}
