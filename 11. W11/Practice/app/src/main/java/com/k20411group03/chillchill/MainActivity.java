package com.k20411group03.chillchill;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.k20411group03.DatabaseHelper;
import com.k20411group03.adapters.BookAdapter;
import com.k20411group03.chillchill.databinding.ActivityMainBinding;
import com.k20411group03.models.Book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    BookAdapter adapter;
    ArrayList<Book> books;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createDb();
        loadData();
    }


    private void createDb() {
        db = new DatabaseHelper(MainActivity.this);
        db.createSampleData();
    }

    private void loadData() {
        db = new DatabaseHelper(MainActivity.this);
        books = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DatabaseHelper.TBL_NAME);
        while (c.moveToNext()){
            books.add(new Book(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4), c.getDouble(5)));
        }
        c.close();

        adapter = new BookAdapter(MainActivity.this, R.layout.item_list, books);
        binding.lvBook.setAdapter(adapter);
    }
}
