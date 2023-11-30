package com.example.museum.Khampha.Search;

import static com.example.museum.R.id.rcv_baotang;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.R;
import com.example.museum.Trangchu.BaoTang;

import java.util.ArrayList;
import java.util.List;

public class TimKiemBaoTang extends AppCompatActivity {
    private RecyclerView rcvBaoTang;
    private SearchView searchView;
    private List<BaoTang> listBaoTang;
    private BaoTangSearchAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baotang_search);

        searchView = findViewById(R.id.searchView);
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
        rcvBaoTang = findViewById(rcv_baotang);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rcvBaoTang.setLayoutManager(gridLayoutManager);
        listBaoTang = new ArrayList<>();
        listBaoTang.add(new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội","ĐANG MỞ CỬA" ,R.drawable.item1));
        listBaoTang.add(new BaoTang("Bảo tàng Quân sự",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item2));
        listBaoTang.add(new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item3));
        listBaoTang.add(new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item4));
        listBaoTang.add(new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội","ĐANG MỞ CỬA" ,R.drawable.item5));
        listBaoTang.add(new BaoTang("Bảo tàng Quân sự",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item6));
        listBaoTang.add(new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội","ĐANG MỞ CỬA" ,R.drawable.item1));
        listBaoTang.add(new BaoTang("Bảo tàng Quân sự",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item2));
        listBaoTang.add(new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item3));
        listBaoTang.add(new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item4));
        listBaoTang.add(new BaoTang("Bảo tàng Mỹ thuật",  " Hà Nội","ĐANG MỞ CỬA" ,R.drawable.item5));
        listBaoTang.add(new BaoTang("Bảo tàng Quân sự",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item6));


        adapter = new BaoTangSearchAdapter(listBaoTang);
        rcvBaoTang.setAdapter(adapter);
    }

    private void filterList(String text) {
        List<BaoTang> filteredList = new ArrayList<>();
        for(BaoTang item : listBaoTang) {
            if(item.getNameOfMuseum().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }

        }
        adapter.setFilteredList(filteredList);
//        if(filteredList.isEmpty()){
//            Toast.makeText(this,"Không có bảo tàng", Toast.LENGTH_SHORT).show();
//        }
//        else {
//
//        }
    }

//    private List<BaoTang> getListBaoTang() {
//        List<BaoTang> listBaoTang = new ArrayList<>();
//
//
//
//
//        return listBaoTang;
//    }
}
