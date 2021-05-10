package com.example.coroninfo.src.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class HistoryEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String date;
    public String status;
    public int caseNumber;

    public HistoryEntity(int id, String date, String status, int caseNumber)
    {
        this.id = id;
        this.date = date;
        this.status = status;
        this.caseNumber = caseNumber;
    }
}
