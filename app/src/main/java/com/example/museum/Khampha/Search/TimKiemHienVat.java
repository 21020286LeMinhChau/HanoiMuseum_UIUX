package com.example.museum.Khampha.Search;

import static com.example.museum.R.id.rcv_hienvat;

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

import com.example.museum.Khampha.Thamquan.HienVat;
import com.example.museum.R;

import java.util.ArrayList;
import java.util.List;

public class TimKiemHienVat extends Fragment {
    private RecyclerView rcvHienVat;
    private SearchView searchView;
    private List<HienVat> listHienVat;
    private HienVatSearchAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.hienvat_search, container, false);

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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        rcvHienVat.setLayoutManager(gridLayoutManager);
        listHienVat = new ArrayList<>();
        listHienVat.add(new HienVat("Sách Đường Kách mệnh","Nguyễn Ái Quốc", R.drawable.hienvat1 ));
        listHienVat.add(new HienVat("Ấn vàng Sắc mệnh chi bảo","Thời Nguyễn", R.drawable.hienvat2 ));
        listHienVat.add(new HienVat("Trống đồng Ngọc Lũ","Trống đồng Đông Sơn", R.drawable.hienvat3 ));
        listHienVat.add(new HienVat("Bình Phong","Nguyễn Gia Trí", R.drawable.hienvat4 ));
        listHienVat.add(new HienVat("Gióng","Nguyễn Tư Nghiêm", R.drawable.hienvat5 ));
        listHienVat.add(new HienVat("Gà thư hùng","Tranh dân gian Đông Hồ", R.drawable.hienvat6 ));
        listHienVat.add(new HienVat("Thạp","Gốm", R.drawable.hienvat7 ));
        listHienVat.add(new HienVat("Chậu cảnh hình con lân","Gốm", R.drawable.hienvat8 ));





        adapter = new HienVatSearchAdapter(listHienVat);
        rcvHienVat.setAdapter(adapter);
        return rootView;

    }

    private void filterList(String text) {
        List<HienVat> filteredList = new ArrayList<>();
        for(HienVat item : listHienVat) {
            if(item.getTenHienVat().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }

        }

            adapter.setFilteredList(filteredList);

//        if(filteredList.isEmpty()){
//            Toast.makeText(this,"Không có hiện vật", Toast.LENGTH_SHORT).show();
//        }

    }


}
