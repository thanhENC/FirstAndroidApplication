package com.k204110855.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.k204110855.activity_intent.databinding.Activity2Binding;
import com.k204110855.activity_intent.databinding.ActivitySub2Binding;
import com.k204110855.models.Product;

public class SubActivity2 extends AppCompatActivity {

    ActivitySub2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sub2);

        binding = ActivitySub2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showData();
    }

    private void showData() {
        Intent intent = getIntent();
        //Receive Data
//        int numb = intent.getIntExtra("numb", 0);
//        float grades = intent.getFloatExtra("grades", 0.0f);
//        boolean checked = intent.getBooleanExtra("checked", false);
//        String say = intent.getStringExtra("say");
//
//        binding.txtContent.setText("Numb: " + numb + "\n" +
//                                    "Grades: " + grades + "\n" +
//                                    "Checked: " + checked + "\n" +
//                                    "Say: " + say);

//        binding.txtContent.append("Numb: " + numb + "\n");
//        binding.txtContent.append("Grades: " + grades + "\n");
//        binding.txtContent.append("Checked: " + checked + "\n");
//        binding.txtContent.append("Say: " + say);


        // Receive data - method 2
        Bundle bundle = intent.getBundleExtra("my_data");
        int numb = bundle.getInt("numb", 0);
        float grades = bundle.getFloat("grades", 0.0f);
        boolean checked = bundle.getBoolean("checked", false);
        String say = bundle.getString("say");

        Product p = (Product) bundle.getSerializable("product_inf");
        String productInf = p.getProductName() + " - " + p.getProductPrice();

        binding.txtContent.append("Numb: " + numb + "\n");
        binding.txtContent.append("Grades: " + grades + "\n");
        binding.txtContent.append("Checked: " + checked + "\n");
        binding.txtContent.append("Say: " + say);
        binding.txtContent.append("Product: " + productInf);
    }
}