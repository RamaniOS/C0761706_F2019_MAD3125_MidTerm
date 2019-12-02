package com.example.c0761706_f2019_mad3125_midterm.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.c0761706_f2019_mad3125_midterm.Adapter.DetailAdapter;
import com.example.c0761706_f2019_mad3125_midterm.Models.Detail;
import com.example.c0761706_f2019_mad3125_midterm.R;


import java.util.ArrayList;
import java.util.List;

public class ShowDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerViewDetail;
    private DetailAdapter detailAdapter;
    private List<Detail> details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        initViews();
    }

    private void initViews() {
        details = new ArrayList<>();
        details = getIntent().getParcelableArrayListExtra(DetailEditActivity.INTENT_KEY);
        recyclerViewDetail = findViewById(R.id.recyclerviewDetail);
        detailAdapter = new DetailAdapter(details);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewDetail.setLayoutManager(layoutManager);
        recyclerViewDetail.setAdapter(detailAdapter);
    }
}
