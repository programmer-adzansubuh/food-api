package com.haerul.foodsapi.services;

import com.haerul.foodsapi.models.Food;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodInterface {
    
    @GET("latest.php")
    Call<Food> getFood(); 
    
}
