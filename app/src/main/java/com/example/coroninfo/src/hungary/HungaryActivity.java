package com.example.coroninfo.src.hungary;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.coroninfo.R;

public class HungaryActivity extends AppCompatActivity implements HungaryScreen {

    private HungaryPresenter hungaryPresenter = new HungaryPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hungary);
    }

    @Override
    protected void onStart() {
        super.onStart();
        hungaryPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        hungaryPresenter.detachScreen();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        hungaryPresenter.getHungaryTotal();
        hungaryPresenter.getHungaryDaily();
    }

    @Override
    public void showHungaryTotal(int[] totalData) {
        // TODO: show total data in hungary screen
    }

    @Override
    public void showHungaryDaily(int[] dailyData) {
        // TODO: show daily data in hungary screen
    }
}