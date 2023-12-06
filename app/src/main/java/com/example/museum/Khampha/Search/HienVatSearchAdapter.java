package com.example.museum.Khampha.Search;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.museum.Audio.Audio;
import com.example.museum.Khampha.Thamquan.ClickListiner;
import com.example.museum.Khampha.Thamquan.HienVat;
import com.example.museum.Khampha.Thamquan.HienVatViewHolder;
import com.example.museum.Khampha.ThongTinAll;
import com.example.museum.R;

import java.util.List;

public class HienVatSearchAdapter extends  RecyclerView.Adapter<HienVatSearchAdapter.HienVatViewHolder> {
    private List<HienVat> hienVatItemList;
    private ClickListiner listiner;

private Context context;
//    public HienVatSearchAdapter(List<HienVat> hienVatList) {
//        this.hienVatItemList = hienVatList;
//    }

    public HienVatSearchAdapter(List<HienVat> listHienVat, Context context, ClickListiner listiner) {
        this.hienVatItemList = listHienVat;
        this.context = context;
        this.listiner = listiner;
    }

    public void setFilteredList(List<HienVat> filteredList){
        this.hienVatItemList = filteredList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public HienVatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hienvat, parent,false);
        return new HienVatViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull HienVatViewHolder holder, int position) {
        HienVat hienVat =  hienVatItemList.get(position);
        if(hienVat == null){
            return;
        }
        holder.tenHienVat.setText(hienVat.getTenHienVat());

        holder.author.setText(hienVat.getAuthor());

        Glide.with(holder.itemView.getContext())
                .load("file:///android_asset/DbI/objects/" + hienVat.getFirstHinhAnh())
                .into(holder.hinhAnh);


        //                            @Override
//            public void click(int index) {
//                Intent intent = new Intent(getActivity(), Audio.class);
//                startActivity(intent);
//
//            }
//         change to Audio activity when click
        int index = holder.getAdapterPosition();
        holder.itemView.setOnClickListener(view -> listiner.click(index));



    }

    @Override
    public int getItemCount() {
        if(  hienVatItemList != null){
            return  hienVatItemList.size();
        };
        return 0;
    }

    class HienVatViewHolder extends RecyclerView.ViewHolder{
        private TextView tenHienVat;
        private TextView author;

        private ImageView hinhAnh;
        public HienVatViewHolder(@NonNull View itemView) {
            super(itemView);
            tenHienVat = (TextView) itemView.findViewById(R.id.tenHienVatTxt);
            author = (TextView) itemView.findViewById(R.id.authorTxt);
            hinhAnh =(ImageView) itemView.findViewById(R.id.hinhAnh);





        }
    }
}
