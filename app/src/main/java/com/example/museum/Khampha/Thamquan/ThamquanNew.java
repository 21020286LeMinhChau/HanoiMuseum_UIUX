package com.example.museum.Khampha.Thamquan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.Khampha.thongtin;
import com.example.museum.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThamquanNew extends Fragment implements AdapterView.OnItemSelectedListener{
    HienVatAdapter adapter;
    RecyclerView recyclerView;
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
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(requireContext(), com.example.museum.Khampha.Thamquan.map.class);
                startActivity(intent);
            }
        });
        List<HienVat> list = new ArrayList<>();
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
        xemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });
        return view;
    }



    private List<HienVat> getData()
    {
        List<HienVat> list = new ArrayList<>();
        list.add(new HienVat("Gốm chu đậu",
                "0:35",
                "Thời Lý", R.drawable.bat));
        list.add(new HienVat("Second Exam",
                "June 09, 2015",
                "b of l"));
        list.add(new HienVat("My Test Exam",
                "April 27, 2017",
                "This is testing exam .."));

        return list;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}