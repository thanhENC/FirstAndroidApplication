package com.k204110855.handson11102022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.k204110855.handson11102022.databinding.ActivityBasicListViewExampleBinding;
import com.k204110855.models.Product;

public class BasicListViewExample extends AppCompatActivity {

    ActivityBasicListViewExampleBinding binding;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_basic_list_view_example);

        binding = ActivityBasicListViewExampleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initAdapter();
        addEvents();
    }

    private void initAdapter() {
        adapter = new ArrayAdapter<Product>(BasicListViewExample.this, android.R.layout.simple_list_item_1);
        binding.lvProduct.setAdapter(adapter);
    }

    private void addEvents() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert product info

                String name = binding.edtName.getText().toString();
                String color = binding.edtColor.getText().toString();
                Product p = new Product(name, color);

                adapter.add(p);
            }
        });

        binding.lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product p = (Product) adapter.getItem(i);
                Toast.makeText(BasicListViewExample.this, p.getProductName() + " - " + p.getProductColor(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.lvProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product p = (Product) adapter.getItem(i);
                adapter.remove(p);
                return true;
            }
        });
    }

}