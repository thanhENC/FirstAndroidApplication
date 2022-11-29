package com.dinhvanan.test;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

import com.dinhvanan.DatabaseHelper;
import com.dinhvanan.adapters.ProductAdapter;
import com.dinhvanan.models.Product;
import com.dinhvanan.test.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ProductAdapter adapter;
    ArrayList<Product> products;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createDb();
        loadData();
    }

    private void createDb() {
        db = new DatabaseHelper(MainActivity.this);
        db.createSampleData();
    }

    private void loadData() {
        products = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DatabaseHelper.TBL_NAME);
        while (c.moveToNext()){
            products.add(new Product(c.getInt(0), c.getString(1), c.getString(2), c.getDouble(3), c.getInt(4)));
        }
        c.close();
        adapter = new ProductAdapter(MainActivity.this, R.layout.product_item, products);
        binding.lvProduct.setAdapter(adapter);
    }

}