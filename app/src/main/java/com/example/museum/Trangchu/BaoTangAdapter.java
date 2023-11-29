package com.example.museum.Trangchu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.museum.R;

import java.util.List;

public class BaoTangAdapter extends  RecyclerView.Adapter<BaoTangAdapter.BaoTangViewHolder> {
    private List<BaoTang> baoTangList;
    private ViewPager2 viewPager2;

    public BaoTangAdapter(List<BaoTang> baoTangList) {
        this.baoTangList = baoTangList;
    }

    @NonNull
    @Override
    public BaoTangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder, parent,false);
        return new BaoTangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaoTangViewHolder holder, int position) {
            BaoTang baoTang = baoTangList.get(position);
            if(baoTang == null){
                return;
            }
            holder.nameOfMuseum.setText(baoTang.getNameOfMuseum());
            holder.address.setText(baoTang.getAddress());
            holder.priceOfTicket.setText(baoTang.getPriceOfTicket());
            holder.openings.setText(baoTang.getOpenings());
            holder.pic.setImageResource(baoTang.getPic());



    }

    @Override
    public int getItemCount() {
        if( baoTangList != null){
            return baoTangList.size();
        };
        return 0;
    }

    class BaoTangViewHolder extends RecyclerView.ViewHolder{
        private TextView nameOfMuseum;
        private TextView address;
        private TextView priceOfTicket;
        private TextView openings;
        private ImageView pic;
        public BaoTangViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfMuseum = (TextView) itemView.findViewById(R.id.nameTxt);
            address =  (TextView) itemView.findViewById(R.id.addressTxt);
            priceOfTicket = (TextView) itemView.findViewById(R.id.priceTxt);
            openings =(TextView)  itemView.findViewById(R.id.openingsTxt);
            pic =(ImageView) itemView.findViewById(R.id.pic);




        }
    }
}
