package com.haerul.foodsapi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haerul.foodsapi.R;
import com.haerul.foodsapi.models.Meals;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {
    
    private Context context;
    private List<Meals> meals;

    public FoodAdapter(Context context, List<Meals> meals) {
        this.context = context;
        this.meals = meals;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_meal, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.txtMeal.setText(meals.get(i).strMeal);
        Picasso.get().load(meals.get(i).strMealThumb).into(myViewHolder.imgThumb);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgThumb;
        TextView txtMeal;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgThumb = itemView.findViewById(R.id.thumb);
            txtMeal = itemView.findViewById(R.id.meal);
        }
    }
}
