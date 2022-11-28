package com.k20411group03.sqlite_ex2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.k20411group03.adapters.ProductAdapter;
import com.k20411group03.models.Product;
import com.k20411group03.sqlite_ex2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ProductAdapter adapter;
    ArrayList<Product> products;

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
        products = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DatabaseHelper.TBL_NAME);
        while (c.moveToNext()){
            products.add(new Product(c.getInt(0), c.getString(1), c.getDouble(2)));
        }
        c.close();
        adapter = new ProductAdapter(MainActivity.this, R.layout.item_list, products);
        binding.lvProduct.setAdapter(adapter);
    }

    public void openDialogUpdate(Product p){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_update);

        EditText edtName, edtPrice;
        Button btnUpdate, btnCancel;

        edtName = dialog.findViewById(R.id.edt_Name);
        edtPrice = dialog.findViewById(R.id.edt_Price);
        btnUpdate = dialog.findViewById(R.id.btn_Update);
        btnCancel = dialog.findViewById(R.id.btn_Cancel);

        edtName.setText(p.getProductName());
        edtPrice.setText(String.valueOf(p.getProductPrice()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSql("UPDATE " + DatabaseHelper.TBL_NAME + " SET " +
                        DatabaseHelper.COL_NAME + " = '" + edtName.getText().toString() + "', " +
                        DatabaseHelper.COL_PRICE + " = " + Double.parseDouble(edtPrice.getText().toString()) +
                        " WHERE " + DatabaseHelper.COL_ID + " = " + p.getProductId());
                loadData();
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void openDialogDelete(Product p) {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_delete);

        Button btnDelete, btnCancel;
        TextView txtName, txtPrice;

        btnDelete = dialog.findViewById(R.id.btn_Delete);
        btnCancel = dialog.findViewById(R.id.btn_Cancel);
        txtName = dialog.findViewById(R.id.txt_Name);
        txtPrice = dialog.findViewById(R.id.txt_Price);

        txtName.setText(p.getProductName());
        txtPrice.setText(String.valueOf(p.getProductPrice()));

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSql("DELETE FROM " + DatabaseHelper.TBL_NAME + " WHERE " + DatabaseHelper.COL_ID + " = " + p.getProductId());
                loadData();
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    //================MENU=================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mn_Add){
            //Opening Add Dialog
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.dialog_add);
            dialog.show();

            EditText edtName, edtPrice;
            Button btnAdd, btnCancel;

            edtName = dialog.findViewById(R.id.edt_Name);
            edtPrice = dialog.findViewById(R.id.edt_Price);
            btnAdd = dialog.findViewById(R.id.btn_Add);
            btnCancel = dialog.findViewById(R.id.btn_Cancel);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Insert product info
                    db.execSql("INSERT INTO " + DatabaseHelper.TBL_NAME + " VALUES(null, '"
                            + edtName.getText().toString() + "', " //Chu y dau nhay don ' vao ten cua san pham
                            + Double.parseDouble(edtPrice.getText().toString()) + ")");
                    loadData();
                    dialog.dismiss();
                }
            });

            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Closing dialog
                    dialog.dismiss();
                }
            });

        }

        return super.onOptionsItemSelected(item);
    }

}
