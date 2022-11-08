package com.k204110855.sqllite_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.k204110855.sqllite_ex.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {

    ActivityAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_add);

        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent data into Db
                ContentValues values = new ContentValues();
                values.put(Utils.COL_NAME, binding.edtName.getText().toString());
                values.put(Utils.COL_PRICE, Double.parseDouble(binding.edtPrice.getText().toString())); //Vì price trong DB là kiểu double

                long numbOfRows = MainActivity.db.insert(Utils.TBL_NAME, null, values);

                if(numbOfRows > 0){
                    Toast.makeText(AddActivity.this, "Add success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AddActivity.this, "Add failed", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }
}