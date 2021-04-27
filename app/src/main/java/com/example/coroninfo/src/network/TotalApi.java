package com.example.coroninfo.src.network;

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
   * @return Call<Total>
   */
  
  @GET("cases")
  Call<TotalResponse> getTotalData(
    @Query("country") String country
  );

  
}
