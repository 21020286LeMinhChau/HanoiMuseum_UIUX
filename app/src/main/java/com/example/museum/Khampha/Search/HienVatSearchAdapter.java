package com.example.museum.Khampha.Search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.museum.Khampha.Thamquan.HienVat;
import com.example.museum.Khampha.Thamquan.HienVatViewHolder;
import com.example.museum.R;

import java.util.List;

public class HienVatSearchAdapter extends  RecyclerView.Adapter<HienVatSearchAdapter.HienVatViewHolder> {
    private List<HienVat> hienVatItemList;

    public HienVatSearchAdapter(List<HienVat> hienVatList) {
        this.hienVatItemList = hienVatList;
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
                .load(hienVat.getHinhAnh())
                .into(holder.hinhAnh);



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
