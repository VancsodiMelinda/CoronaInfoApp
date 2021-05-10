package com.example.coroninfo.mock;

import com.example.coroninfo.src.model.TotalResponse;
import com.example.coroninfo.src.network.TotalApi;

import retrofit2.Call;

public class MockTotalApi implements TotalApi {
    @Override
    public Call<TotalResponse> getTotalData(String country) {
        return null;
    }

    @Override
    public Call<TotalResponse> updateTotalData(String country) {
        return null;
    }

    @Override
    public Call<TotalResponse> deleteTotalDataByCountry(String country) {
        return null;
    }

    @Override
    public Call<TotalResponse> addTotalDataByCountry(String country) {
        return null;
    }
}
