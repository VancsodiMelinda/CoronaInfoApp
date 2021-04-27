package com.example.coroninfo.src.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

public class History   {
  @SerializedName("country")
  private String country = null;

  @SerializedName("dates")
  private Object dates = null;

  // getters and setters
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }

  public Object getDates() {
    return dates;
  }
  public void setDates(Object dates) {
    this.dates = dates;
  }
}
