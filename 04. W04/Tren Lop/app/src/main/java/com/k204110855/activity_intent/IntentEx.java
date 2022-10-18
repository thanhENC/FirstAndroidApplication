package com.k204110855.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.k204110855.activity_intent.databinding.ActivityIntentExBinding;

public class IntentEx extends AppCompatActivity {

    ActivityIntentExBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_intent_ex);

        binding = ActivityIntentExBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnOpenActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open sub activity 1
                Intent intent = new Intent(IntentEx.this, SubActivity1.class);
                startActivity(intent);
            }
        });
        binding.btnOpenActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Opening SubAct 2 and sending data
                Intent intent = new Intent(IntentEx.this, SubActivity2.class);
                //Attach data
                intent.putExtra("numb", 8);
                intent.putExtra("grades", 8.9f);
                intent.putExtra("checked", true);
                intent.putExtra("say", "Hello");

                startActivity(intent);
            }
        });
    }
}