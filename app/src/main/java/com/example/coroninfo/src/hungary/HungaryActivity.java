package com.example.coroninfo.src.hungary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.coroninfo.R;
import com.example.coroninfo.src.about.AboutActivity;
import com.example.coroninfo.src.global.GlobalActivity;

import java.util.List;

public class HungaryActivity extends AppCompatActivity implements HungaryScreen {

    private HungaryPresenter hungaryPresenter = new HungaryPresenter();
    private static final String TAG = "HungaryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hungary);

        configLeftButton();  // go to Global activity
        configRightButton();  // go to About activity
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
        //hungaryPresenter.getHungaryTotal();
        //hungaryPresenter.getHungaryDaily();
    }

    @Override
    public void showHungaryTotal(String[] totalData) {
        TextView confirmedTv = (TextView) findViewById(R.id.HungaryTotalConfirmedTv);
        confirmedTv.setText(totalData[0]);

        TextView deathsTv = (TextView) findViewById(R.id.HungaryTotalDeathsTv);
        deathsTv.setText(totalData[1]);

        TextView recoveredTv = (TextView) findViewById(R.id.HungaryTotalRecoveredTv);
        recoveredTv.setText(totalData[2]);
    }

    @Override
    public void showHungaryDaily(DataContainer[] dailyData) {
        Log.d(TAG, "showHungaryDaily");
        ListView dailyLv = (ListView) findViewById(R.id.HungaryListLv);

        HistoryListAdapter adapter = new HistoryListAdapter(this, R.layout.list_item, dailyData);
        dailyLv.setAdapter(adapter);
    }

    private void configLeftButton()
    {
        ImageButton toGlobalBtn = (ImageButton) findViewById(R.id.HungaryLeftBtn);
        toGlobalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HungaryActivity.this, GlobalActivity.class);
                startActivity(intent);
            }
        });
    }

    private void configRightButton()
    {
        ImageButton toAboutBtn = (ImageButton) findViewById(R.id.HungaryRightBtn);
        toAboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HungaryActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}