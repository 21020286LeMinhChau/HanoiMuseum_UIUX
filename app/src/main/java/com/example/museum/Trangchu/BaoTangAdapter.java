package com.example.museum.Trangchu;

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
import com.example.museum.Khampha.ThongTinAll;
import com.example.museum.R;

import java.util.List;

public class BaoTangAdapter extends RecyclerView.Adapter<BaoTangAdapter.BaoTangViewHolder> {
    private List<BaoTang> baoTangList;

    public BaoTangAdapter(List<BaoTang> baoTangList) {
        this.baoTangList = baoTangList;
    }

    @NonNull
    @Override
    public BaoTangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder, parent, false);
        return new BaoTangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaoTangViewHolder holder, int position) {
        BaoTang baoTang = baoTangList.get(position);
        if (baoTang == null) {
            return;
        }
        holder.nameOfMuseum.setText(baoTang.getNameOfMuseum());
        holder.address.setText(baoTang.getAddress());
        holder.priceOfTicket.setText(baoTang.getPriceOfTicket());
        holder.openings.setText(baoTang.getOpeningsNow());
//        Glide.with(holder.itemView.getContext())
//                .load(baoTang.getPic())
//                .into(holder.pic);
// pic -> link to assets/DbI/museums + pic
        Glide.with(holder.itemView.getContext())
                .load("file:///android_asset/DbI/museums/" + baoTang.getPic())
                .into(holder.pic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("name", baoTang.getNameOfMuseum());
                ThongTinAll thongTinAll = new ThongTinAll();

                thongTinAll.setArguments(bundle);

                FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, thongTinAll);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (baoTangList != null) {
            return baoTangList.size();
        }
        ;
        return 0;
    }

    class BaoTangViewHolder extends RecyclerView.ViewHolder {
        private TextView nameOfMuseum;
        private TextView address;
        private TextView priceOfTicket;
        private TextView openings;
        // private TextView diadiem;
        // private TextView status;

        private ImageView pic;

        public BaoTangViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfMuseum = (TextView) itemView.findViewById(R.id.nameTxt);
            address = (TextView) itemView.findViewById(R.id.addressTxt);
            priceOfTicket = (TextView) itemView.findViewById(R.id.priceTxt);
            openings = (TextView) itemView.findViewById(R.id.openingsTxt);
            pic = (ImageView) itemView.findViewById(R.id.pic);

        }
    }
}
