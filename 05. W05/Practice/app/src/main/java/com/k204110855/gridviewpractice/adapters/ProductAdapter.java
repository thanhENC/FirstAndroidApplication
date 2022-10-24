package com.k204110855.gridviewpractice.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.k204110855.gridviewpractice.R;
import com.k204110855.gridviewpractice.models.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Product> products;

    public ProductAdapter(Activity activity, int item_layout, List<Product> products){
        this.activity = activity;
        this.item_layout = item_layout;
        this.products = products;
    }


    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            //link views
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.imvThumb = view.findViewById(R.id.imvThumb);
            holder.txtName = view.findViewById(R.id.txtName);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        //binding data
        Product p = products.get(i);
        holder.imvThumb.setImageResource(p.getProductThumb());
        holder.txtName.setText(p.getProductName());

        return view;
    }

    public static class ViewHolder{
        ImageView imvThumb;
        TextView txtName;
    }
}
