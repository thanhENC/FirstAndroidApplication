package com.k204110855.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.k204110855.activity_intent.databinding.ActivitySub3Binding;

public class SubActivity3 extends AppCompatActivity {

    ActivitySub3Binding binding;
    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sub3);

        binding = ActivitySub3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();
        addEvent();
    }

    private void getData() {
        Intent intent = getIntent();
        int numb = Integer.parseInt(intent.getStringExtra("numb"));
        binding.txtNumb.setText(String.valueOf(numb));
    }

    private void addEvent() {
        binding.btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numb = Integer.parseInt(binding.txtNumb.getText().toString());
                int pow = numb * numb;
                intent.putExtra("pow", pow);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}