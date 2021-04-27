package com.example.coroninfo.src.global;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.coroninfo.R;
import com.example.coroninfo.src.model.Total;
import com.example.coroninfo.src.model.TotalResponse;
import com.example.coroninfo.src.network.HistoryApi;
import com.example.coroninfo.src.network.TotalApi;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GlobalActivity extends AppCompatActivity implements GlobalScreen {

    private GlobalPresenter globalPresenter = new GlobalPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);

        // retrofit & retrofit service
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-api.mmediagroup.fr/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TotalApi totalApiService = retrofit.create(TotalApi.class);
        HistoryApi historyApiService = retrofit.create(HistoryApi.class);

        // test
        Call<TotalResponse> call = totalApiService.getTotalData("Global");
        call.enqueue(new Callback<TotalResponse>() {
            @Override
            public void onResponse(Call<TotalResponse> call, Response<TotalResponse> response) {
                if (!response.isSuccessful())
                {
                    Log.d("GlobalActivity", "code: " + response.code());
                    return;
                }

                TotalResponse test = response.body();
                Log.d("GlobalActivity", "onResponse GOOD");

                Log.d("GlobalActivity", "confirmed: " + test.getTotalData().getConfirmed());
                Log.d("GlobalActivity", "recovered: " + test.getTotalData().getRecovered());
                Log.d("GlobalActivity", "death: " + test.getTotalData().getDeaths());
                Log.d("GlobalActivity", "country: " + test.getTotalData().getCountry());

            }

            @Override
            public void onFailure(Call<TotalResponse> call, Throwable t) {
                if (t instanceof IOException)
                {
                    Log.d("GlobalActivity", "network failure");
                }
                else
                {
                    Log.d("GlobalActivity", "conversion issue");
                }
                //Log.d("GlobalActivity", "onFailure: " + t.getMessage());
                //Log.d("GlobalActivity", "check url: " + call.request().url());
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        globalPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        globalPresenter.detachScreen();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        globalPresenter.getGlobalTotal();
    }

    @Override
    public void showGlobalTotal(int[] totalData) {
        // TODO: show data in global screen
    }
}
