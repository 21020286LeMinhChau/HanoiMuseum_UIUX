package com.example.museum;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museum.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular, adapterTheme;
    private RecyclerView recyclerViewPopular, recyclerViewTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        initRecyclerView();
    }



    private void initRecyclerView() {
        ArrayList<ItemsDomain> ItemsArraylist = new ArrayList<>();
        ItemsArraylist.add(new ItemsDomain("Bao tang Ha Noi", "Ha Tinh", "Nghệ thuật", 4000000,"2pm-3pm", "item1"));
//        ItemsArraylist.add(new ItemsDomain("Bao tang Ha Noi", "Ha Tinh", "Nghệ thuật", 4000000,"2pm-3pm", "item1"));
//        ItemsArraylist.add(new ItemsDomain("Bao tang Ha Noi", "Ha Tinh", "Nghệ thuật", 4000000,"2pm-3pm", "item1"));
//        ItemsArraylist.add(new ItemsDomain("Bao tang Ha Noi", "Ha Tinh", "Nghệ thuật", 4000000,"2pm-3pm", "item1"));

        recyclerViewPopular = findViewById(R.id.viewRecommend);
        recyclerViewTheme = findViewById(R.id.viewStyleMuseum);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTheme.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterPopular= new ItemsAdapter(ItemsArraylist);
        adapterTheme = new ItemsAdapter(ItemsArraylist);
        recyclerViewTheme.setAdapter(adapterTheme);
        recyclerViewPopular.setAdapter(adapterPopular);


    }

//    @Override

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.splash_first);
//
//        Button nextButton = findViewById(R.id.button1);
//        nextButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, SplashSecond.class);
//                startActivity(intent);
//            }
//        });
//    }


}
