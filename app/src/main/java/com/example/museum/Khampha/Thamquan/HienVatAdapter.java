package com.example.museum.Khampha.Thamquan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.museum.R;

import java.util.Collections;
import java.util.List;

public class HienVatAdapter extends RecyclerView.Adapter<HienVatViewHolder> {
    List<HienVat> list
            = Collections.emptyList();

    Context context;
    ClickListiner listiner;
    ThamQuanNew fragmentOne;

    public HienVatAdapter(List<HienVat> list, Context context, ClickListiner listiner) {
        this.list = list;
        this.context = context;
        this.listiner = listiner;
    }

    public HienVatAdapter(List<HienVat> list, Context context, ThamQuanNew fragmentOne) {
        this.list = list;
        this.context = context;
        this.fragmentOne = fragmentOne;

    }

    @NonNull
    @Override
    public HienVatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout

        View photoView = inflater.inflate(R.layout.hienvat, parent, false);

        HienVatViewHolder viewHolder
                = new HienVatViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HienVatViewHolder holder, int position) {
        int index = holder.getAdapterPosition();
        holder.TenHienVat
                .setText(list.get(position).getTenHienVat());
        holder.ThoiLuong
                .setText(list.get(position).getThoiLuong());
        holder.ThongTin
                .setText(list.get(position).getThongTin());
//        holder.HinhAnh
//                .setImageResource(list.get(position).getFirstHinhAnh());
        Glide.with(holder.itemView.getContext())
                .load("file:///android_asset/DbI/objects/" + list.get(position).getFirstHinhAnh())
                .into(holder.HinhAnh);

        holder.view.setOnClickListener(view -> listiner.click(index));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void onAttachedToRecyclerView(
            RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

