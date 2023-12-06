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
    private String textCreate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        check if the Bundle != null
        System.out.println("TimKiemBaoTang");
        if (getArguments() != null) {
            System.out.println("TimKiemBaoTang1");
            textCreate = getArguments().getString("theme");
            System.out.println(textCreate);
        }
        else {
            System.out.println("TimKiemBaoTang2");
            textCreate = "";
        }





        View rootView = inflater.inflate(R.layout.baotang_search, container, false);

        searchView = rootView.findViewById(R.id.searchView);
        searchView.clearFocus();

        searchView.setQuery(textCreate, false);
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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        rcvBaoTang.setLayoutManager(gridLayoutManager);
        listBaoTang = new ArrayList<>();

        listBaoTang = MuseumQuery.getAllMuseums();


        adapter = new BaoTangSearchAdapter(listBaoTang);
        rcvBaoTang.setAdapter(adapter);

        filterList(textCreate);

        return rootView;

    }

    private void filterList(String text) {
        List<BaoTang> filteredList = new ArrayList<>();
        for (BaoTang item : listBaoTang) {
            System.out.println(item.getNameOfMuseum());
            System.out.println(item.getAddress());
            System.out.println(item.getGioiThieu());
            System.out.println(item.getTopic());
            if (item.getNameOfMuseum().toLowerCase().contains(text.toLowerCase())
                    || item.getAddress().toLowerCase().contains(text.toLowerCase())
                    || item.getGioiThieu().toLowerCase().contains(text.toLowerCase())
            ) {
                filteredList.add(item);
            } else {
                List<String> topic = item.getTopic();
                for (String s : topic) {
                    if (s.toLowerCase().contains(text.toLowerCase())) {
                        filteredList.add(item);
                        break;
                    }
                }

            }


        }
        adapter.setFilteredList(filteredList);

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
