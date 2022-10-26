package com.k204111813.test2510;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.k204111813.test2510.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvent();
    }

    private void addEvent() {
        binding.imvBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Opening MealActivity
                Intent intent = new Intent(MainActivity.this, MealActivity.class);
                intent.putExtra("meal","breakfast");
                startActivity(intent);
            }
        });
        binding.imvLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Opening MealActivity
                Intent intent = new Intent(MainActivity.this, MealActivity.class);
                intent.putExtra("meal","lunch");
                startActivity(intent);
            }
        });
    }

}