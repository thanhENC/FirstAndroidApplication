package com.k204110855.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.k204110855.handson11102022.R;
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
        return beers.size();
    }

    @Override
    public Object getItem(int i) {
        return beers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            //link views
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.imvThumb = view.findViewById(R.id.imvThumb);
            holder.txtPrice = view.findViewById(R.id.txtPrice);
            holder.txtName = view.findViewById(R.id.txtName);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        //binding data
        Beer b = beers.get(i);
        holder.imvThumb.setImageResource(b.getProductThumb());
        holder.txtName.setText(b.getProductName());
        holder.txtPrice.setText(String.valueOf(b.getProductPrice()));

        return view;
    }

    public static class ViewHolder{
        ImageView imvThumb;
        TextView txtName, txtPrice;

    }
}
