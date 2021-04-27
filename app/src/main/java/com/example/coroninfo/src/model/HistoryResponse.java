package com.example.coroninfo.src.model;

import com.google.gson.annotations.SerializedName;

public class HistoryResponse {
    @SerializedName("All")
    private History allData = null;

    // getters and setters
    public History getAllData() { return allData; }
    public void setAllData(History allData) { this.allData = allData; }
}
