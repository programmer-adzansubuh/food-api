package com.haerul.foodsapi.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodService {
    
    private static final String BASE_URL = 
            "https://www.themealdb.com/api/json/v1/1/";
    
    public Retrofit getAPI() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory (
                        GsonConverterFactory.create()
                )
                .build();
    }
}
