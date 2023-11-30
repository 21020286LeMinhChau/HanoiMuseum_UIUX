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

import com.example.museum.Khampha.Thamquan.ClickListiner;
import com.example.museum.Khampha.Thamquan.HienVatAdapter;
import com.example.museum.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class DanhGia extends Fragment {
    ListDanhGiaAdapter adapter2;
    RecyclerView recyclerView;
    ClickListiner listiner;

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
        List<ListDanhGia> list = new ArrayList<>();
        list.add(new ListDanhGia("Nguyễn Văn A", "Hay lắm bà con ơi",3,"1 ngày trước",R.drawable.avatar));
        list.add(new ListDanhGia("Nguyễn Văn B", "Hay lắm bà con ơi",4,"1 ngày trước",R.drawable.avatar));
        list.add(new ListDanhGia("Nguyễn Văn C", "Hay lắm bà con ơi",5,"1 ngày trước",R.drawable.avatar));
        recyclerView
                = (RecyclerView)view.findViewById(
                R.id.recyclerView2);
        listiner = new ClickListiner() {
            @Override
            public void click(int index){
                Toast.makeText(requireContext(), "Clicked on : " + index, Toast.LENGTH_SHORT).show();
            }
        };
        adapter2
                = new ListDanhGiaAdapter(
                list, requireActivity(),listiner);
        recyclerView.setAdapter(adapter2);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(requireContext()));
        return view;
    }
}