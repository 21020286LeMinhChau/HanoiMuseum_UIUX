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
import com.example.museum.Khampha.Search.TimKiemBaoTang;
import com.example.museum.Khampha.ThongTinAll;
import com.example.museum.R;

import java.util.List;

public class ChuDeAdapter extends  RecyclerView.Adapter<ChuDeAdapter.ChuDeViewHolder> {
    private List<ChuDe> chuDeList;

    public ChuDeAdapter(List<ChuDe> chuDeList) {
        this.chuDeList = chuDeList;
    }

    @NonNull
    @Override
    public ChuDeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_viewholder, parent,false);
        return new ChuDeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChuDeViewHolder holder, int position) {
        ChuDe chuDe = chuDeList.get(position);
        if(chuDe == null){
            return;
        }

        holder.theme.setText(chuDe.getTheme());

//        holder.pic.setImageResource(chuDe.getPicture());

//        Glide.with(holder.itemView.getContext())
//                .load(chuDe.getPicture())
//                .into(holder.pic);
        Glide.with(holder.itemView.getContext())
                .load("file:///android_asset/DbI/museums_chude/" + chuDe.getPicture())
                .into(holder.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("theme", chuDe.getTheme());


                TimKiemBaoTang timKiemBaoTang = new TimKiemBaoTang();
                timKiemBaoTang.setArguments(bundle);


                FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, timKiemBaoTang);
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        if( chuDeList != null){
            return chuDeList.size();
        };
        return 0;
    }

    class ChuDeViewHolder extends RecyclerView.ViewHolder{
        private TextView theme;
        private ImageView pic;
        public ChuDeViewHolder(@NonNull View itemView) {
            super(itemView);
            theme = (TextView) itemView.findViewById(R.id.themeTxt1);
            pic =(ImageView) itemView.findViewById(R.id.picTheme);




        }
    }
}
