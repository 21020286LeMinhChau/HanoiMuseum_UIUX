package com.example.museum;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HienVatViewHolder extends RecyclerView.ViewHolder{
    TextView TenHienVat;
    TextView ThoiLuong;
    TextView ThongTin;
    ImageView HinhAnh;
    View view;
    public HienVatViewHolder(@NonNull View view) {
        super(view);
        TenHienVat = (TextView) view.findViewById(R.id.tenhienvat);
        ThoiLuong = (TextView) view.findViewById(R.id.thoiluong);
        ThongTin = (TextView) view.findViewById(R.id.thongtin);
        HinhAnh = (ImageView) view.findViewById(R.id.hinhanh);

    }
}
