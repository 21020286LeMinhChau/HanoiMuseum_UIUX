package com.example.museum.Khampha.Thamquan;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.Audio.Audio;
import com.example.museum.R;
import com.example.museum.Trangchu.BaoTang;
import com.example.museum.database.query.MuseumQuery;
import com.example.museum.database.query.ObjectQuery;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//public class ThamQuanNew extends Fragment  implements AdapterView.OnItemSelectedListener{
//    HienVatAdapter adapter;
//    RecyclerView recyclerView;
//    View mapThongTin;
//    ClickListiner listiner;
//    String[] floor = {"Tầng 1", "Tầng 2", "Tầng 3", "Tầng 4", "Tầng 5"};
//    LinkedList<HienVat> hienVats = new LinkedList<>();
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(
//                R.layout.fragment_thamquan_new, container, false);
//        Spinner spin = view.findViewById(R.id.tang);
//        spin.setOnItemSelectedListener(this);
//        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, floor);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spin.setAdapter(aa);
//
//        Button map = view.findViewById(R.id.mapbutton);
//        mapThongTin = view.findViewById(R.id.include);
//        View thamquan = view.findViewById(R.id.scrollThamquan);
//
//        map.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mapThongTin.setVisibility(View.VISIBLE);
//                thamquan.setVisibility(View.GONE);
//
//                ImageButton back = mapThongTin.findViewById(R.id.back);
//                PDFView pdfView = mapThongTin.findViewById(R.id.pdfView);
//                pdfView.fromAsset("map1.pdf").onLoad(new OnLoadCompleteListener() {
//                    @Override
//                    public void loadComplete(int nbPages) {
//                        Log.d("TAG", "loadComplete: " + nbPages);
//
//                    }
//                }).load();
//                back.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        mapThongTin.setVisibility(View.GONE);
//                        thamquan.setVisibility(View.VISIBLE);
//                    }
//                });
//            }
//        });
//
//
//        List<HienVat> list;
//        list = getData();
//
//        recyclerView
//                = (RecyclerView)view.findViewById(
//                R.id.recyclerView);
//        listiner = new ClickListiner() {
//            @Override
//            public void click(int index){
//                Intent intent = new Intent(getActivity(), Audio.class);
//                startActivity(intent);
//
//            }
//        };
//        adapter
//                = new HienVatAdapter(
//                list, requireActivity(),listiner);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(
//                new LinearLayoutManager(requireContext()));
//        TextView thongTinTomTat = view.findViewById(R.id.thongtintomtat);
//        TextView xemthem = view.findViewById(R.id.xemthem);
//        xemthem.setOnClickListener(view1 -> {
//            if(thongTinTomTat.getMaxLines() == 2)
//            {
//                thongTinTomTat.setMaxLines(Integer.MAX_VALUE);
//                xemthem.setText("Thu gọn");
//            }
//            else
//            {
//                thongTinTomTat.setMaxLines(2);
//                xemthem.setText("Xem thêm");
//            }
//        });
//        return view;
//    }
//
//
//
//
//
//
//    public List<HienVat> getData()
//    {
//        List<HienVat> list = new ArrayList<>();
//        list.add(new HienVat("Bình Phong",
//                "0:35",
//                "Nguyễn Gia Trí", R.drawable.hienvat4, "https://webaudioapi.com/samples/audio-tag/chrono.mp3"));
//        list.add(new HienVat("Kết nạp Đảng ở Điện Biên Phủ",
//                "0:57",
//                "Nguyễn Sáng",R.drawable.hienvat9,"https://webaudioapi.com/samples/audio-tag/chrono.mp3"));
//        list.add(new HienVat("Hai thiếu nữ và em bé",
//                "0:35",
//                "Tô Ngọc Vân",R.drawable.hienvat10,"https://webaudioapi.com/samples/audio-tag/chrono.mp3"));
//
//        return list;
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//}

public class ThamQuanNew extends Fragment implements AdapterView.OnItemSelectedListener {
    HienVatAdapter adapter;
    RecyclerView recyclerView;
    View mapThongTin;
    ClickListiner listiner;
    String[] floor = {"Tầng 1", "Tầng 2", "Tầng 3", "Tầng 4", "Tầng 5"};
    String nameOfMuseum;
    String gioiThieu;
    List<HienVat> listHienVat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_thamquan_new, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            nameOfMuseum = bundle.getString("name");
        }


        Spinner spin = view.findViewById(R.id.tang);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, floor);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        Button map = view.findViewById(R.id.mapbutton);
        mapThongTin = view.findViewById(R.id.include);
        View thamquan = view.findViewById(R.id.scrollThamquan);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapThongTin.setVisibility(View.VISIBLE);
                thamquan.setVisibility(View.GONE);

                ImageButton back = mapThongTin.findViewById(R.id.back);
                PDFView pdfView = mapThongTin.findViewById(R.id.pdfView);
                pdfView.fromAsset("map1.pdf").onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int nbPages) {
                        Log.d("TAG", "loadComplete: " + nbPages);

                    }
                }).load();
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mapThongTin.setVisibility(View.GONE);
                        thamquan.setVisibility(View.VISIBLE);
                    }
                });
            }
        });

        ExecuteGetThamQuan executeGetThamQuan = new ExecuteGetThamQuan();
        executeGetThamQuan.execute();


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
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

        TextView thongTinTomTat = view.findViewById(R.id.thongtintomtat);
        TextView xemthem = view.findViewById(R.id.xemthem);
        xemthem.setOnClickListener(view1 -> {
            if (thongTinTomTat.getMaxLines() == 2) {
                thongTinTomTat.setMaxLines(Integer.MAX_VALUE);
                xemthem.setText("Thu gọn");
            } else {
                thongTinTomTat.setMaxLines(2);
                xemthem.setText("Xem thêm");
            }
        });
        return view;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public class ExecuteGetThamQuan extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            BaoTang museum = MuseumQuery.getMuseumByNam_ThongTinChungNew(nameOfMuseum);
            gioiThieu = museum.getGioiThieu();
            listHienVat = ObjectQuery.getHienVatFromMuseum(nameOfMuseum);
            return null;

        }

        @Override
        protected void onPostExecute(Void voids) {
            adapter = new HienVatAdapter(listHienVat, requireActivity(), listiner);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(
                    new LinearLayoutManager(requireContext()));
        }
    }
}