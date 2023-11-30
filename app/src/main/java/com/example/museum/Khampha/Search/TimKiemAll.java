package com.example.museum.Khampha.Search;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.Khampha.Thamquan.HienVat;
import com.example.museum.R;
import com.example.museum.Trangchu.BaoTang;

import java.util.ArrayList;
import java.util.List;
public class TimKiemAll extends AppCompatActivity {
    private RecyclerView rcvBaoTang;
    private List<BaoTang> listBaoTang;
    private BaoTangSearchAdapter baoTangSearchAdapter;
    private RecyclerView rcvHienVat;
    private List<HienVat> listHienVat;
    private HienVatSearchAdapter hienVatSearchAdapter;
    private SearchView searchView;

    @Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_search);
        searchView = findViewById(R.id.searchAllView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        rcvBaoTang= findViewById(R.id.viewBaoTang);
        rcvHienVat= findViewById(R.id.viewHienVat);


        listBaoTang = new ArrayList<>();
        listBaoTang.add(new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội","ĐANG MỞ CỬA" ,R.drawable.item1));
        listBaoTang.add(new BaoTang("Bảo tàng Quân sự",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item2));
        listBaoTang.add(new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item3));
        listBaoTang.add(new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item4));



        listHienVat = new ArrayList<>();
        listHienVat.add(new HienVat("Sách Đường Kách mệnh","Nguyễn Ái Quốc", R.drawable.hienvat1 ));
        listHienVat.add(new HienVat("Ấn vàng Sắc mệnh chi bảo","Thời Nguyễn", R.drawable.hienvat2 ));
        listHienVat.add(new HienVat("Trống đồng Ngọc Lũ","Trống đồng Đông Sơn", R.drawable.hienvat3 ));
        listHienVat.add(new HienVat("Bình Phong","Nguyễn Gia Trí", R.drawable.hienvat4 ));

        baoTangSearchAdapter = new BaoTangSearchAdapter(listBaoTang);
        LinearLayoutManager linearLayoutManager_baotang = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rcvBaoTang.setLayoutManager(linearLayoutManager_baotang);
        rcvBaoTang.setAdapter(baoTangSearchAdapter);
        hienVatSearchAdapter = new HienVatSearchAdapter(listHienVat);
        LinearLayoutManager linearLayoutManager_hienvat = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rcvHienVat.setLayoutManager(linearLayoutManager_hienvat);
        rcvHienVat.setAdapter(hienVatSearchAdapter);
        }
    private void filterList(String text) {
        List<BaoTang> filteredBaoTangList = new ArrayList<>();
        List<HienVat> filteredHienVatList = new ArrayList<>();

        for(BaoTang item : listBaoTang) {
            if(item.getNameOfMuseum().toLowerCase().contains(text.toLowerCase())){
                filteredBaoTangList.add(item);
            }

        }
        for(HienVat item : listHienVat) {
            if(item.getTenHienVat().toLowerCase().contains(text.toLowerCase())){
                filteredHienVatList.add(item);
            }

        }
        hienVatSearchAdapter.setFilteredList(filteredHienVatList);
        baoTangSearchAdapter.setFilteredList(filteredBaoTangList);


    }
}
