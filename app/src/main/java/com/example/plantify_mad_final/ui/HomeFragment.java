package com.example.plantify_mad_final.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.plantify_mad_final.R;
import com.example.plantify_mad_final.databinding.FragmentHomeBinding;
import com.example.plantify_mad_final.viewmodel.PlantViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private PlantViewModel viewModel;
    private boolean isSignUpMode = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(PlantViewModel.class);
        
        binding.rvCollection.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        viewModel.getAllPlants().observe(getViewLifecycleOwner(), plants -> {
            // Update RecyclerView Adapter (once adapter is implemented)
        });

        binding.btnSignIn.setOnClickListener(v -> showSignInDialog());
        
        return binding.getRoot();
    }

    private void showSignInDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_sign_in, null);
        AlertDialog dialog = new AlertDialog.Builder(requireContext())
                .setView(dialogView)
                .create();
        
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        TextView tvTitle = dialogView.findViewById(R.id.tv_title);
        TextInputLayout tilConfirmPassword = dialogView.findViewById(R.id.til_confirm_password);
        MaterialButton btnAction = dialogView.findViewById(R.id.btn_action);
        MaterialButton btnToggle = dialogView.findViewById(R.id.btn_toggle_mode);

        btnToggle.setOnClickListener(v -> {
            isSignUpMode = !isSignUpMode;
            if (isSignUpMode) {
                tvTitle.setText("Create Account");
                tilConfirmPassword.setVisibility(View.VISIBLE);
                btnAction.setText("Sign Up");
                btnToggle.setText("Already have an account? Sign In");
            } else {
                tvTitle.setText("Welcome Back");
                tilConfirmPassword.setVisibility(View.GONE);
                btnAction.setText("Sign In");
                btnToggle.setText("Create Account");
            }
        });

        btnAction.setOnClickListener(v -> {
            // Handle login/signup logic
            dialog.dismiss();
        });

        dialog.show();
    }
}
