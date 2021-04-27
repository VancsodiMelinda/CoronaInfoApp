package com.example.coroninfo.src.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TotalEntity.class, HistoryEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TotalDao getTotalDao();
    public abstract HistoryDao getHistoryDao();
}
