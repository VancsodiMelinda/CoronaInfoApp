package com.example.coroninfo.src.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TotalEntity {
    @PrimaryKey
    public int id;

    public String country;
    public int totalConfirmed;
    public int totalRecovered;
    public int totalDeath;
}
