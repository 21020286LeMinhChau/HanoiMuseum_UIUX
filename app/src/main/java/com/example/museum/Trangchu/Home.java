package com.example.museum.Trangchu;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.museum.R;
import com.example.museum.database.query.MuseumQuery;
import com.example.museum.database.query.TopicQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Home extends Fragment {
    private RecyclerView rcvBaoTang;
    private List<BaoTang> listBaoTang;
    private BaoTangAdapter baoTangAdapter;
    private RecyclerView rcvChuDe;
    private List<ChuDe> listChuDe;
    private ChuDeAdapter chuDeAdapter;
    private ViewPager2 viewPager2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home, container, false);

        viewPager2 = rootView.findViewById(R.id.viewpager2);
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);
        viewPager2.setAdapter(viewPager2Adapter);

        rcvBaoTang = rootView.findViewById(R.id.viewRecommend);
        rcvChuDe = rootView.findViewById(R.id.viewStyleMuseum);

        ExecuteGetBaoTang executeGetBaoTang = new ExecuteGetBaoTang();
        executeGetBaoTang.execute();


        ExecuteGetChuDe executeGetChuDe = new ExecuteGetChuDe();
        executeGetChuDe.execute();

        return rootView;
    }

    public class ExecuteGetBaoTang extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            List<BaoTang> getListBaoTang = new ArrayList<>();
            getListBaoTang = MuseumQuery.getRandomMuseum(4);

            listBaoTang = new ArrayList<>();
            for (int i = 0; i < getListBaoTang.size(); i++) {
                listBaoTang.add(getListBaoTang.get(i));
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            baoTangAdapter = new BaoTangAdapter(listBaoTang);
            LinearLayoutManager linearLayoutManager_museum = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
            rcvBaoTang.setLayoutManager(linearLayoutManager_museum);
            rcvBaoTang.setAdapter(baoTangAdapter);
        }
    }


    public class ExecuteGetChuDe extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            List<ChuDe> getListChuDe = new ArrayList<>();
            getListChuDe = TopicQuery.getTopics();


            Random random = new Random();
            List<Integer> randomList = new ArrayList<>();
            while (randomList.size() < 4 && randomList.size() < getListChuDe.size()) {
                int randomInt = random.nextInt(getListChuDe.size());
                if (!randomList.contains(randomInt)) {
                    randomList.add(randomInt);
                }
            }

            listChuDe = new ArrayList<>();
            for (int i = 0; i < randomList.size(); i++) {
                listChuDe.add(getListChuDe.get(randomList.get(i)));
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            chuDeAdapter = new ChuDeAdapter(listChuDe);
            LinearLayoutManager linearLayoutManager_theme = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
            rcvChuDe.setLayoutManager(linearLayoutManager_theme);
            rcvChuDe.setAdapter(chuDeAdapter);
        }
    }
}
