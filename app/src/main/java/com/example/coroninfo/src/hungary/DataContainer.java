package com.example.coroninfo.src.hungary;

public class DataContainer {
    public String dailyConfirmed;
    public String dailyDeath;
    public String currentDate;

    public DataContainer(String dailyConfirmed_, String dailyDeath_, String currentDate_)
    {
        dailyConfirmed = dailyConfirmed_;
        dailyDeath = dailyDeath_;
        currentDate = currentDate_;
    }

    public DataContainer() {
        dailyConfirmed = "0";
        dailyDeath = "0";
        currentDate = "0000-00-00";
    }
}
