package com.example.coroninfo.global;

public class GlobalPresenter {

    GlobalScreen globalScreen;  // referencia az interface-re

    public void attachScreen(GlobalScreen globalScreen) {
        this.globalScreen = globalScreen;
    }

    public void detachScreen() {
        this.globalScreen = null;
    }

    public void getGlobalTotal()
    {
        // TODO: get data from API
        int[] temp = {123, 456, 789};
        if (globalScreen != null)
        {
            globalScreen.showGlobalTotal(temp);
        }
    }
}
