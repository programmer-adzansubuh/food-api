package com.haerul.foodsapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import com.haerul.foodsapi.adapter.FoodAdapter;
import com.haerul.foodsapi.models.Food;
import com.haerul.foodsapi.models.Meals;
import com.haerul.foodsapi.services.FoodInterface;
import com.haerul.foodsapi.services.FoodService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity extends AppCompatActivity {
    
    RecyclerView recyclerView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);

        FoodService foodService = new FoodService();
        FoodInterface foodInterface = foodService
                .getAPI().create(FoodInterface.class);
        
        foodInterface.getFood().enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                
                List<Meals> meals = response.body().meals;
                
                FoodAdapter foodAdapter = new FoodAdapter(Activity.this, meals);
                
                recyclerView.setLayoutManager(new LinearLayoutManager(Activity.this));
                
                recyclerView.setAdapter(foodAdapter);
            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {

            }
        });
        
    }
}
