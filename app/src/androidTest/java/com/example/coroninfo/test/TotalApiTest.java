package com.example.coroninfo.test;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import com.example.coroninfo.src.model.TotalResponse;
import com.example.coroninfo.src.network.TotalApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class TotalApiTest {
    private TotalApi totalApiService;

    @Before
    public void createApiService()
    {
        // retrofit & retrofit service
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-api.mmediagroup.fr/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        totalApiService = retrofit.create(TotalApi.class);
    }

    @Test
    public void getTotalDataTest1()
    {
        Call<TotalResponse> call = totalApiService.getTotalData("Global");

        String callMethod = call.request().method();
        boolean result = callMethod.equals("GET");

        assertTrue(result);
    }

    @Test
    public void getTotalDataTest2()
    {
        String country = "Global";
        Call<TotalResponse> call = totalApiService.getTotalData(country);

        List<String> paramValues = call.request().url().queryParameterValues("country");
        String firstParam = paramValues.get(0);
        boolean result = firstParam.equals(country);

        assertTrue(result);
    }

}
