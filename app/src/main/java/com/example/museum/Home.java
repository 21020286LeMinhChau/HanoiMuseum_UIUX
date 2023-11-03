package com.example.museum;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private RecyclerView rcvBaoTang;
    private List<BaoTang> listBaoTang;
    private BaoTangAdapter baoTangAdapter;
    private RecyclerView rcvChuDe;
    private List<ChuDe> listChuDe;
    private ChuDeAdapter chuDeAdapter;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        viewPager2 = findViewById(R.id.viewpager2);
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);
        viewPager2.setAdapter(viewPager2Adapter);




        rcvBaoTang= findViewById(R.id.viewRecommend);
        rcvChuDe= findViewById(R.id.viewStyleMuseum);
        // Them Bao Tang de xuat
        listBaoTang = new ArrayList<>();
         BaoTang baoTang1 = new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội", " 100000", "8am-10pm", R.drawable.item1);
        BaoTang baoTang2 = new BaoTang("Bảo tàng Quân đội Việt Nam", " Hà Nội", " 100000", "8am-10pm", R.drawable.item4);
        BaoTang baoTang3 = new BaoTang("Bảo tàng Thiên nhiên",  " Hà Nội", " 100000", "8am-10pm", R.drawable.item3);
        BaoTang baoTang4 = new BaoTang("Bảo tàng Hồ Chí Minh",  " Hà Nội", " 100000", "8am-10pm", R.drawable.item2);
        listBaoTang.add(baoTang1);
        listBaoTang.add(baoTang2);
        listBaoTang.add(baoTang3);
        listBaoTang.add(baoTang4);
        // Them chu de Bao Tang
        listChuDe = new ArrayList<>();
        ChuDe chuDe1 = new ChuDe("Quân sự", R.drawable.quansu);
        ChuDe chuDe2 = new ChuDe("Nghệ thuật", R.drawable.nghethuat);
        ChuDe chuDe3 = new ChuDe("Dân tộc", R.drawable.dantoc);
        ChuDe chuDe4 = new ChuDe("Khoa học", R.drawable.khoahoc);

        listChuDe.add(chuDe1);
        listChuDe.add(chuDe2);
        listChuDe.add(chuDe3);
        listChuDe.add(chuDe4);



        baoTangAdapter = new BaoTangAdapter(listBaoTang);
        LinearLayoutManager linearLayoutManager_museum = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rcvBaoTang.setLayoutManager(linearLayoutManager_museum);
        rcvBaoTang.setAdapter(baoTangAdapter);

        chuDeAdapter = new ChuDeAdapter(listChuDe);
        LinearLayoutManager linearLayoutManager_theme = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rcvChuDe.setLayoutManager(linearLayoutManager_theme);
        rcvChuDe.setAdapter(chuDeAdapter);
    }
}
