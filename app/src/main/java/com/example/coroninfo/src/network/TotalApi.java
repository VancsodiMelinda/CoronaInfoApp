package com.example.coroninfo.src.network;

import androidx.room.Delete;

import com.example.coroninfo.src.model.Total;
import com.example.coroninfo.src.model.TotalResponse;

import retrofit2.Call;
import retrofit2.http.*;
import okhttp3.RequestBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TotalApi {
  
  /**
   * Get total data by country
   * 
   * @param country country name
   * @return Call<TotalResponse>
   */
  
  @GET("cases")
  Call<TotalResponse> getTotalData(
          @Query("country") String country
  );

  // update total data by country
  @PUT("cases")
  Call<TotalResponse> updateTotalData(
          @Query("country") String country
  );

  // delete total data by country
  @DELETE("cases")
  Call<TotalResponse> deleteTotalDataByCountry(
          @Query("country") String country
  );

  // add total data by country
  @POST("cases")
  Call<TotalResponse> addTotalDataByCountry(
          @Query("country") String country
  );
}
