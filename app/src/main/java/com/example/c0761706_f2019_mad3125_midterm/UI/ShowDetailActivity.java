package com.example.c0761706_f2019_mad3125_midterm.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.os.Bundle;

import com.example.c0761706_f2019_mad3125_midterm.Adapter.DetailAdapter;
import com.example.c0761706_f2019_mad3125_midterm.R;

public class ShowDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerViewDetail;
    private DetailAdapter detailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        initViews();
    }

    private void initViews() {
        recyclerViewDetail = findViewById(R.id.recyclerviewDetail);
        detailAdapter = new DetailAdapter();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewDetail.setLayoutManager(layoutManager);

        recyclerViewDetail.setAdapter(detailAdapter);

    }

}
