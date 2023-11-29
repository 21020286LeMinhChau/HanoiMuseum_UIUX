package com.example.museum.Khampha;


import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.museum.Khampha.Thamquan.ThamQuanNew;
import com.example.museum.Map.MapsFragment;
import com.example.museum.R;
import com.example.museum.Trangchu.BaoTang;
import com.example.museum.database.query.MuseumQuery;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Yêu cầu đầu vào có nameOfMuseum (có thể truyền qua bundle)
 */
public class ThongTinChungNew extends Fragment  {
    public int count = 3;
    private String nameOfMuseum;
    private List<String> openingTime;
    private List<String> priceFree;
    private List<String> priceNotFree;
    private String gioiThieu;
    private double x_toado;
    private double y_toado;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_thongtinchung, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            nameOfMuseum = bundle.getString("name");
        }



        TextView thoiGian = view.findViewById(R.id.thoigian);
        thoiGian.setVisibility(TextView.GONE);
        TextView xemThem1 = view.findViewById(R.id.xemthem1);
        xemThem1.setPaintFlags(xemThem1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        xemThem1.setOnClickListener(v -> {
            if (thoiGian.getVisibility() == TextView.VISIBLE) {
                thoiGian.setVisibility(TextView.GONE);
                xemThem1.setText("Xem thêm");
            } else if (thoiGian.getVisibility() == TextView.GONE) {
                thoiGian.setVisibility(TextView.VISIBLE);
                xemThem1.setText("Thu gọn");
            }

        });

        TextView giaVe = view.findViewById(R.id.giave);
        giaVe.setVisibility(TextView.GONE);
        TextView xemThem2 = view.findViewById(R.id.xemthem2);
        xemThem2.setPaintFlags(xemThem2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        xemThem2.setOnClickListener(v -> {
            if (giaVe.getVisibility() == TextView.VISIBLE) {
                giaVe.setVisibility(TextView.GONE);
                xemThem2.setText("Xem thêm");
            } else if (giaVe.getVisibility() == TextView.GONE) {
                giaVe.setVisibility(TextView.VISIBLE);
                xemThem2.setText("Thu gọn");
            }
        });

        TextView xemThem3 = view.findViewById(R.id.xemthem3);
        xemThem3.setPaintFlags(xemThem3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView thongTinChung = view.findViewById(R.id.thongtinchungreal);
        xemThem3.setOnClickListener(v -> {
            Log.d("maxLinesdo", String.valueOf(thongTinChung.getMaxLines()));
            if (thongTinChung.getMaxLines() == 2) {
                thongTinChung.setMaxLines(100);
                xemThem3.setText("Thu gọn");
            } else if (thongTinChung.getMaxLines() == 100) {
                thongTinChung.setMaxLines(2);
                xemThem3.setText("Xem thêm");
            }

        });


//        replace fragment @+id/map_thongtinchung -> MapFragment




        ExecuteGetThongTinChungNew executeGetThongTinChungNew = new ExecuteGetThongTinChungNew();
        executeGetThongTinChungNew.execute();




        return view;
    }


    public class ExecuteGetThongTinChungNew extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            BaoTang museum = MuseumQuery.getMuseumByNam_ThongTinChungNew(nameOfMuseum);
            gioiThieu = museum.getGioiThieu();
            priceFree = museum.getPriceFree();
            priceNotFree = museum.getPriceNotFree();
            openingTime = museum.getOpeningTime();
            x_toado = museum.getX_toado();
            y_toado = museum.getY_toado();
            return null;

        }

        @Override
        protected void onPostExecute(Void voids) {
            super.onPostExecute(voids);
            TextView thongTinChung = getView().findViewById(R.id.thongtinchungreal);
            thongTinChung.setText(gioiThieu);

            StringBuilder openingTimeStr = new StringBuilder();

            ArrayList<String> dayOfWeek = new ArrayList<>();
            dayOfWeek.add("Thứ Hai: ");
            dayOfWeek.add("Thứ Ba:  ");
            dayOfWeek.add("Thứ Tư:  ");
            dayOfWeek.add("Thứ Năm: ");
            dayOfWeek.add("Thứ Sáu: ");
            dayOfWeek.add("Thứ Bảy: ");
            dayOfWeek.add("Chủ Nhật:");
            for(int i = 0; i < openingTime.size(); i++) {
                openingTimeStr.append(dayOfWeek.get(i) + openingTime.get(i) + "\n");
            }

            TextView thoiGian = getView().findViewById(R.id.thoigian);
            System.out.println("openintTimeStr: " + openingTimeStr.toString());
            thoiGian.setText(openingTimeStr.toString());


            Bundle bundleMap = new Bundle();
            bundleMap.putDouble("x_toado", x_toado);
            bundleMap.putDouble("y_toado", y_toado);
            MapsFragment mapsFragment = new MapsFragment();
            mapsFragment.setArguments(bundleMap);
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.map_thongtinchung, mapsFragment)
                    .commit();


        }
    }



}