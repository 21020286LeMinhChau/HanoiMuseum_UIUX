package com.example.museum.Khampha.Search;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.museum.R;
import com.example.museum.Trangchu.BaoTang;
import com.example.museum.Trangchu.BaoTangAdapter;
import com.example.museum.Trangchu.ChuDe;
import com.example.museum.Trangchu.ChuDeAdapter;
import com.example.museum.Trangchu.ViewPager2Adapter;

import java.util.ArrayList;
import java.util.List;

public class TimKiemChung extends Fragment {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tim_kiem_chung);
//    }


    private RecyclerView rcvBaoTang;
    private List<BaoTang> listBaoTang;
    private BaoTangAdapter baoTangAdapter;
    private RecyclerView rcvChuDe;
    private List<ChuDe> listChuDe;
    private ChuDeAdapter chuDeAdapter;
    private ViewPager2 viewPager2;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tim_kiem_chung, container, false);

        rcvBaoTang= view.findViewById(R.id.chung_pho_bien);
        rcvChuDe= view.findViewById(R.id.chung_hien_vat);
//        // Them Bao Tang de xuat
        listBaoTang = new ArrayList<>();
//        BaoTang baoTang1 = new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội", " 100000", "8am-10pm", R.drawable.item1);
//        BaoTang baoTang2 = new BaoTang("Bảo tàng Quân đội Việt Nam", " Hà Nội", " 100000", "8am-10pm", R.drawable.item4);
//        BaoTang baoTang3 = new BaoTang("Bảo tàng Thiên nhiên",  " Hà Nội", " 100000", "8am-10pm", R.drawable.item3);
//        BaoTang baoTang4 = new BaoTang("Bảo tàng Hồ Chí Minh",  " Hà Nội", " 100000", "8am-10pm", R.drawable.item2);
//        listBaoTang.add(baoTang1);
//        listBaoTang.add(baoTang2);
//        listBaoTang.add(baoTang3);
//        listBaoTang.add(baoTang4);
        // Them chu de Bao Tang
        listChuDe = new ArrayList<>();
//        ChuDe chuDe1 = new ChuDe("Quân sự", R.drawable.quansu);
//        ChuDe chuDe2 = new ChuDe("Nghệ thuật", R.drawable.nghethuat);
//        ChuDe chuDe3 = new ChuDe("Dân tộc", R.drawable.dantoc);
//        ChuDe chuDe4 = new ChuDe("Khoa học", R.drawable.khoahoc);

//        listChuDe.add(chuDe1);
//        listChuDe.add(chuDe2);
//        listChuDe.add(chuDe3);
//        listChuDe.add(chuDe4);



        baoTangAdapter = new BaoTangAdapter(listBaoTang);
        LinearLayoutManager linearLayoutManager_museum = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        rcvBaoTang.setLayoutManager(linearLayoutManager_museum);
        rcvBaoTang.setAdapter(baoTangAdapter);

        chuDeAdapter = new ChuDeAdapter(listChuDe);
        LinearLayoutManager linearLayoutManager_theme = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        rcvChuDe.setLayoutManager(linearLayoutManager_theme);
        rcvChuDe.setAdapter(chuDeAdapter);
        return view;
    }


}