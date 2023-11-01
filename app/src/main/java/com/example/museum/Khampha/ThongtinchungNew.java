package com.example.museum.Khampha;


import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.museum.R;

public class ThongtinchungNew extends Fragment {
    public int count = 3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_thongtinchung, container, false);
        TextView xemThem1 = view.findViewById(R.id.xemthem1);
        xemThem1.setPaintFlags(xemThem1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView xemThem2 = view.findViewById(R.id.xemthem2);
        xemThem2.setPaintFlags(xemThem2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView xemThem3 = view.findViewById(R.id.xemthem3);
        xemThem3.setPaintFlags(xemThem3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView thoiGian = view.findViewById(R.id.thoigian);
        TextView thongTinChung = view.findViewById(R.id.thongtinchungreal);
        TextView giaVe = view.findViewById(R.id.giave);
        thoiGian.setVisibility(TextView.GONE);
        giaVe.setVisibility(TextView.GONE);
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
        return view;
    }


}