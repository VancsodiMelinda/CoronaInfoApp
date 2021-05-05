package com.example.coroninfo.src.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TotalDao {
    @Insert
    public void insertTotalData(TotalEntity totalData);

    @Insert
    public long insertTotalDataWithReturn(TotalEntity totalData);

    @Update
    public void updateTotalData(TotalEntity totalData);

    @Update
    public int updateTotalDataWithReturn(TotalEntity totalData);

    @Delete
    public void deleteTotalData(TotalEntity totalData);

    @Delete
    public int deleteTotalDataWithReturn(TotalEntity totalData);

    @Query("SELECT * FROM total")
    public TotalEntity[] loadAllTotalData();

    @Query("SELECT * FROM total WHERE country = :param")
    public TotalEntity loadTotalDataByCountry(String param);
}
