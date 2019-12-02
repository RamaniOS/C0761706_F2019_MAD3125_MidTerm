package com.example.c0761706_f2019_mad3125_midterm.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.c0761706_f2019_mad3125_midterm.Adapter.HomeAdapter;
import com.example.c0761706_f2019_mad3125_midterm.Models.HomeDetail;
import com.example.c0761706_f2019_mad3125_midterm.R;
import com.example.c0761706_f2019_mad3125_midterm.Utilities.DetailCustomer;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {

    private RecyclerView homeRecyclerView;
    private HomeAdapter homeAdapter;
    List<HomeDetail> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
    }

    private void initViews() {
        items = new ArrayList<>();
        items = DetailCustomer.getHomeDetails();
        homeRecyclerView = findViewById(R.id.recycleViewHome);
        homeAdapter = new HomeAdapter(items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        homeRecyclerView.setLayoutManager(layoutManager);
        homeRecyclerView.setAdapter(homeAdapter);
    }
}
