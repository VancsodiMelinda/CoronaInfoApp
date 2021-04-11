package com.example.coroninfo.src.about;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.coroninfo.R;

public class AboutActivity extends AppCompatActivity implements AboutScreen {

    private AboutPresenter aboutPresenter = new AboutPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    protected void onStart() {
        super.onStart();
        aboutPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        aboutPresenter.detachScreen();
    }
}