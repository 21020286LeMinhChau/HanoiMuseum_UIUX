package com.example.museum.QR;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.Manifest;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;

import com.example.museum.Audio.Audio;
import com.example.museum.Gioithieu.SplashSecond;
import com.example.museum.Khampha.Thamquan.HienVat;
import com.example.museum.MainActivity;
import com.example.museum.R;
import com.example.museum.account.TaP.TaP;
import com.example.museum.database.query.ObjectQuery;
import com.google.zxing.Result;

public class ScanQR extends Fragment{
    CodeScanner codeScanner;
    HienVat hienVat;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.qr_scanner, container, false);

        permissionCheck();
        CodeScannerView codeScannerView = view.findViewById(R.id.scanner_view);
        codeScanner = new CodeScanner(getContext(),codeScannerView);
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String objectID = result.getText();
                        if(objectID == null){
                            Toast.makeText(getContext(),"get Error, please try again", Toast.LENGTH_SHORT).show();
                            onResume();
                        }
                        //hienVat = ObjectQuery.FindByID(objectID);
//                        if(hienVat == null){
//                            Toast.makeText(getContext(),"get Error, please try again", Toast.LENGTH_SHORT).show();
//                            onResume();
//                        }
                        // di den trang thong tin hien vat
                        Log.v("success:" ,"yes");
                        Intent intent = new Intent(getContext(), Audio.class).putExtra("Hien vat", "objectID");
                        startActivity(intent);

                    }
                });
            }
        });
        codeScannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codeScanner.startPreview();
            }
        });
        return view;
    }

    public void permissionCheck() {
        if(getContext().checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String []{Manifest.permission.CAMERA},12);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode!=12){
            permissionCheck();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onResume() {
        super.onResume();
        codeScanner.startPreview();
    }

    @Override
    public void onPause() {
        codeScanner.releaseResources();
        super.onPause();
    }
}
