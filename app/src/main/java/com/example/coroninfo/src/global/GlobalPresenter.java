package com.example.coroninfo.src.global;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.coroninfo.src.data.AppDatabase;
import com.example.coroninfo.src.data.TotalEntity;
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

    public void getGlobalTotal(Context context)
    {
        Log.d(TAG, "getGlobalTotal get data from API");
        GlobalInteractor interactor = new GlobalInteractor(context);
        interactor.getGlobalTotalDataFromAPI(new RetrofitResponseListener() {
            @Override
            public void onSuccess() {
                if (globalScreen != null) {
                    globalScreen.showGlobalTotal(interactor.getData());
                } else {
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
