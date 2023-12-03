package com.example.museum.Khampha.DanhGia;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.R;

public class ListDanhGiaViewHolder extends RecyclerView.ViewHolder{
    TextView TenNguoiDanhGia;
    TextView NoiDungDanhGia;
    TextView ThoiGianDanhGia;
    ImageView HinhAnhNguoiDanhGia;
    ImageView star1;
    ImageView star2;
    ImageView star3;
    ImageView star4;
    ImageView star5;
    ImageView line;
    int soSao;

    View view;

    public ListDanhGiaViewHolder(@NonNull View itemView) {
        super(itemView);
        TenNguoiDanhGia = (TextView) itemView.findViewById(R.id.tennguoidanhgia);
        NoiDungDanhGia = (TextView) itemView.findViewById(R.id.noidungdanhgia);
        ThoiGianDanhGia = (TextView) itemView.findViewById(R.id.thoigiandanhgia);
        HinhAnhNguoiDanhGia = (ImageView) itemView.findViewById(R.id.hinhanhnguoidanhgia);
        star1 = (ImageView) itemView.findViewById(R.id.starDanhGia1);
        star2 = (ImageView) itemView.findViewById(R.id.starDanhGia2);
        star3 = (ImageView) itemView.findViewById(R.id.starDanhGia3);
        star4 = (ImageView) itemView.findViewById(R.id.starDanhGia4);
        star5 = (ImageView) itemView.findViewById(R.id.starDanhGia5);
        line = itemView.findViewById(R.id.line_in_danhgia);
        this.view = itemView;
    }
}
