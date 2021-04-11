package com.example.coroninfo.src.about;

import com.example.coroninfo.src.global.GlobalScreen;

public class AboutPresenter {
    AboutScreen aboutScreen;

    public void attachScreen(AboutScreen aboutScreen) {
        this.aboutScreen = aboutScreen;
    }

    public void detachScreen() {
        this.aboutScreen = null;
    }
}
