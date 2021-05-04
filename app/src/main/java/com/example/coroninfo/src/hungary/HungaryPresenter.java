package com.example.coroninfo.src.hungary;

import android.util.Log;

import com.example.coroninfo.src.global.GlobalScreen;
import com.example.coroninfo.src.network.RetrofitResponseListener;

public class HungaryPresenter {

    HungaryScreen hungaryScreen;
    private static final String TAG = "HungaryPresenter";

    public void attachScreen(HungaryScreen hungaryScreen) {
        this.hungaryScreen = hungaryScreen;
    }

    public void detachScreen() {
        this.hungaryScreen = null;
    }

    public void getHungaryTotal()
    {
        HungaryInteractor interactor = new HungaryInteractor();
        interactor.getHungaryTotalDataFromApi(new RetrofitResponseListener() {
            @Override
            public void onSuccess() {
                Log.d(TAG, "getHungaryTotal got data from API");
                if (hungaryScreen != null)
                {
                    Log.d(TAG, "getHungaryTotal screen is NOT null");
                    hungaryScreen.showHungaryTotal(interactor.getTotalData());
                }
            }

            @Override
            public void onFailure() {
                Log.d(TAG, "getHungaryTotal didn't get data from API");
            }
        });
    }

    public void getHungaryDaily()
    {
        Log.d(TAG, "getHungaryDaily got called");
        HungaryInteractor interactor = new HungaryInteractor();
        interactor.getHungaryHistoryDataFromApi(new RetrofitResponseListener() {
            @Override
            public void onSuccess() {
                Log.d(TAG, "getHungaryDaily got data from API");
                if (hungaryScreen != null)
                {
                    Log.d(TAG, "getHungaryDaily screen is NOT null");
                    hungaryScreen.showHungaryDaily(interactor.getHistoryData());
                }
            }

            @Override
            public void onFailure() {
                Log.d(TAG, "getHungaryDaily didn't get data from API");
            }
        });

        interactor.getHungaryHistoryDataFromApi2(new RetrofitResponseListener() {
            @Override
            public void onSuccess() {
                Log.d(TAG, "getHungaryDaily got data from API");
                if (hungaryScreen != null)
                {
                    Log.d(TAG, "getHungaryDaily screen is NOT null");
                    hungaryScreen.showHungaryDaily(interactor.getHistoryData());
                }
            }

            @Override
            public void onFailure() {
                Log.d(TAG, "getHungaryDaily didn't get data from API");
            }
        });
    }
}
