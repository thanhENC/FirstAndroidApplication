package com.DinhVanAn.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.DinhVanAn.test.databinding.ActivityMainBinding;
import com.DinhVanAn.test.databinding.ActivityMenuBuaAnBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.imvAnSang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, MenuBuaAn.class);
                intent.putExtra("meal", "breakfast");
                startActivity(intent);
            }
        });
        binding.imvAnChieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, MenuBuaAn.class);
                intent.putExtra("meal", "lunch");
                startActivity(intent);
            }
        });
    }
}