package com.example.museum.Khampha.DanhGia;

import android.content.Context;
import android.content.Intent;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.Gioithieu.SplashThird;
import com.example.museum.R;
import com.example.museum.account.LoginAccount;
import com.example.museum.database.query.CommentQuery;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class DanhGia extends Fragment {

    ListDanhGiaAdapter adapter2;
    RecyclerView recyclerView2;
    ClickListiner2 listiner2;

    Button closeBtn;
    ConstraintLayout editScreen;
    Button confirmBtn;

    List<ListDanhGia> listComments;



    private int count_vote;
    private double avg_vote;
    private int percentage_vote_5;
    private int percentage_vote_4;
    private int percentage_vote_3;
    private int percentage_vote_2;
    private int percentage_vote_1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_danhgia, container, false);

        listComments = getDataFromMuseum("Bảo tàng Hồ Chí Minh");


        TextInputLayout textInputLayout = view.findViewById(R.id.textInputLayout);
        Button button = view.findViewById(R.id.button);
        EditText editText = textInputLayout.findViewById(R.id.editText);

        TextView numRate = view.findViewById(R.id.textView24);
        numRate.setText(String.format("%.1f", avg_vote));
        
        TextView numVote = view.findViewById(R.id.num_rate);
        numVote.setText(String.valueOf(count_vote));

        closeBtn = view.findViewById(R.id.Close_Button_1);
        editScreen = view.findViewById(R.id.show_screen_1);
        confirmBtn = view.findViewById(R.id.confirm_btn_1);

        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        progressBar.setProgress(percentage_vote_5);
        ProgressBar progressBar2 = view.findViewById(R.id.progressBar2);
        progressBar2.setProgress(percentage_vote_4);
        ProgressBar progressBar3 = view.findViewById(R.id.progressBar3);
        progressBar3.setProgress(percentage_vote_3);
        ProgressBar progressBar4 = view.findViewById(R.id.progressBar4);
        progressBar4.setProgress(percentage_vote_2);
        ProgressBar progressBar5 = view.findViewById(R.id.progressBar5);
        progressBar5.setProgress(percentage_vote_1);


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
                if (LoginAccount.account == null) {
                    editScreen.setVisibility(View.VISIBLE);
                } else {
                    listComments.add(0, new ListDanhGia(LoginAccount.account.getEmail(),
                            editText.getText().toString(),
                            5,
                            "vừa xong"
                            , R.drawable.user, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star, R.drawable.star));
                    setStarAll(listComments);
                    adapter2 = new ListDanhGiaAdapter(listComments, requireActivity(), listiner2);

                    recyclerView2.setAdapter(adapter2);

                    recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
                }
                Log.d("DanhGia", editText.getText().toString());
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editScreen.setVisibility(View.GONE);
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), SplashThird.class);
                startActivity(intent);
            }
        });
        setStarAll(listComments);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView2);
        listiner2 = new ClickListiner2() {
            @Override
            public void click(int index) {
                Toast.makeText(requireContext(), "Clicked on : " + index, Toast.LENGTH_SHORT).show();
            }
        };
        adapter2 = new ListDanhGiaAdapter(listComments, requireActivity(), listiner2);

        recyclerView2.setAdapter(adapter2);

        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
        return view;
    }

    public List<ListDanhGia> getDataFromMuseum(String nameMuseum) {
        List<ListDanhGia> list = new ArrayList<>();
        CommentsMuseum commentsMuseum = CommentQuery.getCommentsMuseumFromMuseum(nameMuseum);
        List<Comment> comments = commentsMuseum.getComments();
        count_vote = commentsMuseum.getCount_vote();
        avg_vote = commentsMuseum.getAvg_vote();
        percentage_vote_5 = commentsMuseum.getPercentage_vote_5();
        percentage_vote_4 = commentsMuseum.getPercentage_vote_4();
        percentage_vote_3 = commentsMuseum.getPercentage_vote_3();
        percentage_vote_2 = commentsMuseum.getPercentage_vote_2();
        percentage_vote_1 = commentsMuseum.getPercentage_vote_1();


        for (int i = 0; i < comments.size(); i++) {
            for (int j = i + 1; j < comments.size(); j++) {
                if (comments.get(i).getTimeInt() > comments.get(j).getTimeInt()) {
                    Comment temp = comments.get(i);
                    comments.set(i, comments.get(j));
                    comments.set(j, temp);
                }
            }
        }


        for (int i = 0; i < comments.size(); i++) {
            list.add(new ListDanhGia(comments.get(i)));
        }


        return list;
    }

    public void setStarAll(List<ListDanhGia> listDanhGia) {
        for (int i = 0; i < listDanhGia.size(); i++) {

            int count = listDanhGia.get(i).getSoSao();
            for (int j = 0; j < 5; j++) {
                int ID = (j < count) ? R.drawable.starcolor : R.drawable.star;
                listDanhGia.get(i).setStar(j + 1, ID);
            }
        }
    }
//
//    public List<Integer> getNumberOfStar(int star1, int star2, int star3, int star4, int star5) {
//        List<Integer> numberOfStar = new ArrayList<>();
//        numberOfStar.add(star1);
//        numberOfStar.add(star2);
//        numberOfStar.add(star3);
//        numberOfStar.add(star4);
//        numberOfStar.add(star5);
//        return numberOfStar;
//    }
}