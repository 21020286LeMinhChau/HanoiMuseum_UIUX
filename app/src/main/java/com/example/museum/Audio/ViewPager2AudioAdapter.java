package com.example.museum.Audio;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.museum.Audio.Audio2;
import com.example.museum.Khampha.Thamquan.HienVat;

import java.util.List;

public class ViewPager2AudioAdapter extends FragmentStateAdapter {

    List<String> listImage;
    public ViewPager2AudioAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

    }

    public ViewPager2AudioAdapter(Audio fragmentActivity, HienVat hienVat) {
        super(fragmentActivity);
        listImage = hienVat.getListImage();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        for (int i = 0; i < listImage.size(); i++) {
            if (position == i) {
                return new AudioImage(listImage.get(i));
            }
        }
        return null;
    }
    @Override
    public int getItemCount () {
        return listImage.size();
    }
}

