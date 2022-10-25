package com.DinhVanAn.test.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.DinhVanAn.test.models.Restaurant;

import org.w3c.dom.Text;

import java.util.List;

public class RestaurantAdapter extends BaseAdapter {
        Activity activity;
        int item_layout;
        List<Restaurant>restaurants;


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
        return null;
    }

    public static class ViewHolder{
        ImageView imvResThumb;
        TextView txtResName;
        TextView txtResRate;
        TextView txtResRateCount;
        TextView txtResAddress;
    }
}
