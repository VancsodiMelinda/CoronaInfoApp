package com.example.coroninfo.src.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface HistoryDao {
    @Insert
    public void insertHistoryData(HistoryEntity historyData);

    @Insert
    public long insertHistroryDataWithReturn(HistoryEntity historyData);

    @Update
    public void updateHistoryData(HistoryEntity historyData);

    @Update
    public int updateHistoryDataWithReturn(HistoryEntity historyData);

    @Delete
    public void deleteHistoryData(HistoryEntity historyData);

    @Delete
    public int deleteHistoryDataWithReturn(HistoryEntity historyData);

    @Query("SELECT * FROM history")
    public HistoryEntity[] loadAllHistoryData();
}
