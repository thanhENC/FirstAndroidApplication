package com.k204110855.sqllite_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.k204110855.models.Product;
import com.k204110855.sqllite_ex.databinding.ActivityMainBinding;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayAdapter<Product> adapter;
    ArrayList<Product> products;

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Create database
        copyBD();
        loadData();
    }

    private void loadData() {
        products = new ArrayList<>();

        //Init sample data
        //products.add(new Product(1, "Heineken", 19000));
        //products.add(new Product(2, "Tiger", 20000));

        db = openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME, null); // => Trả về con trỏ Cursor

        //Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE " + Utils.COL_ID + " =? OR " + Utils.COL_ID + " =? ", new String[]{"2", "4"}); // => Trả về con trỏ Cursor

        // Lặp qua từng dòng dữ liệu trong db và thêm vào ArrayList
        while (c.moveToNext()) {
            products.add(new Product(c.getInt(0), c.getString(1), c.getDouble(2)));
        }
        c.close(); //Đọc xong đóng con trỏ lại để giải phóng bộ nhớ

        adapter = new ArrayAdapter<Product>(MainActivity.this, android.R.layout.simple_list_item_1, products);

        binding.lvProduct.setAdapter(adapter);
    }

    private void copyBD() {
        File dbFile = getDatabasePath(Utils.DB_NAME);
        if (!dbFile.exists()) {
           if(copyDBFromAssets()){
               Toast.makeText(this, "Copy database success", Toast.LENGTH_SHORT).show();
           }
           else {
                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
           }
        }
    }

    private boolean copyDBFromAssets() {
        String dbFilePath = getApplicationInfo().dataDir + Utils.DB_PATH_SUFFIX + Utils.DB_NAME;
        try{
            InputStream inputStream = getAssets().open(Utils.DB_NAME);
            File f = new File(getApplicationInfo().dataDir + Utils.DB_PATH_SUFFIX);
            if(!f.exists()){
                f.mkdir();
            }
            OutputStream outputStream = new FileOutputStream(dbFilePath);
            byte[] buffer = new byte[1024]; int length;
            while ((length = inputStream.read(buffer)) > 0){
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return true;
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}