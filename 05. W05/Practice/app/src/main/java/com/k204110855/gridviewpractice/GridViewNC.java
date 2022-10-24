package com.k204110855.gridviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.k204110855.gridviewpractice.adapters.ProductAdapter;
import com.k204110855.gridviewpractice.databinding.ActivityGridViewNcBinding;
import com.k204110855.gridviewpractice.models.Product;

import java.util.ArrayList;

public class GridViewNC extends AppCompatActivity {

    ActivityGridViewNcBinding binding;
    ProductAdapter adapter;
    ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_grid_view_nc);

        binding = ActivityGridViewNcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() {
        //init data
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.beer333, "Beer 333"));
        productList.add(new Product(R.drawable.hanoi, "Hanoi"));
        productList.add(new Product(R.drawable.heineken, "Heineken"));
        productList.add(new Product(R.drawable.larue, "Larue"));
        productList.add(new Product(R.drawable.saigon, "Sai Gon"));
        productList.add(new Product(R.drawable.sapporo, "Sapporo"));
        productList.add(new Product(R.drawable.tiger, "Tiger"));

        //init adapter
        adapter = new ProductAdapter(GridViewNC.this, R.layout.gridview_item, productList);

        binding.gvSanPham.setAdapter(adapter);
    }
}