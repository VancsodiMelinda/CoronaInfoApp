package com.example.coroninfo.src.model;

import com.google.gson.annotations.SerializedName;

public class TotalResponse {
    @SerializedName("All")
    private Total allData = null;

    // getters and setters
    public Total getTotalData() { return allData; }
    public void setTotalData(Total allData) { this.allData = allData; }
}
