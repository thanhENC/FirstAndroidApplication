package com.k204110855.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.k204110855.models.Beer;

import java.util.List;


public class BeerAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Beer> beers;

    public BeerAdapter(Activity activity, int item_layout, List<Beer> beers) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.beers = beers;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
