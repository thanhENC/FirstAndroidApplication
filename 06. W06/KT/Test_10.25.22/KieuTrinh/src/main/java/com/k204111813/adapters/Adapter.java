package com.k204111813.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.k204111813.models.Restaurant;
import com.k204111813.test2510.R;

import java.util.List;

public class Adapter extends BaseAdapter {

    Activity activity;
    int layout;
    List<Restaurant> restaurants;
    //Constructor


    public Adapter(Activity activity, int layout, List<Restaurant> restaurants) {
        this.activity = activity;
        this.layout = layout;
        this.restaurants = restaurants;
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }

    @Override
    public Object getItem(int i) {
        return restaurants.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null) {
            holder = new ViewHolder();
            LayoutInflater ìnflater = (LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
            view = ìnflater.inflate(layout, null);
            holder.imv_Photo = view.findViewById(R.id.imv_Photo);
            holder.txt_Name = view.findViewById(R.id.txt_Name);
            holder.txt_RattingValue = view.findViewById(R.id.txt_RattingValue);
            holder.txt_RattingCount = view.findViewById(R.id.txt_RattingCount);
            holder.txt_Address = view.findViewById(R.id.txt_Address);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }
        //Binding data
        Restaurant res = restaurants.get(i);
        holder.imv_Photo.setImageResource(res.getPhoto());
        holder.txt_Name.setText(res.getName());
        holder.txt_RattingValue.setText(String.valueOf(res.getRattingValue()));
        holder.txt_RattingCount.setText(String.valueOf(res.getRattingCount()));
        holder.txt_Address.setText(res.getAddress());
        return view;

    }

    private class ViewHolder {
        ImageView imv_Photo;
        TextView txt_Name, txt_RattingValue, txt_RattingCount, txt_Address;
    }
}
