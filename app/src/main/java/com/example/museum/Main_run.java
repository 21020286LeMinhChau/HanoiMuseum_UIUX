package com.example.museum;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.museum.Khampha.thongtinAll;
import com.example.museum.Trangchu.Home;
import com.example.museum.databinding.ActivityMainRunBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.*;

public class Main_run extends AppCompatActivity {
    ActivityMainRunBinding binding;
    thongtinAll containerThongTin = new thongtinAll();
    Home containerHome = new Home();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainRunBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.navView.setOnItemSelectedListener(item->{
            switch (item.getItemId()) {
                case R.id.homeStart:
                    replaceFragment(containerHome);
                    break;
                case R.id.explore:
                    replaceFragment(containerThongTin);
                    return true;
                case R.id.scan:
                    return true;
                case R.id.profile:
                    return true;
                case R.id.map:
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