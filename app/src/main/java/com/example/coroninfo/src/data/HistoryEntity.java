package com.example.coroninfo.src.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HistoryEntity {
    @PrimaryKey
    public int id;

    public String date;
    public String status;
    public int caseNumber;
}
