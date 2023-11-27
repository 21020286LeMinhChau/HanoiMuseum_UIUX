package com.example.museum.QR;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.Manifest;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;

import com.example.museum.Khampha.Thamquan.HienVat;
import com.example.museum.R;
import com.example.museum.database.query.ObjectQuery;
import com.google.zxing.Result;

public class ScanQR extends AppCompatActivity {
    CodeScanner codeScanner;
    HienVat hienVat;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_scanner);

        permissionCheck();
        CodeScannerView codeScannerView = findViewById(R.id.scanner_view);
        codeScanner = new CodeScanner(this,codeScannerView);
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String objectID = result.getText();
                        if(objectID == null){
                            Toast.makeText(ScanQR.this,"get Error, please try again", Toast.LENGTH_SHORT).show();
                            onResume();
                        }
                        hienVat = ObjectQuery.FindByID(objectID);
                        if(hienVat == null){
                            Toast.makeText(ScanQR.this,"get Error, please try again", Toast.LENGTH_SHORT).show();
                            onResume();
                        }
                        // di den trang thong tin hien vat
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
    }

    private void permissionCheck() {
        if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String []{Manifest.permission.CAMERA},12);
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
