package com.example.museum.Khampha.Search;

import static com.example.museum.R.id.rcv_baotang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.R;
import com.example.museum.Trangchu.BaoTang;

import java.util.ArrayList;
import java.util.List;
import com.example.museum.database.query.MuseumQuery;
public class TimKiemBaoTang extends Fragment {
    private RecyclerView rcvBaoTang;
    private SearchView searchView;
    private List<BaoTang> listBaoTang;
    private BaoTangSearchAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.baotang_search);
        View rootView = inflater.inflate(R.layout.baotang_search, container, false);

        searchView = rootView.findViewById(R.id.searchView);
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
        rcvBaoTang = rootView.findViewById(rcv_baotang);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        rcvBaoTang.setLayoutManager(gridLayoutManager);
        listBaoTang = new ArrayList<>();

        listBaoTang = MuseumQuery.getAllMuseums();



        adapter = new BaoTangSearchAdapter(listBaoTang);
        rcvBaoTang.setAdapter(adapter);
        return rootView;

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
