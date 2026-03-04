package com.example.plantify_mad_final.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plants")
public class Plant {
    @PrimaryKey(autoGenerate = true)
    public int id;
    
    public String name;
    public String scientificName;
    public String description;
    public String watering;
    public String light;
    public String imagePath;
    public boolean isFavorite;

    public Plant(String name, String scientificName, String description, String watering, String light, String imagePath) {
        this.name = name;
        this.scientificName = scientificName;
        this.description = description;
        this.watering = watering;
        this.light = light;
        this.imagePath = imagePath;
        this.isFavorite = false;
    }
}
