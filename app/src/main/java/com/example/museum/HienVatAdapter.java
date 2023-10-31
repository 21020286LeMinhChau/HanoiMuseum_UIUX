package com.example.museum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class HienVatAdapter extends RecyclerView.Adapter<HienVatViewHolder>{
    List<HienVat> list
            = Collections.emptyList();

    Context context;
    ClickListiner listiner;
    public HienVatAdapter(List<HienVat> list, Context context, ClickListiner listiner) {
        this.list = list;
        this.context = context;
        this.listiner = listiner;
    }

    @NonNull
    @Override
    public HienVatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout

        View photoView
                = inflater
                .inflate(R.layout.hienvat,
                        parent, false);

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
        holder.HinhAnh
                .setImageResource(list.get(position).getHinhAnh());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                listiner.click(index);
            }
        });
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

