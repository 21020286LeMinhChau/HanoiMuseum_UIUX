package com.example.museum.Audio;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.museum.R;

import java.io.InputStream;


public class AudioImage extends Fragment {

    String id;

    public AudioImage(String id) {
        this.id = id;

    }
    public AudioImage() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        ImageView imageView = getView().findViewById(R.id.item_audio_image);
//        AssetManager assetManager = getActivity().getAssets();
//        InputStream istr = null;
//        try {
//            istr = assetManager.open("DbI/objects/" + "1" + ".jpg");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        imageView.setImageBitmap(BitmapFactory.decodeStream(istr));
//
//        return inflater.inflate(R.layout.fragment_audio_image, container, false);

        View view = inflater.inflate(R.layout.fragment_audio_image, container, false);
        ImageView imageView = view.findViewById(R.id.item_audio_image);
        AssetManager assetManager = getActivity().getAssets();
        InputStream istr = null;
        try {
            System.out.println("DbI/objects/" + id);
            istr = assetManager.open("DbI/objects/" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        imageView.setImageBitmap(BitmapFactory.decodeStream(istr));

        return view;


    }
}