package com.example.museum;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class    ThongTinChung extends AppCompatActivity{
    public int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinchung);

        modifiedLayout(count);
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    public void modifiedLayout(int count) {
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
    }



}
