package com.example.museum.Khampha;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.museum.Khampha.Thamquan.ThamquanNew;
import com.example.museum.R;

public class thongtinAll extends Fragment {
    public int count = 3;
    private ThongtinchungNew thongtinchungNew;
    private ThamquanNew thamquanNew;
    private DanhGia danhGia;
    private TextView thongtinchung;
    private TextView thamquan;
    private TextView danhgia;

    @SuppressLint("CutPasteId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.thongtinf, container, false);
        thongtinchungNew = new ThongtinchungNew();
        thamquanNew = new ThamquanNew();

        thongtinchung = rootView.findViewById(R.id.thongtinchung);
        thamquan = rootView.findViewById(R.id.thamquan);
        danhgia = rootView.findViewById(R.id.danhgia);
        ImageView star;
        danhGia = new DanhGia();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, thongtinchungNew)
                .commit();
        thongtinchung.setOnClickListener(view -> {
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, thongtinchungNew)
                    .commit();
            thongtinchung.setTextColor(getResources().getColor(R.color.black));
            thamquan.setTextColor(Color.parseColor("#B9B9B9"));
            danhgia.setTextColor(Color.parseColor("#B9B9B9"));
        });

        thamquan.setOnClickListener(view -> {
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, thamquanNew)
                    .commit();
            thamquan.setTextColor(getResources().getColor(R.color.black));
            thongtinchung.setTextColor(Color.parseColor("#B9B9B9"));
            danhgia.setTextColor(Color.parseColor("#B9B9B9"));
        });
        danhgia.setOnClickListener(view -> {
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, danhGia)
                    .commit();
            thamquan.setTextColor(Color.parseColor("#B9B9B9"));
            thongtinchung.setTextColor(Color.parseColor("#B9B9B9"));
            danhgia.setTextColor(getResources().getColor(R.color.black));
        });
        for (int i = 0; i < 5; i++) {
            String IDName = "star" + (i + 1);
            int resID = getResources().getIdentifier(IDName, "id", getActivity().getPackageName());
            star = rootView.findViewById(resID);
            if (i < count) {
                star.setImageDrawable(getResources().getDrawable(R.drawable.starcolor));
            } else {
                star.setImageDrawable(getResources().getDrawable(R.drawable.star));
            }
        }
        return rootView;
    }
}
