package com.example.museum;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private RecyclerView rcvBaoTang;
    private List<BaoTang> listBaoTang;
    private BaoTangAdapter baoTangAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        rcvBaoTang= findViewById(R.id.viewRecommend);
        listBaoTang = new ArrayList<>();
         BaoTang baoTang1 = new BaoTang("Bảo tàng Nghệ thuật", "Nghệ thuật", " Hà Nội", " 100000", "8am-10pm", R.drawable.item1);
        BaoTang baoTang2 = new BaoTang("Bảo tàng Nghệ thuật", "Nghệ thuật", " Hà Nội", " 100000", "8am-10pm", R.drawable.hanoimuseum);
        BaoTang baoTang3 = new BaoTang("Bảo tàng Nghệ thuật", "Nghệ thuật", " Hà Nội", " 100000", "8am-10pm", R.drawable.hanoimuseum);
        BaoTang baoTang4 = new BaoTang("Bảo tàng Nghệ thuật", "Nghệ thuật", " Hà Nội", " 100000", "8am-10pm", R.drawable.hanoimuseum);
        listBaoTang.add(baoTang1);
        listBaoTang.add(baoTang2);
        listBaoTang.add(baoTang3);
        listBaoTang.add(baoTang4);


        baoTangAdapter = new BaoTangAdapter(listBaoTang);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rcvBaoTang.setLayoutManager(linearLayoutManager);
        rcvBaoTang.setAdapter(baoTangAdapter);
    }
}
