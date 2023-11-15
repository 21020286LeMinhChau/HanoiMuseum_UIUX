package com.example.museum.Khampha.Thamquan;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.R;

public class HienVatViewHolder extends RecyclerView.ViewHolder{
    TextView TenHienVat;
    TextView ThoiLuong;
    TextView ThongTin;
    ImageView HinhAnh;
    TextView AudioSource;
    View view;
    public HienVatViewHolder(@NonNull View view) {
        super(view);
        TenHienVat = (TextView) view.findViewById(R.id.tenhienvat);
        ThoiLuong = (TextView) view.findViewById(R.id.thoiluong);
        ThongTin = (TextView) view.findViewById(R.id.thongtin);
        HinhAnh = (ImageView) view.findViewById(R.id.hinhanh);
        this.view = view;

    }
}
