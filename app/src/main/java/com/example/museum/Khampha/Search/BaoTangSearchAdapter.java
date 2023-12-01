package com.example.museum.Khampha.Search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.museum.R;
import com.example.museum.Trangchu.BaoTang;

import java.util.List;

public class BaoTangSearchAdapter extends  RecyclerView.Adapter<BaoTangSearchAdapter.BaoTangViewHolder> {
    private List<BaoTang> baoTangItemList;

    public BaoTangSearchAdapter(List<BaoTang> baoTangList) {
        this. baoTangItemList = baoTangList;
    }
    public void setFilteredList(List<BaoTang> filteredList){
        this.baoTangItemList = filteredList;
        notifyDataSetChanged();
}
    @NonNull
    @Override
    public BaoTangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_baotang, parent,false);
        return new BaoTangViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull BaoTangViewHolder holder, int position) {
        BaoTang baoTang =  baoTangItemList.get(position);
        if(baoTang == null){
            return;
        }
        holder.nameOfMuseum.setText(baoTang.getNameOfMuseum());

            holder.diadiem.setText(baoTang.getDiadiem());
            holder.status.setText(baoTang.getStatus());

        Glide.with(holder.itemView.getContext())
                .load(baoTang.getAnh())
                .into(holder.anh);



    }

    @Override
    public int getItemCount() {
        if(  baoTangItemList != null){
            return  baoTangItemList.size();
        };
        return 0;
    }

    class BaoTangViewHolder extends RecyclerView.ViewHolder{
        private TextView nameOfMuseum;
        private TextView diadiem;
        private TextView status;

        private ImageView anh;
        public BaoTangViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfMuseum = (TextView) itemView.findViewById(R.id.nameTxt);

            anh =(ImageView) itemView.findViewById(R.id.anh);
            diadiem =  (TextView) itemView.findViewById(R.id.diadiemTxt);
            status = (TextView) itemView.findViewById(R.id.statusTxt);




        }
    }
}
