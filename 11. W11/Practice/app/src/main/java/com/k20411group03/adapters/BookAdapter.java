package com.k20411group03.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.k20411group03.chillchill.R;
import com.k20411group03.models.Book;

import java.util.List;

public class BookAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<Book> books;

    public BookAdapter(Activity activity, int item_layout, List<Book> books) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewHolder{
        TextView txtBookInfo;
        ImageView imvEdit, imvDelete;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder();
        if(view == null){
            //holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.txtBookInfo = view.findViewById(R.id.txt_BookInfo);
            holder.imvEdit = view.findViewById(R.id.imv_Edit);
            holder.imvDelete = view.findViewById(R.id.imv_Delete);

            view.setTag(holder);

        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        Book b = books.get(i);
        holder.txtBookInfo.setText(b.getBookName() + " - " + b.getBookAuthor() + " - " + b.getBookPrice());
        holder.imvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Edit button click
                Toast.makeText(activity, "Edit button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        holder.imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Delete button click
                Toast.makeText(activity, "Delete button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
