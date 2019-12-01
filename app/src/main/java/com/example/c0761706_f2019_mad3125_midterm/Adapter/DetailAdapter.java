package com.example.c0761706_f2019_mad3125_midterm.Adapter;

import android.opengl.Visibility;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0761706_f2019_mad3125_midterm.Models.CRACustomer;
import com.example.c0761706_f2019_mad3125_midterm.R;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {

    List<CRACustomer> items;

    public DetailAdapter() {
        //this.items = items;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        Log.d("POS", String.valueOf(position));
        if (position != 9) {
            holder.bottomView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return 10;//items.size();
    }

    public static class DetailViewHolder extends RecyclerView.ViewHolder {
        public View bottomView;
        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            bottomView = itemView.findViewById(R.id.viewBottom);
        }
    }
}
