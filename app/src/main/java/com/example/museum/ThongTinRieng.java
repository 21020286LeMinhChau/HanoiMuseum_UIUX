package com.example.museum;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThongTinRieng extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    HienVatAdapter adapter;
    RecyclerView recyclerView;
    ClickListiner listiner;
    String[] floor = {"Tầng 1", "Tầng 2", "Tầng 3", "Tầng 4", "Tầng 5"};
    LinkedList<HienVat> hienVats = new LinkedList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinrieng);
        Spinner spin = findViewById(R.id.tang);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, floor);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        TextView thongtinchung = findViewById(R.id.thongtinchung);
        Intent intent = new Intent();
        thongtinchung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(ThongTinRieng.this, ThongTinChung.class);
                startActivity(intent);
            }
        });
        Button map = findViewById(R.id.mapbutton);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ThongTinRieng.this, map.class);
                startActivity(intent);
            }
        });
        List<HienVat> list = new ArrayList<>();
        list = getData();

        recyclerView
                = (RecyclerView)findViewById(
                R.id.recyclerView);
        listiner = new ClickListiner() {
            @Override
            public void click(int index){
                Toast.makeText(ThongTinRieng.this, "Clicked on : " + index, Toast.LENGTH_SHORT).show();
            }
        };
        adapter
                = new HienVatAdapter(
                list, getApplication(),listiner);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(ThongTinRieng.this));
        TextView thongTinTomTat = findViewById(R.id.thongtintomtat);
        TextView xemthem = findViewById(R.id.xemthem);
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
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) view).setTextSize(14);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
}
