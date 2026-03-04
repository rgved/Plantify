package com.example.plantify_mad_final.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.plantify_mad_final.db.AppDatabase;
import com.example.plantify_mad_final.db.PlantDao;
import com.example.plantify_mad_final.model.Plant;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlantViewModel extends AndroidViewModel {
    private final PlantDao plantDao;
    private final LiveData<List<Plant>> allPlants;
    private final ExecutorService executorService;

    public PlantViewModel(@NonNull Application application) {
        super(application);
        AppDatabase db = AppDatabase.getInstance(application);
        plantDao = db.plantDao();
        allPlants = plantDao.getAllPlants();
        executorService = Executors.newFixedThreadPool(2);
    }

    public LiveData<List<Plant>> getAllPlants() {
        return allPlants;
    }

    public void insert(Plant plant) {
        executorService.execute(() -> plantDao.insert(plant));
    }
}
