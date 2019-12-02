package com.example.c0761706_f2019_mad3125_midterm.Adapter;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0761706_f2019_mad3125_midterm.Models.HomeDetail;
import com.example.c0761706_f2019_mad3125_midterm.R;
import com.example.c0761706_f2019_mad3125_midterm.UI.DetailEditActivity;
import com.example.c0761706_f2019_mad3125_midterm.UI.ShowDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    List<HomeDetail> items;

    public HomeAdapter(List<HomeDetail> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new HomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeViewHolder holder, final int position) {
        final HomeDetail homeDetail = items.get(position);
        holder.txtSin.setText("SIN: " + homeDetail.getSin());
        holder.txtName.setText("Name: " + homeDetail.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                List list = homeDetail.getDetail();
                intent.putParcelableArrayListExtra(DetailEditActivity.INTENT_KEY, (ArrayList<? extends Parcelable>) list);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {
        public TextView txtSin;
        public TextView txtName;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSin = itemView.findViewById(R.id.txtSin);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }
}
