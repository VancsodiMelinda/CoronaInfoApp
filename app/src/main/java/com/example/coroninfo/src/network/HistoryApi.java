package com.example.coroninfo.src.network;

import com.example.coroninfo.src.model.History;
import com.example.coroninfo.src.model.HistoryResponse;

import retrofit2.Call;
import retrofit2.http.*;
import okhttp3.RequestBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HistoryApi {
  
  /**
   * Get history by country and status
   * 
   * @param country country name
   * @param status status type
   * @return Call<HistoryResponse>
   */
  
  @GET("history")
  Call<HistoryResponse> getHistoryData(
          @Query("country") String country, @Query("status") String status
  );

  // update history data by country and status
  @PUT("history")
  Call<HistoryResponse> updateHistoryData(
          @Query("country") String country, @Query("status") String status
  );

  // delete history data by country and status
  @DELETE("history")
  Call<HistoryResponse> deleteHistoryData(
          @Query("country") String country, @Query("status") String status
  );

  // add history data by country and status
  @POST("history")
  Call<HistoryResponse> addHistoryData(
          @Query("country") String country, @Query("status") String status
  );
}
