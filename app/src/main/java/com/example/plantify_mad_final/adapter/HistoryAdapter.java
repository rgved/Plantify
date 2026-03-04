package com.example.plantify_mad_final.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.plantify_mad_final.R;
import com.example.plantify_mad_final.model.Plant;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private List<Plant> plants;

    public HistoryAdapter(List<Plant> plants) {
        this.plants = plants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plant plant = plants.get(position);
        holder.tvName.setText(plant.name);
        holder.tvScientific.setText(plant.scientificName);
        holder.tvDate.setText("Scanned on Oct 24, 2023"); // Dummy date
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvScientific, tvDate;
        ImageView ivPlant;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_plant_name_history);
            tvScientific = itemView.findViewById(R.id.tv_scientific_name_history);
            tvDate = itemView.findViewById(R.id.tv_scan_date);
            ivPlant = itemView.findViewById(R.id.iv_plant_history);
        }
    }
}
