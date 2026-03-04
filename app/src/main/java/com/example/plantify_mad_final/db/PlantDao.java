package com.example.plantify_mad_final.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.plantify_mad_final.model.Plant;
import java.util.List;

@Dao
public interface PlantDao {
    @Query("SELECT * FROM plants ORDER BY id DESC")
    LiveData<List<Plant>> getAllPlants();

    @Query("SELECT * FROM plants WHERE isFavorite = 1")
    LiveData<List<Plant>> getFavoritePlants();

    @Insert
    void insert(Plant plant);

    @Update
    void update(Plant plant);

    @Delete
    void delete(Plant plant);
}
