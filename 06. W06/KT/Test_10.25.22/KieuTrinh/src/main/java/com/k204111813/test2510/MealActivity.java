package com.k204111813.test2510;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.k204111813.adapters.Adapter;
import com.k204111813.models.Restaurant;
import com.k204111813.test2510.databinding.ActivityMealBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MealActivity extends AppCompatActivity {
    ActivityMealBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_meal);
        binding = ActivityMealBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getMealIntent();
        addEvent();
    }

    private void getMealIntent() {
        Intent intent = getIntent();
        String meal = intent.getStringExtra("meal");
        int index = meal.equals("breakfast") ? 0 : 1;
        loadData(index,meal);

    }

    private void addEvent() {
        binding.lvRestaurant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Restaurant restaurant = (Restaurant) adapterView.getItemAtPosition(i);
                Dialog dialog = new Dialog(MealActivity.this);
                dialog.setContentView(R.layout.dialog);
                ImageView img = dialog.findViewById(R.id.imv_dialogPhoto);
                img.setImageResource(restaurant.getPhoto());
                TextView txtName = dialog.findViewById(R.id.txt_dialogName);
                txtName.setText(restaurant.getName());
                TextView txtAddress = dialog.findViewById(R.id.txt_dialogAddress);
                txtAddress.setText(restaurant.getAddress());
                TextView txtRattingValue = dialog.findViewById(R.id.txt_dialogRatingValue);
                txtRattingValue.setText(String.valueOf(restaurant.getRattingValue()));
                dialog.show();
            }
        });

    }

    private void loadData(int index,String meal) {
        ArrayList<Restaurant> breakfast = new ArrayList<>();

        //Json
        try {
//            JSONArray jsonArray = new JSONArray(getJsonData(MealActivity.this,"data.json"));
//            JSONArray jsonBreakArr = jsonArray.getJSONObject(index).getJSONArray(meal);

           JSONArray jsonArr = new JSONArray(getJsonData(MealActivity.this,"data.json"));
           JSONObject mealType = jsonArr.getJSONObject(index);
           JSONArray list_restaurant = mealType.getJSONArray(meal);
            for(int i = 0; i < list_restaurant.length(); i++){
                JSONObject restaurant = list_restaurant.getJSONObject(i);
                String name = restaurant.getString("name");
                String s_photo = restaurant.getString("photo");
                int photo = MealActivity.this.getResources().getIdentifier(s_photo,"drawable",MealActivity.this.getPackageName());
                Double rattingValue = restaurant.getDouble("ratingValue");
                Double rattingCount = restaurant.getDouble("ratingCount");
                String address = restaurant.getString("address");
                breakfast.add(new Restaurant(name,photo,rattingValue,rattingCount,address));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        breakfast.add(new Restaurant( "Bếp nhà Xứ Quảng","bf_bepnhaxuquang",4.4,16.0,"16 Trần Cao Vân, P. Đa Kao, Q. 1, Tp.HCM"));
//        breakfast.add(new Restaurant( "Cơm Quê Mười Khó","bf_comquemuoikho",4.8,35.0,"27 Trần Quốc Thảo, P. 6, Q. 3, Tp.HCM"));
        binding.imvBanner.setImageResource(index == 0 ? R.drawable.breakfast_banner : R.drawable.lunch_banner);
        Adapter adapter = new Adapter(MealActivity.this,R.layout.restaurant_item,breakfast);
        binding.lvRestaurant.setAdapter(adapter);

    }

    //Read Json
    static String getJsonData(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }



}