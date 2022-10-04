package com.k204110855.events_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAnonymous, btnVariableListener1, btnVariableListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkViews();
        addEvents();
    }

    //Variable as listener
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_VariableListener1){
                Toast.makeText(MainActivity.this, "Variable as Listener 1", Toast.LENGTH_SHORT).show();
            }
            else if (view.getId() == R.id.btn_VariableListener2){
                Toast.makeText(MainActivity.this, "Variable as Listener 2", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void linkViews() {
        btnAnonymous = findViewById(R.id.btn_Anonymous);
        btnVariableListener1 = findViewById(R.id.btn_VariableListener1);
        btnVariableListener2 = findViewById(R.id.btn_VariableListener2);
    }

    private void addEvents() {
        //Anonymous Listener
        btnAnonymous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Anonymous Listener", Toast.LENGTH_SHORT).show();
            }
        });

        //Variable as Listener
        btnVariableListener1.setOnClickListener(onClickListener);
        btnVariableListener2.setOnClickListener(onClickListener);
    }

    public void showToast(View view) {
        Toast.makeText(this, "Bello", Toast.LENGTH_SHORT).show();
    }
}