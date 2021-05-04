package com.example.coroninfo.src.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "total")
public class TotalEntity {
    @PrimaryKey
    public String country;  // Hungary or Global

    public int totalConfirmed;
    public int totalRecovered;
    public int totalDeath;
}
