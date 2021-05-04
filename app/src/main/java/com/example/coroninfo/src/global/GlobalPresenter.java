package com.example.coroninfo.src.global;

import android.util.Log;

import com.example.coroninfo.src.network.RetrofitResponseListener;

public class GlobalPresenter {

    GlobalScreen globalScreen;  // referencia az interface-re
    private static final String TAG = "GlobalPresenter";

    public void attachScreen(GlobalScreen globalScreen) {
        this.globalScreen = globalScreen;
    }

    public void detachScreen() {
        this.globalScreen = null;
    }

    public void getGlobalTotal()
    {
        GlobalInteractor interactor = new GlobalInteractor();
        interactor.getGlobalTotalDataFromAPI(new RetrofitResponseListener() {
            @Override
            public void onSuccess() {
                Log.d(TAG, "getGlobalTotal got data from API");
                if (globalScreen != null)
                {
                    Log.d(TAG, "getGlobalTotal screen is NOT null");
                    globalScreen.showGlobalTotal(interactor.getData());
                }
                else {
                    Log.d(TAG, "getGlobalTotal screen IS null");
                }
            }

            @Override
            public void onFailure() {
                Log.d(TAG, "getGlobalTotal didn't get data from API");
            }
        });
    }
}
