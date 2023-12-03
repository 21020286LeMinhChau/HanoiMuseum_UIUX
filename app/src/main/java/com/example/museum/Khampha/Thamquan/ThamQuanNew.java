package com.example.museum.Khampha.Thamquan;

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

import com.example.museum.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThamQuanNew extends Fragment implements AdapterView.OnItemSelectedListener{
    HienVatAdapter adapter;
    RecyclerView recyclerView;
    View mapThongTin;
    ClickListiner listiner;
    String[] floor = {"Tầng 1", "Tầng 2", "Tầng 3", "Tầng 4", "Tầng 5"};
    LinkedList<HienVat> hienVats = new LinkedList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_thamquan_new, container, false);
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


        List<HienVat> list;
        list = getData();

        recyclerView
                = (RecyclerView)view.findViewById(
                R.id.recyclerView);
        listiner = new ClickListiner() {
            @Override
            public void click(int index){
                Toast.makeText(requireContext(), "Clicked on : " + index, Toast.LENGTH_SHORT).show();
            }
        };
        adapter
                = new HienVatAdapter(
                list, requireActivity(),listiner);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(requireContext()));
        TextView thongTinTomTat = view.findViewById(R.id.thongtintomtat);
        TextView xemthem = view.findViewById(R.id.xemthem);
        xemthem.setOnClickListener(view1 -> {
            if(thongTinTomTat.getMaxLines() == 2)
            {
                thongTinTomTat.setMaxLines(Integer.MAX_VALUE);
                xemthem.setText("Thu gọn");
            }
            else
            {
                thongTinTomTat.setMaxLines(2);
                xemthem.setText("Xem thêm");
            }
        });
        return view;
    }



    public List<HienVat> getData()
    {
        List<HienVat> list = new ArrayList<>();
        list.add(new HienVat("Gốm chu đậu",
                "0:35",
                "Thời Lý", R.drawable.bat, "https://webaudioapi.com/samples/audio-tag/chrono.mp3"));
        list.add(new HienVat("Item 1",
                "0:57",
                "Thời Đinh",R.drawable.bat,"https://webaudioapi.com/samples/audio-tag/chrono.mp3"));
        list.add(new HienVat("Item 2",
                "0:35",
                "Thời Nguyễn",R.drawable.bat,"https://webaudioapi.com/samples/audio-tag/chrono.mp3"));

        return list;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}