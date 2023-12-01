package com.example.museum.Khampha;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.museum.Khampha.DanhGia.DanhGia;
import com.example.museum.Khampha.Thamquan.ThamQuanNew;
import com.example.museum.R;
import com.example.museum.Trangchu.BaoTang;
import com.example.museum.database.query.MuseumQuery;

/**
 * Yêu cầu đầu vào có nameOfMuseum (có thể truyền qua bundle)
 */
public class ThongTinAll extends Fragment {
    public int count = 3;
    private ThongTinChungNew thongtinchungNew;
    private ThamQuanNew thamquanNew;
    private DanhGia danhGia;
    private TextView thongtinchung;
    private TextView thamquan;
    private TextView danhGiaText;
    private String nameOfMuseum;
    private String picture;
    private int comment;
    private double vote;


    @SuppressLint("CutPasteId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.thongtinf, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            nameOfMuseum = bundle.getString("name");
        }


        TextView nameMuseum = rootView.findViewById(R.id.textView9);
        nameMuseum.setText(nameOfMuseum);
        ExecuteGetThongTinAll executeGetThongTinAll = new ExecuteGetThongTinAll();
        executeGetThongTinAll.execute();


        ImageView star;
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


        thongtinchungNew = new ThongTinChungNew();
        thamquanNew = new ThamQuanNew();
        danhGia = new DanhGia();

        thongtinchungNew.setArguments(bundle);
        thamquanNew.setArguments(bundle);
        danhGia.setArguments(bundle);

        thongtinchung = rootView.findViewById(R.id.thongtinchung);
        thamquan = rootView.findViewById(R.id.thamquan);
        danhGiaText = rootView.findViewById(R.id.danhgia);

        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, thongtinchungNew)
                .commit();


        thongtinchung.setOnClickListener(view -> {
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, thongtinchungNew)
                    .commit();
            thongtinchung.setTextColor(getResources().getColor(R.color.black));
            thamquan.setTextColor(Color.parseColor("#B9B9B9"));
            danhGiaText.setTextColor(Color.parseColor("#B9B9B9"));
        });

        thamquan.setOnClickListener(view -> {
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, thamquanNew)
                    .commit();
            thamquan.setTextColor(getResources().getColor(R.color.black));
            thongtinchung.setTextColor(Color.parseColor("#B9B9B9"));
            danhGiaText.setTextColor(Color.parseColor("#B9B9B9"));
        });


        danhGiaText.setOnClickListener(view -> {
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, danhGia)
                    .commit();
            thamquan.setTextColor(Color.parseColor("#B9B9B9"));
            thongtinchung.setTextColor(Color.parseColor("#B9B9B9"));
            danhGiaText.setTextColor(getResources().getColor(R.color.black));
        });


        return rootView;
    }


    public class ExecuteGetThongTinAll extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            BaoTang museum = MuseumQuery.getMuseumByName_ThongTinAll(nameOfMuseum);
            picture = museum.getPic();
            comment = museum.getComment();
            vote = museum.getVote();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ImageView pic = getView().findViewById(R.id.imageView5);
            TextView commentTxt = getView().findViewById(R.id.textView11);
//            TextView voteTxt = getView().findViewById(R.id.voteTxt);
            Glide.with(getContext())
                    .load(picture)
                    .into(pic);
            commentTxt.setText(comment + " đánh giá");
//            voteTxt.setText(vote + "");



        }
    }
}
