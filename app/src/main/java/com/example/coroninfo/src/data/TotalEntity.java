package com.example.coroninfo.src.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "total")
public class TotalEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String country;  // Hungary or Global
    public int totalConfirmed;
    public int totalRecovered;
    public int totalDeath;

    public TotalEntity(){}

    public TotalEntity(int id, String country, int totalConfirmed, int totalRecovered, int totalDeath)
    {
        this.id = id;
        this.country = country;
        this.totalConfirmed = totalConfirmed;
        this.totalRecovered = totalRecovered;
        this.totalDeath = totalDeath;
    }
}
