package com.example.coroninfo.src.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

public class History   {
  
  @SerializedName("country")
  private String country = null;

  /*
  @SerializedName("population")
  private Integer population = null;
  
  @SerializedName("sq_km_area")
  private Integer sqKmArea = null;
  
  @SerializedName("life_expectancy")
  private Float lifeExpectancy = null;
  
  @SerializedName("elevation_in_meters")
  private Integer elevationInMeters = null;
  
  @SerializedName("continent")
  private String continent = null;
  
  @SerializedName("abbreviation")
  private String abbreviation = null;
  
  @SerializedName("location")
  private String location = null;
  
  @SerializedName("iso")
  private Integer iso = null;
  
  @SerializedName("capital_city")
  private String capitalCity = null;
  */

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

  /*
  public Integer getPopulation() {
    return population;
  }
  public void setPopulation(Integer population) {
    this.population = population;
  }

  public Integer getSqKmArea() {
    return sqKmArea;
  }
  public void setSqKmArea(Integer sqKmArea) {
    this.sqKmArea = sqKmArea;
  }

  public Float getLifeExpectancy() {
    return lifeExpectancy;
  }
  public void setLifeExpectancy(Float lifeExpectancy) {
    this.lifeExpectancy = lifeExpectancy;
  }

  public Integer getElevationInMeters() {
    return elevationInMeters;
  }
  public void setElevationInMeters(Integer elevationInMeters) {
    this.elevationInMeters = elevationInMeters;
  }

  public String getContinent() {
    return continent;
  }
  public void setContinent(String continent) {
    this.continent = continent;
  }

  public String getAbbreviation() {
    return abbreviation;
  }
  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }

  public Integer getIso() {
    return iso;
  }
  public void setIso(Integer iso) {
    this.iso = iso;
  }

  public String getCapitalCity() {
    return capitalCity;
  }
  public void setCapitalCity(String capitalCity) {
    this.capitalCity = capitalCity;
  }
*/
  /*
  public String getDates() {
    return dates;
  }
  public void setDates(String dates) {
    this.dates = dates;
  }
*/

/*
  @RequiresApi(api = Build.VERSION_CODES.KITKAT)
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    History history = (History) o;
    return Objects.equals(country, history.country) &&
        Objects.equals(population, history.population) &&
        Objects.equals(sqKmArea, history.sqKmArea) &&
        Objects.equals(lifeExpectancy, history.lifeExpectancy) &&
        Objects.equals(elevationInMeters, history.elevationInMeters) &&
        Objects.equals(continent, history.continent) &&
        Objects.equals(abbreviation, history.abbreviation) &&
        Objects.equals(location, history.location) &&
        Objects.equals(iso, history.iso) &&
        Objects.equals(capitalCity, history.capitalCity) &&
        Objects.equals(dates, history.dates);
  }

  @RequiresApi(api = Build.VERSION_CODES.KITKAT)
  @Override
  public int hashCode() {
    return Objects.hash(country, population, sqKmArea, lifeExpectancy, elevationInMeters, continent, abbreviation, location, iso, capitalCity, dates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class History {\n");
    
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    population: ").append(toIndentedString(population)).append("\n");
    sb.append("    sqKmArea: ").append(toIndentedString(sqKmArea)).append("\n");
    sb.append("    lifeExpectancy: ").append(toIndentedString(lifeExpectancy)).append("\n");
    sb.append("    elevationInMeters: ").append(toIndentedString(elevationInMeters)).append("\n");
    sb.append("    continent: ").append(toIndentedString(continent)).append("\n");
    sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    iso: ").append(toIndentedString(iso)).append("\n");
    sb.append("    capitalCity: ").append(toIndentedString(capitalCity)).append("\n");
    sb.append("    dates: ").append(toIndentedString(dates)).append("\n");
    sb.append("}");
    return sb.toString();
  }
*/
  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  /*
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
   */
}
