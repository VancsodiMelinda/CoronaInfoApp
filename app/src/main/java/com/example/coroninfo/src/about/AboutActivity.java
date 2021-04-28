package com.example.coroninfo.src.about;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.coroninfo.R;
import com.example.coroninfo.src.hungary.HungaryActivity;

public class AboutActivity extends AppCompatActivity implements AboutScreen {

    private AboutPresenter aboutPresenter = new AboutPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        configLeftButton();  // go to Hungary activity
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

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    private void configLeftButton()
    {
        ImageButton toHungaryBtn = (ImageButton) findViewById(R.id.AboutLeftBtn);
        toHungaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this, HungaryActivity.class);
                startActivity(intent);
            }
        });
    }
}