package com.example.museum.Khampha.Search;

import static com.example.museum.R.id.rcv_hienvat;

import android.content.Intent;
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

import com.example.museum.Audio.Audio;
import com.example.museum.Khampha.Thamquan.ClickListiner;
import com.example.museum.Khampha.Thamquan.HienVat;
import com.example.museum.R;
import com.example.museum.database.query.ObjectQuery;

import java.util.ArrayList;
import java.util.List;

public class TimKiemHienVat extends Fragment {
    private RecyclerView rcvHienVat;
    private SearchView searchView;
    private List<HienVat> listHienVat;
    private HienVatSearchAdapter adapter;
    ClickListiner listiner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.hienvat_search, container, false);
        listiner = new ClickListiner() {
            @Override
            public void click(int index) {
                Bundle bundle = new Bundle();
                bundle.putString("id", listHienVat.get(index).getID());

                Intent intent = new Intent(getActivity(), Audio.class);
                intent.putExtra("bundle", bundle);

                startActivity(intent);


            }
        };
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.hienvat_search);

        searchView = rootView.findViewById(R.id.searchHienVatView);
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
        rcvHienVat = rootView.findViewById(rcv_hienvat);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        rcvHienVat.setLayoutManager(gridLayoutManager);

        listHienVat = ObjectQuery.getRandom_n_HienVat(8);

        adapter = new HienVatSearchAdapter(listHienVat, getActivity(), listiner);
        rcvHienVat.setAdapter(adapter);
        return rootView;

    }

    private void filterList(String text) {
        List<HienVat> filteredList = new ArrayList<>();
        for (HienVat item : listHienVat) {
            if (item.getTenHienVat().toLowerCase().contains(text.toLowerCase())
                    || item.getAuthor().toLowerCase().contains(text.toLowerCase())
                    || item.getThongTin().toLowerCase().contains(text.toLowerCase())
                    || item.getMuseum().toLowerCase().contains(text.toLowerCase())
            ) {
                filteredList.add(item);
            }

        }

        adapter.setFilteredList(filteredList);

//        if(filteredList.isEmpty()){
//            Toast.makeText(this,"Không có hiện vật", Toast.LENGTH_SHORT).show();
//        }

    }


}
