package com.example.coroninfo.src.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;
import java.util.Date;
import com.google.gson.annotations.SerializedName;

public class Total   {
  
  //@SerializedName("population")
  //private Integer population = null;
  
  @SerializedName("confirmed")
  private Integer confirmed = null;
  
  @SerializedName("recovered")
  private Integer recovered = null;
  
  @SerializedName("deaths")
  private Integer deaths = null;
  
  @SerializedName("country")
  private String country = null;

  /*
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
  
  @SerializedName("lat")
  private Double lat = null;
  
  @SerializedName("long")
  private Double _long = null;
  
  @SerializedName("updated")
  private Date updated = null;
*/

  // getters and setters
  /*
  public Integer getPopulation() {
    return population;
  }
  public void setPopulation(Integer population) {
    this.population = population;
  }
*/
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
/*
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

  public Double getLat() {
    return lat;
  }
  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Double getLong() {
    return _long;
  }
  public void setLong(Double _long) {
    this._long = _long;
  }

  public Date getUpdated() {
    return updated;
  }
  public void setUpdated(Date updated) {
    this.updated = updated;
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
    Total total = (Total) o;
    return Objects.equals(population, total.population) &&
        Objects.equals(confirmed, total.confirmed) &&
        Objects.equals(recovered, total.recovered) &&
        Objects.equals(deaths, total.deaths) &&
        Objects.equals(country, total.country) &&
        Objects.equals(sqKmArea, total.sqKmArea) &&
        Objects.equals(lifeExpectancy, total.lifeExpectancy) &&
        Objects.equals(elevationInMeters, total.elevationInMeters) &&
        Objects.equals(continent, total.continent) &&
        Objects.equals(abbreviation, total.abbreviation) &&
        Objects.equals(location, total.location) &&
        Objects.equals(iso, total.iso) &&
        Objects.equals(capitalCity, total.capitalCity) &&
        Objects.equals(lat, total.lat) &&
        Objects.equals(_long, total._long) &&
        Objects.equals(updated, total.updated);
  }

  @RequiresApi(api = Build.VERSION_CODES.KITKAT)
  @Override
  public int hashCode() {
    return Objects.hash(population, confirmed, recovered, deaths, country, sqKmArea, lifeExpectancy, elevationInMeters, continent, abbreviation, location, iso, capitalCity, lat, _long, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Total {\n");
    
    sb.append("    population: ").append(toIndentedString(population)).append("\n");
    sb.append("    confirmed: ").append(toIndentedString(confirmed)).append("\n");
    sb.append("    recovered: ").append(toIndentedString(recovered)).append("\n");
    sb.append("    deaths: ").append(toIndentedString(deaths)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    sqKmArea: ").append(toIndentedString(sqKmArea)).append("\n");
    sb.append("    lifeExpectancy: ").append(toIndentedString(lifeExpectancy)).append("\n");
    sb.append("    elevationInMeters: ").append(toIndentedString(elevationInMeters)).append("\n");
    sb.append("    continent: ").append(toIndentedString(continent)).append("\n");
    sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    iso: ").append(toIndentedString(iso)).append("\n");
    sb.append("    capitalCity: ").append(toIndentedString(capitalCity)).append("\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    _long: ").append(toIndentedString(_long)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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
