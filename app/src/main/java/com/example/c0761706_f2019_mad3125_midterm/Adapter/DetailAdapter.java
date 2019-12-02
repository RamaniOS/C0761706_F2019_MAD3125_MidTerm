package com.example.c0761706_f2019_mad3125_midterm.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0761706_f2019_mad3125_midterm.Models.Detail;
import com.example.c0761706_f2019_mad3125_midterm.R;


import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {

    List<Detail> items;

    public DetailAdapter(List<Detail> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        if (position != items.size() - 1) {
            holder.bottomView.setVisibility(View.GONE);
        }
        Detail detail = items.get(position);
        if ((detail.getValue() == null) && detail.getValue().trim().length() == 0) return;
        holder.txtKey.setText(detail.getKey());
        holder.txtValue.setText(detail.getValue());
//        if (Double.parseDouble(detail.getValue())<0) {
//            holder.txtValue.setTextColor(Color.RED);
//        } else {
//            holder.txtValue.setTextColor(Color.BLACK);
//        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class DetailViewHolder extends RecyclerView.ViewHolder {
        public View bottomView;
        public TextView txtKey;
        public TextView txtValue;
        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            bottomView = itemView.findViewById(R.id.viewBottom);
            txtKey = itemView.findViewById(R.id.txtKey);
            txtValue = itemView.findViewById(R.id.txtValue);
        }
    }
}
