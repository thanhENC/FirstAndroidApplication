package com.DinhVanAn.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.DinhVanAn.adapters.RestaurantAdapter;
import com.DinhVanAn.models.Restaurant;
import com.DinhVanAn.test.databinding.ActivityMenuBuaAnBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MenuBuaAn extends AppCompatActivity {
    ActivityMenuBuaAnBinding binding;
    Intent intent;
    List<Restaurant> restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menu_bua_an);

        binding = ActivityMenuBuaAnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() {
        intent = getIntent();
        String meal = intent.getStringExtra("meal");

        restaurants = new ArrayList<Restaurant>();
        try {
            int index = meal.equals("breakfast") ? 0 : 1;
            JSONArray mealList = new JSONArray(getJsonData(MenuBuaAn.this, "data.json"));
            JSONObject mealObject = mealList.getJSONObject(index);
            JSONArray resList = mealObject.getJSONArray(meal);
            for (int i = 0; i <= resList.length(); i++){
                JSONObject res = resList.getJSONObject(i);
                String name = res.getString("name");
                String s_photo = res.getString("photo");
                int photo = MenuBuaAn.this.getResources().getIdentifier(s_photo,"drawable",MenuBuaAn.this.getPackageName());
                float rattingValue = (float) res.getDouble("ratingValue");
                int rattingCount = res.getInt("ratingCount");
                String address = res.getString("address");
                restaurants.add(new Restaurant(name, photo, rattingValue, rattingCount, address));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RestaurantAdapter adapter = new RestaurantAdapter(MenuBuaAn.this, R.layout.meal_item, restaurants);
        binding.lvMeal.setAdapter(adapter);

    }

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