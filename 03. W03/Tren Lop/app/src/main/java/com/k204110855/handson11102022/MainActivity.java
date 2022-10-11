package com.k204110855.handson11102022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.k204110855.handson11102022.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String[] drinks = {
            "Coca", "Pepsi", "Sting", "Red-Bull", "Coffee", "Tea", "Sapporo", "Heineken", "Tiger", "Milk", "C2", "Beer 333", "HaNoi", "SaiGon", "Larue"
    };

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Load data
        loadData();

    }

    private void loadData() {
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, drinks);

        binding.lvDrink.setAdapter(adapter);
    }
}