package com.example.coroninfo.src.global;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.coroninfo.R;
import com.example.coroninfo.src.model.HistoryResponse;
import com.example.coroninfo.src.model.Total;
import com.example.coroninfo.src.model.TotalResponse;
import com.example.coroninfo.src.network.HistoryApi;
import com.example.coroninfo.src.network.TotalApi;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

        // test TotalApi

        Call<TotalResponse> call = totalApiService.getTotalData("Hungary");
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

                Log.d("GlobalActivity", "confirmed: " + test.getAllData().getConfirmed());
                Log.d("GlobalActivity", "recovered: " + test.getAllData().getRecovered());
                Log.d("GlobalActivity", "death: " + test.getAllData().getDeaths());
                Log.d("GlobalActivity", "country: " + test.getAllData().getCountry());

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


        // test HistoryApi
        /*
        Call<HistoryResponse> call2 = historyApiService.getHistoryData("Hungary", "confirmed");
        call2.enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                if (!response.isSuccessful())
                {
                    Log.d("GlobalActivity, history", "code: " + response.code());
                    return;
                }

                HistoryResponse test = response.body();
                Log.d("GlobalActivity, history", "onResponse GOOD");

                Log.d("GlobalActivity, history", "country: " + test.getAllData().getCountry());
                //Log.d("GlobalActivity, history", "dates: " + test.getAllData().getDates().toString());
            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {
                if (t instanceof IOException)
                {
                    Log.d("GlobalActivity, history", "network failure");
                }
                else
                {
                    Log.d("GlobalActivity", "conversion issue");
                }
            }
        });

         */

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
