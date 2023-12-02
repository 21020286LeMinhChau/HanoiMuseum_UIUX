package com.example.museum.Khampha.DanhGia;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.Khampha.DanhGia.ClickListiner2;
import com.example.museum.Khampha.Thamquan.ClickListiner;
import com.example.museum.Khampha.Thamquan.HienVat;
import com.example.museum.Khampha.Thamquan.HienVatAdapter;
import com.example.museum.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class DanhGia extends Fragment {

    ListDanhGiaAdapter adapter2;
    RecyclerView recyclerView2;
    ClickListiner2 listiner2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_danhgia, container, false);
        TextInputLayout textInputLayout = view.findViewById(R.id.textInputLayout);
        Button button = view.findViewById(R.id.button);
        EditText editText = textInputLayout.findViewById(R.id.editText);
        TextView numRate = view.findViewById(R.id.num_rate);
        CharSequence h = numRate.getText();
        h = h.subSequence(1, h.length()-1);

        int g = Integer.parseInt((String) h);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        ProgressBar progressBar2 = view.findViewById(R.id.progressBar2);
        ProgressBar progressBar3 = view.findViewById(R.id.progressBar3);
        ProgressBar progressBar4 = view.findViewById(R.id.progressBar4);
        ProgressBar progressBar5 = view.findViewById(R.id.progressBar5);
        List<Integer> numberOfStar = new ArrayList<>();
        progressBar.setMax(g);
        int k = g-20-30-40-50;
        Log.d("DanhGia", String.valueOf(g));
        numberOfStar = getNumberOfStar(k, 20, 30, 40, 20);

        recyclerView2
                = view.findViewById(
                R.id.recyclerView2);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DanhGia", editText.getText().toString());
            }
        });
        List<ListDanhGia> list;
        list = getData();
        setStarAll(list);
        recyclerView2
                = (RecyclerView)view.findViewById(
                R.id.recyclerView2);
        listiner2 = new ClickListiner2() {
            @Override
            public void click(int index){
                Toast.makeText(requireContext(), "Clicked on : " + index, Toast.LENGTH_SHORT).show();
            }
        };
        adapter2 = new ListDanhGiaAdapter(list, requireActivity(),listiner2);

        recyclerView2.setAdapter(adapter2);

        recyclerView2.setLayoutManager(
                new LinearLayoutManager(requireContext()));
        return view;
    }
    public List<ListDanhGia> getData() {
        List<ListDanhGia> list = new ArrayList<>();
        list.add(new ListDanhGia("Nguyễn Văn A", "Đây là giới thiệu chung, giới thiệu chung Đây là giới thiệu chung, giới thiệu chungĐây là giới thiệu chung, giới thiệu chung",2,"1 giờ trước", R.drawable.user, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star));
        list.add(new ListDanhGia("Nguyễn Văn B", "Đây là giới thiệu chung, giới thiệu chung Đây là giới thiệu chung, giới thiệu chungĐây là giới thiệu chung, giới thiệu chung",3,"1 giờ trước", R.drawable.user, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star));
        list.add(new ListDanhGia("Nguyễn Văn C", "Đây là giới thiệu chung, giới thiệu chung Đây là giới thiệu chung, giới thiệu chungĐây là giới thiệu chung, giới thiệu chung",4,"1 giờ trước", R.drawable.user, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star));
        return list;
    }
    public void setStarAll(List<ListDanhGia> listDanhGia){
        for (int i = 0; i < listDanhGia.size(); i++) {

            int count = listDanhGia.get(i).getSoSao();
            for (int j = 0; j < 5; j++) {
                int ID = (j < count) ? R.drawable.starcolor : R.drawable.star;
                listDanhGia.get(i).setStar(j + 1, ID);
            }
        }
    }
    public List<Integer> getNumberOfStar(int star1, int star2, int star3, int star4, int star5){
        List<Integer> numberOfStar = new ArrayList<>();
        numberOfStar.add(star1);
        numberOfStar.add(star2);
        numberOfStar.add(star3);
        numberOfStar.add(star4);
        numberOfStar.add(star5);
        return numberOfStar;
    }
}