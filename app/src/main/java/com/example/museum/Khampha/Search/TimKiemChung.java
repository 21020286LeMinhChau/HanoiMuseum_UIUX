package com.example.museum.Khampha.Search;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.Audio.Audio;
import com.example.museum.Khampha.Thamquan.ClickListiner;
import com.example.museum.Khampha.Thamquan.HienVat;
import com.example.museum.R;
import com.example.museum.Trangchu.BaoTang;
import com.example.museum.database.query.MuseumQuery;
import com.example.museum.database.query.ObjectQuery;

import java.util.ArrayList;
import java.util.List;

public class TimKiemChung extends Fragment {
    private TimKiemBaoTang timKiemBaoTang;
    private TimKiemHienVat timKiemHienVat;
    private TimKiemChung timKiemChung;
    private RecyclerView rcvBaoTang;
    private List<BaoTang> listBaoTang;
    private BaoTangSearchAdapter baoTangSearchAdapter;
    private RecyclerView rcvHienVat;
    private List<HienVat> listHienVat;
    private HienVatSearchAdapter hienVatSearchAdapter;
    private SearchView searchView;
    private ImageButton baotangButton;
    private ImageButton hienvatButton;

    ClickListiner listiner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_tim_kiem_chung, container, false);
        timKiemBaoTang = new TimKiemBaoTang();
        timKiemHienVat = new TimKiemHienVat();
        timKiemChung = new TimKiemChung();

//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tim_kiem_chung);
        baotangButton = (ImageButton) rootView.findViewById(R.id.frameBaoTang);
        hienvatButton = (ImageButton) rootView.findViewById(R.id.frameHienVat);


        searchView = rootView.findViewById(R.id.searchChung);
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

        rcvBaoTang = rootView.findViewById(R.id.chung_pho_bien);
        rcvHienVat = rootView.findViewById(R.id.chung_hien_vat);


        listBaoTang = MuseumQuery.getMaxCommentMuseum(4);
//        listBaoTang.add(new BaoTang("Bảo tàng Văn Học",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item7));
//        listBaoTang.add(new BaoTang("Bảo tàng Lịch Sử Quốc Gia",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item8));
//        listBaoTang.add(new BaoTang("Bảo tàng Địa chất Hà Nội",  " Hà Nội","ĐANG MỞ CỬA" ,R.drawable.item9));
//        listBaoTang.add(new BaoTang("Bảo tàng Phụ Nữ Việt Nam",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item10));


        listHienVat = ObjectQuery.getRandom_n_HienVat(6);

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


        baoTangSearchAdapter = new BaoTangSearchAdapter(listBaoTang);
        LinearLayoutManager linearLayoutManager_baotang = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rcvBaoTang.setLayoutManager(linearLayoutManager_baotang);
        rcvBaoTang.setAdapter(baoTangSearchAdapter);


        hienVatSearchAdapter = new HienVatSearchAdapter(listHienVat, getActivity(), listiner);
        LinearLayoutManager linearLayoutManager_hienvat = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rcvHienVat.setLayoutManager(linearLayoutManager_hienvat);
        rcvHienVat.setAdapter(hienVatSearchAdapter);

//        getChildFragmentManager().beginTransaction()
//                .replace(R.id.searchChung1, timKiemChung)
//                .commit();

        baotangButton.setOnClickListener(view -> {
            replaceFragment(timKiemBaoTang);
        });

        hienvatButton.setOnClickListener(view -> {
            replaceFragment(timKiemHienVat);
        });

        return rootView;
    }

//    public void openHienVatSearch() {
//        Intent intent1 = new Intent(getActivity(),TimKiemHienVat.class);
//        startActivity(intent1);
//
//    }
//
//    public void openBaoTangSearch() {
//        Intent intent2 = new Intent(getActivity(),TimKiemBaoTang.class);
//        startActivity(intent2);
//
//    }

    public void filterList(String text) {
        List<BaoTang> filteredBaoTangList = new ArrayList<>();
        List<HienVat> filteredHienVatList = new ArrayList<>();

        for (BaoTang item : listBaoTang) {
            if (item.getNameOfMuseum().toLowerCase().contains(text.toLowerCase())) {
                filteredBaoTangList.add(item);
            }

        }
        for (HienVat item : listHienVat) {
            if (item.getTenHienVat().toLowerCase().contains(text.toLowerCase())) {
                filteredHienVatList.add(item);
            }
        }


        hienVatSearchAdapter.setFilteredList(filteredHienVatList);
        baoTangSearchAdapter.setFilteredList(filteredBaoTangList);


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = ((FragmentActivity) this.getContext()).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment);
        fragmentTransaction.commit();
    }
}
