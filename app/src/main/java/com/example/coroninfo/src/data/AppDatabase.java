package com.example.coroninfo.src.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {TotalEntity.class, HistoryEntity.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TotalDao getTotalDao();
    public abstract HistoryDao getHistoryDao();

    private static AppDatabase db = null;

    public AppDatabase() {}

    public static AppDatabase getInstance(Context context)
    {
        if (db == null)
        {
            //db = Room.databaseBuilder(context, AppDatabase.class, "app-database").build();
            db = Room.databaseBuilder(context, AppDatabase.class, "app-database").fallbackToDestructiveMigration().build();
        }

        return db;
    }
}
