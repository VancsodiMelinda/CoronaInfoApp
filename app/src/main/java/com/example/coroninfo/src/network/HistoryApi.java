package com.example.coroninfo.src.network;

import com.example.coroninfo.src.model.History;
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
   * @return Call<History>
   */
  
  @GET("history")
  Call<History> getHistoryData(
    @Query("country") String country, @Query("status") String status
  );

  
}
