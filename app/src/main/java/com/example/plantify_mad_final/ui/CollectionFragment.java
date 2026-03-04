package com.example.plantify_mad_final.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.plantify_mad_final.adapter.PlantShopAdapter;
import com.example.plantify_mad_final.databinding.FragmentCollectionBinding;
import com.example.plantify_mad_final.model.Plant;
import com.example.plantify_mad_final.viewmodel.PlantViewModel;
import java.util.ArrayList;
import java.util.List;

public class CollectionFragment extends Fragment {
    private FragmentCollectionBinding binding;
    private PlantViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCollectionBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(PlantViewModel.class);

        binding.rvCollection.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        
        // Load Dummy Data
        List<Plant> dummyPlants = new ArrayList<>();
        dummyPlants.add(new Plant("Snake Plant", "Sansevieria trifasciata", "Air purifying plant", "Every 2 weeks", "Low to bright", ""));
        dummyPlants.add(new Plant("Monstera", "Monstera deliciosa", "Swiss cheese plant", "Weekly", "Indirect bright", ""));
        dummyPlants.add(new Plant("Peace Lily", "Spathiphyllum", "Beautiful white flowers", "Twice a week", "Medium", ""));
        dummyPlants.add(new Plant("Fiddle Leaf", "Ficus lyrata", "Large glossy leaves", "Weekly", "Bright indirect", ""));
        dummyPlants.add(new Plant("Spider Plant", "Chlorophytum comosum", "Easy to grow", "Weekly", "Medium", ""));
        dummyPlants.add(new Plant("Aloe Vera", "Aloe barbadensis", "Medicinal properties", "Every 3 weeks", "Bright direct", ""));

        binding.rvCollection.setAdapter(new PlantShopAdapter(dummyPlants));

        return binding.getRoot();
    }
}
