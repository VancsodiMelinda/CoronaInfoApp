package com.example.coroninfo.src.hungary;

import android.util.Log;

import com.example.coroninfo.src.model.History;
import com.example.coroninfo.src.model.HistoryResponse;
import com.example.coroninfo.src.model.TotalResponse;
import com.example.coroninfo.src.network.HistoryApi;
import com.example.coroninfo.src.network.RetrofitResponseListener;
import com.example.coroninfo.src.network.TotalApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HungaryInteractor {

    private static final String TAG = "HungaryInteractor";
    private TotalApi totalApiService;
    private HistoryApi historyApiService;
    private String[] totalData = new String[3];
    private DataContainer[] historyData = new DataContainer[7];

    public String[] getTotalData()
    {
        return totalData;
    }

    public DataContainer[] getHistoryData()
    {
        return historyData;
    }

    public HungaryInteractor()
    {
        // retrofit & retrofit service
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-api.mmediagroup.fr/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        totalApiService = retrofit.create(TotalApi.class);
        historyApiService = retrofit.create(HistoryApi.class);

        // init array
        for (int i = 0; i < historyData.length; i++)
        {
            DataContainer cont = new DataContainer();
            historyData[i] = cont;
        }
    }

    public void getHungaryTotalDataFromApi(final RetrofitResponseListener retrofitResponseListener)
    {
        Call<TotalResponse> call = totalApiService.getTotalData("Hungary");
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
                String country = responseData.getAllData().getCountry();

                // fill up data
                totalData[0] = confirmed.toString();
                totalData[1] = deaths.toString();
                totalData[2] = recovered.toString();

                // write data to db

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

    public void getHungaryHistoryDataFromApi(final RetrofitResponseListener retrofitResponseListener)
    {
        Call<HistoryResponse> call = historyApiService.getHistoryData("Hungary", "deaths");
        call.enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                if (!response.isSuccessful())
                {
                    Log.d(TAG, "code: " + response.code());
                    retrofitResponseListener.onFailure();
                    return;
                }

                // extract data from response
                Log.d(TAG, "onResponse GOOD");
                HistoryResponse responseData = response.body();
                String country = responseData.getAllData().getCountry();
                Object dates = responseData.getAllData().getDates();
                processConfirmedDates(dates);

                // test
                Log.d(TAG, "check url: " + call.request().url());
                Log.d(TAG, "country: " + country);
                //Log.d(TAG, "dates: " + dates.toString());

                // TODO: write data to db

                // fire event
                retrofitResponseListener.onSuccess();
            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {
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

    public void getHungaryHistoryDataFromApi2(final RetrofitResponseListener retrofitResponseListener)
    {
        Call<HistoryResponse> call = historyApiService.getHistoryData("Hungary", "confirmed");
        call.enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                if (!response.isSuccessful())
                {
                    Log.d(TAG, "code: " + response.code());
                    retrofitResponseListener.onFailure();
                    return;
                }

                // extract data from response
                Log.d(TAG, "onResponse GOOD");
                HistoryResponse responseData = response.body();
                String country = responseData.getAllData().getCountry();
                Object dates = responseData.getAllData().getDates();
                processConfirmedDates2(dates);

                // test
                Log.d(TAG, "check url: " + call.request().url());
                Log.d(TAG, "country: " + country);
                //Log.d(TAG, "dates: " + dates.toString());

                // TODO: write data to db

                // fire event
                retrofitResponseListener.onSuccess();
            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {
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

    private void processConfirmedDates(Object obj)
    {
        String objStr = obj.toString();
        ArrayList<String> dateAndNumberList = new ArrayList<>(Arrays.asList(objStr.split(",")));

        for (int i = 0; i < 7; i++)
        {
            String currentElement = dateAndNumberList.get(i);
            String prevElement = dateAndNumberList.get(i + 1);
            ArrayList<String> currentDateAndNumber = new ArrayList<>(Arrays.asList(currentElement.split("=")));
            ArrayList<String> prevDateAndNumber = new ArrayList<>(Arrays.asList(prevElement.split("=")));

            String currentDate = currentDateAndNumber.get(0);
            currentDate = currentDate.replaceAll("\\{", " ");

            int diff = (int)(Float.parseFloat(currentDateAndNumber.get(1)) - Float.parseFloat(prevDateAndNumber.get(1)));

            //DataContainer cont = new DataContainer(Integer.toString(diff), "0", currentDate);
            DataContainer cont = historyData[i];
            cont.currentDate = currentDate;
            cont.dailyDeath = Integer.toString(diff);
            historyData[i] = cont;
        }
    }

    private void processConfirmedDates2(Object obj)
    {
        String objStr = obj.toString();
        ArrayList<String> dateAndNumberList = new ArrayList<>(Arrays.asList(objStr.split(",")));

        for (int i = 0; i < 7; i++)
        {
            String currentElement = dateAndNumberList.get(i);
            String prevElement = dateAndNumberList.get(i + 1);
            ArrayList<String> currentDateAndNumber = new ArrayList<>(Arrays.asList(currentElement.split("=")));
            ArrayList<String> prevDateAndNumber = new ArrayList<>(Arrays.asList(prevElement.split("=")));

            String currentDate = currentDateAndNumber.get(0);
            currentDate = currentDate.replaceAll("\\{", " ");

            int diff = (int)(Float.parseFloat(currentDateAndNumber.get(1)) - Float.parseFloat(prevDateAndNumber.get(1)));

            DataContainer cont = historyData[i];
            cont.dailyConfirmed = Integer.toString(diff);
            historyData[i] = cont;
        }
    }

}
