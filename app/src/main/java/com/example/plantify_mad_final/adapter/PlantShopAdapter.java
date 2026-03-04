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

public class PlantShopAdapter extends RecyclerView.Adapter<PlantShopAdapter.ViewHolder> {
    private List<Plant> plants;

    public PlantShopAdapter(List<Plant> plants) {
        this.plants = plants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plant plant = plants.get(position);
        holder.tvName.setText(plant.name);
        holder.tvScientific.setText(plant.scientificName);
        // holder.ivPlant.setImageResource(R.drawable.ic_leaf); // Use default for now
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvScientific;
        ImageView ivPlant;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_plant_name);
            tvScientific = itemView.findViewById(R.id.tv_scientific_name);
            ivPlant = itemView.findViewById(R.id.iv_plant);
        }
    }
}
