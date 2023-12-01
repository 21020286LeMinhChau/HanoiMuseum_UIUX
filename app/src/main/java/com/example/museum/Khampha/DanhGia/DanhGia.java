package com.example.museum.Khampha.DanhGia;

import android.content.Context;
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

        recyclerView2
                = (RecyclerView)view.findViewById(
                R.id.recyclerView2);
        listiner2 = new com.example.museum.Khampha.DanhGia.ClickListiner2() {
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
        list.add(new ListDanhGia("Nguyễn Văn A", "Rất hay",2,"1 giờ trước", R.drawable.avatar, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star));
        list.add(new ListDanhGia("Nguyễn Văn B", "Rất hay",2,"1 giờ trước", R.drawable.avatar, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star));
        list.add(new ListDanhGia("Nguyễn Văn C", "Rất hay",2,"1 giờ trước", R.drawable.avatar, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star));
        return list;
    }
//    public List<HienVat> getData()
//    {
//        List<HienVat> list = new ArrayList<>();
//        list.add(new HienVat("Gốm chu đậu",
//                "0:35",
//                "Thời Lý", R.drawable.bat, "https://webaudioapi.com/samples/audio-tag/chrono.mp3"));
//        list.add(new HienVat("Item 1",
//                "0:57",
//                "Thời Đinh",R.drawable.bat,"https://webaudioapi.com/samples/audio-tag/chrono.mp3"));
//        list.add(new HienVat("Item 2",
//                "0:35",
//                "Thời Nguyễn",R.drawable.bat,"https://webaudioapi.com/samples/audio-tag/chrono.mp3"));
//
//        return list;
//    }
}