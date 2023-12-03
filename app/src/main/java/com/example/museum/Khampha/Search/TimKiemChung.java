package com.example.museum.Khampha.Search;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.Khampha.Thamquan.HienVat;
import com.example.museum.Khampha.Thamquan.ThamQuanNew;
import com.example.museum.Khampha.ThongTinChungNew;
import com.example.museum.R;
import com.example.museum.Trangchu.BaoTang;

import java.util.ArrayList;
import java.util.List;
public class TimKiemChung extends Fragment {
    private TimKiemBaoTang timKiemBaoTang;
    private  TimKiemHienVat timKiemHienVat;
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

        rcvBaoTang= rootView.findViewById(R.id.chung_pho_bien);
        rcvHienVat= rootView.findViewById(R.id.chung_hien_vat);


        listBaoTang = new ArrayList<>();
        listBaoTang.add(new BaoTang("Bảo tàng Văn Học",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item7));
        listBaoTang.add(new BaoTang("Bảo tàng Lịch Sử Quốc Gia",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item8));
        listBaoTang.add(new BaoTang("Bảo tàng Địa chất Hà Nội",  " Hà Nội","ĐANG MỞ CỬA" ,R.drawable.item9));
        listBaoTang.add(new BaoTang("Bảo tàng Phụ Nữ Việt Nam",  " Hà Nội","ĐANG MỞ CỬA",R.drawable.item10));



        listHienVat = new ArrayList<>();
        listHienVat.add(new HienVat("Sách Đường Kách mệnh","Nguyễn Ái Quốc", R.drawable.hienvat1 ));
        listHienVat.add(new HienVat("Ấn vàng Sắc mệnh chi bảo","Thời Nguyễn", R.drawable.hienvat2 ));
        listHienVat.add(new HienVat("Trống đồng Ngọc Lũ","Trống đồng Đông Sơn", R.drawable.hienvat3 ));
        listHienVat.add(new HienVat("Bình Phong","Nguyễn Gia Trí", R.drawable.hienvat4 ));
        listHienVat.add(new HienVat("Gióng","Nguyễn Tư Nghiêm", R.drawable.hienvat5 ));
        listHienVat.add(new HienVat("Gà thư hùng","Tranh dân gian Đông Hồ", R.drawable.hienvat6 ));


        baoTangSearchAdapter = new BaoTangSearchAdapter(listBaoTang);
        LinearLayoutManager linearLayoutManager_baotang = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        rcvBaoTang.setLayoutManager(linearLayoutManager_baotang);
        rcvBaoTang.setAdapter(baoTangSearchAdapter);
        hienVatSearchAdapter = new HienVatSearchAdapter(listHienVat);
        LinearLayoutManager linearLayoutManager_hienvat = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        rcvHienVat.setLayoutManager(linearLayoutManager_hienvat);
        rcvHienVat.setAdapter(hienVatSearchAdapter);

//        getChildFragmentManager().beginTransaction()
//                .replace(R.id.searchChung1, timKiemChung)
//                .commit();

        baotangButton.setOnClickListener(view -> {
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.searchChung1, timKiemBaoTang)
                    .commit();
        });

        hienvatButton.setOnClickListener(view -> {
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.searchChung1, timKiemHienVat)
                    .commit();
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
