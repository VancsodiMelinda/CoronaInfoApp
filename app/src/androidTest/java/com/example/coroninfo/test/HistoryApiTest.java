package com.example.coroninfo.test;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import com.example.coroninfo.src.model.HistoryResponse;
import com.example.coroninfo.src.network.HistoryApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class HistoryApiTest {
    private HistoryApi historyApiService;

    @Before
    public void createApiService()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-api.mmediagroup.fr/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        historyApiService = retrofit.create(HistoryApi.class);
    }

    @Test
    public void getHistoryDataTest1()
    {
        Call<HistoryResponse> call = historyApiService.getHistoryData("Hungary", "deaths");

        String callMethod = call.request().method();
        boolean result = callMethod.equals("GET");

        assertTrue(result);
    }

    @Test
    public void getHistoryDataTest2()
    {
        String country = "Hungary";
        String status = "deaths";
        Call<HistoryResponse> call = historyApiService.getHistoryData(country, status);

        List<String> paramValues = call.request().url().queryParameterValues("country");
        String fistParam = paramValues.get(0);
        boolean result = fistParam.equals(country);

        assertTrue(result);
    }

    @Test
    public void getHistoryDataTest3()
    {
        String country = "Hungary";
        String status = "confirmed";
        Call<HistoryResponse> call = historyApiService.getHistoryData(country, status);

        List<String> paramValues = call.request().url().queryParameterValues("status");
        String fistParam = paramValues.get(0);
        boolean result = fistParam.equals(status);

        assertTrue(result);
    }
}
