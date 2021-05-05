package com.example.coroninfo.src.global;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.coroninfo.src.data.AppDatabase;
import com.example.coroninfo.src.data.TotalEntity;
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
    private Context context;

    public String[] getData()
    {
        return data;
    }

    public GlobalInteractor(Context context)
    {
        this.context = context;

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
                TotalResponse responseData = response.body();
                Integer confirmed = responseData.getAllData().getConfirmed();
                Integer deaths = responseData.getAllData().getDeaths();
                Integer recovered = responseData.getAllData().getRecovered();

                // fill up data
                data[0] = confirmed.toString();
                data[1] = deaths.toString();
                data[2] = recovered.toString();

                // write data to db

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        TotalEntity totalEntity = new TotalEntity();
                        totalEntity.country = "Global";
                        totalEntity.totalConfirmed = confirmed;
                        totalEntity.totalRecovered = recovered;
                        totalEntity.totalDeath = deaths;
                        AppDatabase.getInstance(context).getTotalDao().insertTotalData(totalEntity);
                    }
                });

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
