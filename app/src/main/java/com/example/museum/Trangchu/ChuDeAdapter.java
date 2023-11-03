package com.example.museum.Trangchu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        holder.pic.setImageResource(chuDe.getPic());



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
