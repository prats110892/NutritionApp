package com.meeshuaghnihotri.nutritionapp;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Food Request Service
 * Created by batman on 22/11/15.
 */
public interface FoodRequestService {
    @GET("/v1_1/item")
    Call<FoodItem> getFoodItem(@Query("upc") String upc, @Query("appId") String appID,
                               @Query("appKey") String appKey );
}
