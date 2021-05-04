package com.example.coroninfo.src.global;

import android.util.Log;

import com.example.coroninfo.src.model.TotalResponse;
import com.example.coroninfo.src.network.RetrofitResponseListener;
import com.example.coroninfo.src.network.TotalApi;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GlobalInteractor {
    private static final String TAG = "GlobalInteractor";
    private TotalApi totalApiService;
    private String[] data = new String[3];

    public String[] getData()
    {
        return data;
    }

    public GlobalInteractor()
    {
        // retrofit & retrofit service
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-api.mmediagroup.fr/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        totalApiService = retrofit.create(TotalApi.class);
    }

    public void getGlobalTotalDataFromAPI(final RetrofitResponseListener retrofitResponseListener)
    {
        Call<TotalResponse> call = totalApiService.getTotalData("Global");
        call.enqueue(new Callback<TotalResponse>() {
            @Override
            public void onResponse(Call<TotalResponse> call, Response<TotalResponse> response) {
                if (!response.isSuccessful())
                {
                    Log.d(TAG, "code: " + response.code());
                    retrofitResponseListener.onFailure();
                    return;
                }

                // extract data from response
                Log.d(TAG, "onResponse GOOD");
                TotalResponse responseData = response.body();
                Integer confirmed = responseData.getAllData().getConfirmed();
                Integer deaths = responseData.getAllData().getDeaths();
                Integer recovered = responseData.getAllData().getRecovered();

                // fill up data
                data[0] = confirmed.toString();
                data[1] = deaths.toString();
                data[2] = recovered.toString();

                // test
                Log.d(TAG, "data[0]: " + data[0]);
                Log.d(TAG, "data[1]: " + data[1]);
                Log.d(TAG, "data[2]: " + data[2]);

                Log.d(TAG, "check url: " + call.request().url());
                Log.d(TAG, "confirmed: " + confirmed);
                Log.d(TAG, "recovered: " + recovered);
                Log.d(TAG, "death: " + deaths);
                Log.d(TAG, "country: " + responseData.getAllData().getCountry());

                // fire event
                retrofitResponseListener.onSuccess();
            }

            @Override
            public void onFailure(Call<TotalResponse> call, Throwable t) {
                retrofitResponseListener.onFailure();
                if (t instanceof IOException)
                {
                    Log.d(TAG, "network failure");
                }
                else
                {
                    Log.d(TAG, "conversion issue");
                }
            }
        });
    }
}
