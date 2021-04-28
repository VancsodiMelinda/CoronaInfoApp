package com.example.coroninfo.src.hungary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.coroninfo.R;
import com.example.coroninfo.src.about.AboutActivity;
import com.example.coroninfo.src.global.GlobalActivity;

public class HungaryActivity extends AppCompatActivity implements HungaryScreen {

    private HungaryPresenter hungaryPresenter = new HungaryPresenter();

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

    private void configLeftButton()
    {
        ImageButton toGlobalBtn = (ImageButton) findViewById(R.id.HungaryLeftBtn);
        toGlobalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HungaryActivity.this, GlobalActivity.class);
                startActivity(intent);
                //startActivity(new Intent(HungaryActivity.this, GlobalActivity.class));
                //finish();
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