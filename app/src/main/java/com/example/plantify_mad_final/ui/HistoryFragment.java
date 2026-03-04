package com.example.plantify_mad_final.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.plantify_mad_final.adapter.HistoryAdapter;
import com.example.plantify_mad_final.databinding.FragmentHistoryBinding;
import com.example.plantify_mad_final.model.Plant;
import com.example.plantify_mad_final.viewmodel.PlantViewModel;
import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {
    private FragmentHistoryBinding binding;
    private PlantViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(PlantViewModel.class);

        binding.rvHistory.setLayoutManager(new LinearLayoutManager(requireContext()));
        
        // Load Dummy History Data
        List<Plant> dummyHistory = new ArrayList<>();
        dummyHistory.add(new Plant("Fiddle Leaf Fig", "Ficus lyrata", "Large leaves", "Weekly", "Bright", ""));
        dummyHistory.add(new Plant("Snake Plant", "Sansevieria", "Air purifier", "Bi-weekly", "Low", ""));
        dummyHistory.add(new Plant("Pothos", "Epipremnum aureum", "Trailing vine", "Weekly", "Any", ""));
        
        binding.rvHistory.setAdapter(new HistoryAdapter(dummyHistory));

        return binding.getRoot();
    }
}
