package com.dinhvanan.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dinhvanan.models.Product;
import com.dinhvanan.test.R;
import com.dinhvanan.test.databinding.ActivityMainBinding;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<Product> products;

    public ProductAdapter(Activity activity, int item_layout, List<Product> products) {
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
        ViewHolder holder = new ViewHolder();
        if (view == null) {
            //holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.imvEdit = view.findViewById(R.id.imv_Edit);
            holder.imvDelete = view.findViewById(R.id.imv_Delete);
            holder.imvProductImage = view.findViewById(R.id.imv_ProductImage);
            holder.txtProductName = view.findViewById(R.id.txt_ProductName);
            holder.txtProductBrand = view.findViewById(R.id.txt_ProductBrand);
            holder.txtProductPrice = view.findViewById(R.id.txt_ProductPrice);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Product p = products.get(i);
        holder.txtProductName.setText(p.getProductName());
        holder.txtProductBrand.setText(p.getBrand());
        holder.txtProductPrice.setText(formatPrice((int)p.getPrice()));
        holder.imvProductImage.setImageResource(p.getImage());

        return view;
    }

    private String formatPrice(int price){
        String str = price + "";
        int count = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            count++;
            if(count == 3){
                str = str.substring(0, i) + "." + str.substring(i);
                count = 0;
            }
        }
        return str + " VND";
    }

    public static class ViewHolder{
        ImageView imvEdit, imvDelete, imvProductImage;
        TextView txtProductName, txtProductBrand, txtProductPrice;
    }
}
