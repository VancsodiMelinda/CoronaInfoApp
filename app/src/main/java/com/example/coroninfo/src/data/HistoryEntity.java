package com.example.coroninfo.src.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class HistoryEntity {
    @PrimaryKey
    public String date;

    public String status;
    public int caseNumber;
}
