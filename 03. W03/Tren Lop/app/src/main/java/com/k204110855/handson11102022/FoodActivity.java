package com.k204110855.handson11102022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.k204110855.handson11102022.databinding.ActivityFoodBinding;

public class FoodActivity extends AppCompatActivity {

    ActivityFoodBinding binding;
    String[] foods;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_food);

        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        loadData();

    }

    private void loadData() {
        adapter = new ArrayAdapter<String>(FoodActivity.this, android.R.layout.simple_list_item_1);
        foods = getResources().getStringArray(R.array.food_list);
        adapter.addAll(foods);

        binding.lvFoods.setAdapter(adapter);
    }
}