package com.example.coroninfo.src.hungary;

import com.example.coroninfo.src.global.GlobalScreen;

public class HungaryPresenter {

    HungaryScreen hungaryScreen;

    public void attachScreen(HungaryScreen hungaryScreen) {
        this.hungaryScreen = hungaryScreen;
    }

    public void detachScreen() {
        this.hungaryScreen = null;
    }

    public void getHungaryTotal()
    {
        // TODO: get data from API
        int[] temp = {123, 456, 789};
        if (hungaryScreen != null)
        {
            hungaryScreen.showHungaryTotal(temp);
        }
    }

    public void getHungaryDaily()
    {
        // TODO: get data from API
        int[] temp = {321, 654, 987};
        if (hungaryScreen != null)
        {
            hungaryScreen.showHungaryDaily(temp);
        }
    }
}
