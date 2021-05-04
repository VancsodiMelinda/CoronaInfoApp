package com.example.coroninfo.src.global;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.coroninfo.R;
import com.example.coroninfo.src.hungary.HungaryActivity;
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
    private static final String TAG = "GlobalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);

        configRightButton();  // go to Hungary activity

        // retrofit & retrofit service
        /*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-api.mmediagroup.fr/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TotalApi totalApiService = retrofit.create(TotalApi.class);
        HistoryApi historyApiService = retrofit.create(HistoryApi.class);
        */
        // test TotalApi
        /*
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
        */

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
        Log.d(TAG, "onResume");
        //globalPresenter.getGlobalTotal();
    }

    @Override
    public void showGlobalTotal(String[] totalData) {
        Log.d(TAG, "showGlobalTotal update data");
        Log.d(TAG, "data[0]: " + totalData[0]);
        Log.d(TAG, "data[1]: " + totalData[1]);
        Log.d(TAG, "data[2]: " + totalData[2]);

        TextView confirmedTv = (TextView) findViewById(R.id.GlobalTotalConfirmedTv);
        confirmedTv.setText(totalData[0]);
        confirmedTv.invalidate();

        TextView deathsTv = (TextView) findViewById(R.id.GlobalTotalDeathsTv);
        deathsTv.setText(totalData[1]);
        deathsTv.invalidate();

        TextView recoveredTv = (TextView) findViewById(R.id.GlobalTotalRecoveredTv);
        recoveredTv.setText(totalData[2]);
        recoveredTv.invalidate();
    }

    private void configRightButton()
    {
        ImageButton toHungaryBtn = (ImageButton) findViewById(R.id.GlobalRightBtn);
        toHungaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GlobalActivity.this, HungaryActivity.class);
                startActivity(intent);
            }
        });
    }
}
