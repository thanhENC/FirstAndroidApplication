package com.k204110855.sqllite_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

    public static SQLiteDatabase db;

    Product selectedProduct = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Create database
        copyBD();
        //loadData();
        addEvents();
        registerForContextMenu(binding.lvProduct);

    }

    private void addEvents() {
        binding.lvProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedProduct = products.get(i);
                return false;
            }
        });
    }

    private void loadData() {
        products = new ArrayList<>();

        //Init sample data
        //products.add(new Product(1, "Heineken", 19000));
        //products.add(new Product(2, "Tiger", 20000));

        db = openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);

        //Cách 1: rawQuery
        //Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME, null); // => Trả về con trỏ Cursor
        //Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE " + Utils.COL_ID + " =? OR " + Utils.COL_ID + " =? ", new String[]{"2", "4"}); // => Trả về con trỏ Cursor

        //Cách 2: query
        //Cursor c = db.query(Utils.TBL_NAME, null, Utils.COL_PRICE + ">=?", new String[]{"16000"}, null, null, null);
        Cursor c = db.query(Utils.TBL_NAME, null, null, null, null, null, null);

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

    @Override
    protected void onResume() {
        loadData();
        super.onResume();
    }

    //==========================MENU==========================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mn_Add){
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);
        }
        else if(item.getItemId() == R.id.mn_About){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    //==========================CONTEXT MENU==========================
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mn_edit){
            Intent intent = new Intent(MainActivity.this, EditActivity.class);

            //Attach data
            if(selectedProduct != null){
                intent.putExtra("productInf", selectedProduct);
                startActivity(intent);
            }
        }
        else if(item.getItemId() == R.id.mn_delete){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Xác nhận xóa sp!");
            builder.setMessage("Bạn có chắc chắn muốn xóa sp " + selectedProduct.getProductName() + " không?");
            builder.setIcon(android.R.drawable.ic_delete);

            builder.setPositiveButton("Anh xóa iem đi 😏", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    int numbOfRows = db.delete(Utils.TBL_NAME, Utils.COL_ID + "=?", new String[]{ String.valueOf(selectedProduct.getProductId())});
                    if(numbOfRows > 0){
                        Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                        loadData();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                    }
                    loadData();
                }
            });

            builder.setNegativeButton("Tha iem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Không xóa nữa", Toast.LENGTH_SHORT).show();
                }
            });

            builder.create().show();

//            if(selectedProduct != null){
//                int numbOfRows = db.delete(Utils.TBL_NAME, Utils.COL_ID + "=?", new String[]{ String.valueOf(selectedProduct.getProductId())});
//
//                if(numbOfRows > 0){
//                    Toast.makeText(this, "Delete success", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(this, "Delete failed", Toast.LENGTH_SHORT).show();
//                }
//                loadData();
//            }
        }

        //intent.putExtra()

        return super.onContextItemSelected(item);
    }
}