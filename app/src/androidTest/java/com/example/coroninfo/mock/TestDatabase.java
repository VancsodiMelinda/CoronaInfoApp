package com.example.coroninfo.mock;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.coroninfo.src.data.HistoryDao;
import com.example.coroninfo.src.data.HistoryEntity;
import com.example.coroninfo.src.data.TotalDao;
import com.example.coroninfo.src.data.TotalEntity;

@Database(entities = {TotalEntity.class, HistoryEntity.class}, version = 1)
public abstract class TestDatabase extends RoomDatabase {
    public abstract TotalDao getTotalDao();
    public abstract HistoryDao getHistoryDao();
}
