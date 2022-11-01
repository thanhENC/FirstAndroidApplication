package com.DinhVanAn.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.DinhVanAn.models.Restaurant;
import com.DinhVanAn.test.R;

import java.util.List;

public class RestaurantAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Restaurant> restaurants;

    public RestaurantAdapter(Activity activity, int item_layout, List<Restaurant> restaurants) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.restaurants = restaurants;
    }

    @Override
    public int getCount() {
        return restaurants.size(); // lay so luong item trong adapter
    }

    @Override
    public Object getItem(int i) {
        return restaurants.get(i); //lay item thu i trong adapter restaurants
    }

    @Override
    public long getItemId(int i) {
        return 0; //tam thoi chua dung toi
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            viewHolder.imvResThumb = view.findViewById(R.id.imvResThumb);
            viewHolder.txtResName = view.findViewById(R.id.txtResName);
            viewHolder.txtResRate = view.findViewById(R.id.txtResRate);
            viewHolder.txtResRateCount = view.findViewById(R.id.txtResRateCount);
            viewHolder.txtAddress = view.findViewById(R.id.txtAddress);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        //binding data
        Restaurant res = restaurants.get(i);
        viewHolder.imvResThumb.setImageResource(res.getResThumb());
        viewHolder.txtResRate.setText(String.valueOf(res.getResRating()));
        viewHolder.txtResRateCount.setText(String.valueOf(res.getResRatingCount()));
        viewHolder.txtAddress.setText(res.getResAddress());

        return view;
    }

    class ViewHolder{
        ImageView imvResThumb;
        TextView txtResName, txtResRate, txtResRateCount, txtAddress;
    }
}
