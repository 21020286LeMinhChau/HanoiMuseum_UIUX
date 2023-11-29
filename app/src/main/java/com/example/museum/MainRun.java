package com.example.museum;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.museum.Khampha.ThongTinAll;
import com.example.museum.Map.MapsFragment;
import com.example.museum.QR.ScanQR;
import com.example.museum.Trangchu.Home;
import com.example.museum.account.profile.profile;
import com.example.museum.databinding.ActivityMainRunBinding;

public class MainRun extends AppCompatActivity {
    ActivityMainRunBinding binding;
    ThongTinAll containerThongTin = new ThongTinAll();
    Home containerHome = new Home();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, containerHome).commit();
        }
        binding = ActivityMainRunBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.navView.setOnItemSelectedListener(item->{
            switch (item.getItemId()) {
                case R.id.homeStart:
                    replaceFragment(new Home());
                    break;
                case R.id.explore:
                    replaceFragment(new ThongTinAll());
                    return true;
                case R.id.scan:
                    replaceFragment(new ScanQR());
                    return true;
                case R.id.profile:
                    replaceFragment(new profile());
                    return true;
                case R.id.map:
                    replaceFragment(new MapsFragment());
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