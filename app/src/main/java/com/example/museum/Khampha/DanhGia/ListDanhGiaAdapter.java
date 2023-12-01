package com.example.museum.Khampha.DanhGia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.Khampha.DanhGia.ClickListiner2;
import com.example.museum.Khampha.Thamquan.HienVatViewHolder;
import com.example.museum.R;

import java.util.Collections;
import java.util.List;

public class ListDanhGiaAdapter extends RecyclerView.Adapter<ListDanhGiaViewHolder>{
    List<ListDanhGia> list;
    Context context;
    ClickListiner2 listiner;
    public ListDanhGiaAdapter(List<ListDanhGia> list, Context context, ClickListiner2 listiner) {
        this.list = list;
        this.context = context;
        this.listiner = listiner;
    }
    @NonNull
    @Override
    public ListDanhGiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout

        View photoView
                = inflater
                .inflate(R.layout.list_danh_gia,
                        parent, false);

        ListDanhGiaViewHolder viewHolder
                = new ListDanhGiaViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListDanhGiaViewHolder holder, int position) {
        int index = holder.getAdapterPosition();
        holder.HinhAnhNguoiDanhGia
                .setImageResource(list.get(position).getAvatar());
        holder.TenNguoiDanhGia
                .setText(list.get(position).getTenNguoiDanhGia());
        holder.NoiDungDanhGia
                .setText(list.get(position).getNoiDungDanhGia());
        holder.star1
                .setImageResource(list.get(position).getStar1());
        holder.star2
                .setImageResource(list.get(position).getStar2());
        holder.star3
                .setImageResource(list.get(position).getStar3());
        holder.star4
                .setImageResource(list.get(position).getStar4());
        holder.star5
                .setImageResource(list.get(position).getStar5());

        holder.view.setOnClickListener(view -> listiner.click(index));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
