package com.k204110855.activity_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.k204110855.activity_intent.databinding.ActivityIntentExBinding;
import com.k204110855.models.Product;

public class IntentEx extends AppCompatActivity {

    ActivityIntentExBinding binding;
    public static final int REQUEST_CODE = 1; //Type psf and Enter

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
//                intent.putExtra("numb", 8);
//                intent.putExtra("grades", 8.9f);
//                intent.putExtra("checked", true);
//                intent.putExtra("say", "Hello");

                Bundle bundle = new Bundle();
                bundle.putInt("numb", 7);
                bundle.putFloat("grades", 7.9f);
                bundle.putString("say", "Welcome");
                bundle.putBoolean("checked", true);
                intent.putExtra("my_data", bundle);


                //Sending object
                Product p = new Product("Heineken", 19000);
                bundle.putSerializable("product_inf", p); //-> gửi tất cả mọi thứ, nhưng k tối ưu


                //bundle.putParcelable(); parcelable --> Tối ưu hơn khi gửi 1 object

                startActivity(intent);
            }
        });
        binding.btnOpenActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentEx.this, SubActivity3.class);
                intent.putExtra("numb", binding.edtNumb.getText().toString());

                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
            int pow = data.get
        }
    }
}