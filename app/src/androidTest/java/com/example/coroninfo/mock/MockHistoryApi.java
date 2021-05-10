package com.example.coroninfo.mock;

import com.example.coroninfo.src.model.HistoryResponse;
import com.example.coroninfo.src.model.TotalResponse;
import com.example.coroninfo.src.network.HistoryApi;
import com.example.coroninfo.src.network.TotalApi;

import retrofit2.Call;

public class MockHistoryApi implements HistoryApi {

    @Override
    public Call<HistoryResponse> getHistoryData(String country, String status) {
        return null;
    }

    @Override
    public Call<HistoryResponse> updateHistoryData(String country, String status) {
        return null;
    }

    @Override
    public Call<HistoryResponse> deleteHistoryData(String country, String status) {
        return null;
    }

    @Override
    public Call<HistoryResponse> addHistoryData(String country, String status) {
        return null;
    }
}
