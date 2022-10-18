package com.k204110855.handson11102022;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.k204110855.adapters.BeerAdapter;
import com.k204110855.handson11102022.databinding.ActivityBeerBinding;
import com.k204110855.models.Beer;

import java.util.ArrayList;
import java.util.List;

public class BeerActivity extends AppCompatActivity {

    ActivityBeerBinding binding;
    BeerAdapter adapter;
    ArrayList<Beer> beerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_beer);

        binding = ActivityBeerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() {
        //Init data
        beerList = new ArrayList<>();
        beerList.add(new Beer(R.drawable.heineken, "Heineken", 19000));
        beerList.add(new Beer(R.drawable.tiger, "Tiger", 18000));
        beerList.add(new Beer(R.drawable.sapporo, "Sapporo", 21000));
        beerList.add(new Beer(R.drawable.saigon, "Saigon", 18000));
        beerList.add(new Beer(R.drawable.hanoi, "Hanoi", 18000));
        beerList.add(new Beer(R.drawable.larue, "Larue", 18000));
        beerList.add(new Beer(R.drawable.beer333, "Beer 333", 17000));

        //Init adapter
        adapter = new BeerAdapter(BeerActivity.this, R.layout.item_list, beerList);

        binding.lvBeers.setAdapter(adapter);
    }
}