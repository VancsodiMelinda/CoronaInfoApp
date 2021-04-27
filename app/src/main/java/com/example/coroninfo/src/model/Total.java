package com.example.coroninfo.src.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;
import java.util.Date;
import com.google.gson.annotations.SerializedName;

public class Total   {
  @SerializedName("confirmed")
  private Integer confirmed = null;
  
  @SerializedName("recovered")
  private Integer recovered = null;
  
  @SerializedName("deaths")
  private Integer deaths = null;
  
  @SerializedName("country")
  private String country = "Global";

  // getters and setters
  public Integer getConfirmed() {
    return confirmed;
  }
  public void setConfirmed(Integer confirmed) {
    this.confirmed = confirmed;
  }

  public Integer getRecovered() {
    return recovered;
  }
  public void setRecovered(Integer recovered) {
    this.recovered = recovered;
  }

  public Integer getDeaths() {
    return deaths;
  }
  public void setDeaths(Integer deaths) {
    this.deaths = deaths;
  }

  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
}
