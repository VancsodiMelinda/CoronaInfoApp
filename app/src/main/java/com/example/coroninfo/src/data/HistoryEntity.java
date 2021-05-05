package com.example.coroninfo.src.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class HistoryEntity {
    @PrimaryKey
    @NonNull public String date;

    public String status;
    public int caseNumber;
}
