package com.example.coroninfo.src.model;

import com.google.gson.annotations.SerializedName;

public class TotalResponse {
    @SerializedName("All")
    private Total allData = null;

    // getters and setters
    public Total getAllData() { return allData; }
    public void setAllData(Total allData) { this.allData = allData; }
}
