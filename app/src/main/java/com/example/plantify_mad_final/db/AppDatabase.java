package com.example.plantify_mad_final.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.plantify_mad_final.model.Plant;

@Database(entities = {Plant.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract PlantDao plantDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "plant_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
