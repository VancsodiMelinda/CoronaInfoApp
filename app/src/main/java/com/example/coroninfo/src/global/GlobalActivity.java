package com.example.coroninfo.src.global;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
        globalPresenter.getGlobalTotal(this.getApplicationContext());
    }

    @Override
    public void showGlobalTotal(String[] totalData) {
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
