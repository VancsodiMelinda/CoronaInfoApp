package com.example.coroninfo.src.global;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.coroninfo.R;


public class GlobalActivity extends AppCompatActivity implements GlobalScreen {

    private GlobalPresenter globalPresenter = new GlobalPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);
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
    public void showGlobalTotal(int[] totalData) {
        // TODO: show data in global screen
    }
}
