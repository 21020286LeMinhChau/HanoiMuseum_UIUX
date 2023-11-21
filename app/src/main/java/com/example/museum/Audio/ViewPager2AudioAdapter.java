package com.example.museum.Audio;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.museum.Audio.Audio2;

public class ViewPager2AudioAdapter extends FragmentStateAdapter {
    public ViewPager2AudioAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Audio1();
            case 1:
                return new Audio2();

        }
        return null;
    }
    @Override
    public int getItemCount () {
        return 2;
    }
}

