package com.k20411group03.chillwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.k20411group03.DatabaseHelper;
import com.k20411group03.chillwithsqlite.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createDb();
    }

    private void createDb() {
        DatabaseHelper db = new DatabaseHelper(MainActivity.this);
        db.createSampleData();
    }


}