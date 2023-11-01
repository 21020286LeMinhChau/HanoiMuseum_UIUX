package com.example.museum;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    ArrayList<ItemsDomain> items;
    DecimalFormat formatter;
    Context context;

    public ItemsAdapter(ArrayList<ItemsDomain> items) {
        this.items = items;
        formatter = new DecimalFormat("###,###,###,###.##");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder,parent,false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTxt.setText(items.get(position).getNameOfMuseum());
        holder.themeTxt.setText(items.get(position).getTheme());
        holder.addressTxt.setText(items.get(position).getAddress());
        holder.priceTxt.setText(items.get(position).getPriceOfTicket());
        holder.openingsTxt.setText(items.get(position).getOpenings());
        int drawableResouceId = holder.itemView.getResources().getIdentifier(items.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResouceId).into(holder.pic);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {

        return items.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTxt,themeTxt, addressTxt, priceTxt, openingsTxt;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.nameTxt);
            themeTxt = itemView.findViewById(R.id.themeTxt);
            addressTxt = itemView.findViewById(R.id.addressTxt);
            priceTxt = itemView.findViewById(R.id.priceTxt);
            openingsTxt = itemView.findViewById(R.id.openingsTxt);
            pic = itemView.findViewById(R.id.pic);

        }

    }
}
