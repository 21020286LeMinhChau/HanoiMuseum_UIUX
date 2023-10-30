package com.example.museum;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

public class ThongTinRieng extends AppCompatActivity {
    String[] floor = {"Tầng 1", "Tầng 2", "Tầng 3", "Tầng 4", "Tầng 5"};
    LinkedList<HienVat> hienVats = new LinkedList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinrieng);
        Spinner spinner = findViewById(R.id.tang);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                floor);
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinner.setAdapter(ad);
        hienVats.add(new HienVat("Hoa sen", "1 tiếng", "Hoa sen là loài hoa đặc trưng của Việt Nam", "sen"));
    }

    public void onItemSelected(
            AdapterView<?> arg0,
            View arg1,
            int position,
            long id)
    {
        // TODO Auto-generated method stub
        Toast.makeText(getApplicationContext(),
                        floor[position],
                        Toast.LENGTH_LONG)
                .show();
    }


    public void onNothingSelected(AdapterView<?> arg0)
    {
        // Auto-generated method stub
    }
}
