package com.example.museum;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.museum.Khampha.Search.TimKiemChung;
import com.example.museum.Khampha.ThongTinAll;
import com.example.museum.Map.MapsFragment;
import com.example.museum.Map.MapsFragmentFullOption;
import com.example.museum.QR.ScanQR;
import com.example.museum.Trangchu.ChuDe;
import com.example.museum.Trangchu.ChuDeAdapter;
import com.example.museum.Trangchu.Home;
import com.example.museum.account.LoginAccount;
import com.example.museum.account.profile.profile;
import com.example.museum.database.MongoDBConnection;
import com.example.museum.database.query.MongoDBQuery;
import com.example.museum.database.query.MuseumQuery;
import com.example.museum.database.query.TopicQuery;
import com.example.museum.databinding.ActivityMainRunBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.realm.Realm;

public class MainRun extends AppCompatActivity {

    ActivityMainRunBinding binding;
    ThongTinAll containerThongTin = new ThongTinAll();
    Home containerHome = new Home();
    public static boolean fromTaP = false;
    public static boolean logOut = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Realm.init(this);
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//        MongoDBConnection.connect();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, containerHome).commit();
        }
        binding = ActivityMainRunBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (fromTaP || logOut) {
            replaceFragment(new profile());
            fromTaP = false;
            logOut = false;
        }
        binding.navView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.homeStart:
                    replaceFragment(new Home());
                    break;
                case R.id.explore:
                    replaceFragment(new TimKiemChung());
                    return true;
                case R.id.scan:
                    replaceFragment(new ScanQR());
                    return true;
                case R.id.profile:
                    replaceFragment(new profile());
                    return true;
                case R.id.map:
                    replaceFragment(new MapsFragmentFullOption());
                    return true;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment);
        fragmentTransaction.commit();
    }


}