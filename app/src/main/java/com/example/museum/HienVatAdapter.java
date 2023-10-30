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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HienVatViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

