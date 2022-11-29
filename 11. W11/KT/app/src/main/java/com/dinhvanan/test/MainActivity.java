package com.dinhvanan.test;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.dinhvanan.DatabaseHelper;
import com.dinhvanan.adapters.ProductAdapter;
import com.dinhvanan.models.Product;
import com.dinhvanan.test.databinding.ActivityMainBinding;

import java.util.ArrayList;

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
            products.add(new Product(c.getInt(0), c.getString(1), c.getString(2), c.getDouble(3), c.getInt(4)));
        }
        c.close();
        adapter = new ProductAdapter(MainActivity.this, R.layout.product_item, products);
        binding.lvProduct.setAdapter(adapter);
    }

    //DIALOG
    public void openDialogUpdate(Product p){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_update);

        EditText edtName, edtPrice, edtBrand, edtImage;
        Button btnUpdate, btnCancel;

        edtName = dialog.findViewById(R.id.edt_Name);
        edtBrand = dialog.findViewById(R.id.edt_Brand);
        edtPrice = dialog.findViewById(R.id.edt_Price);
        edtImage = dialog.findViewById(R.id.edt_Image);
        btnUpdate = dialog.findViewById(R.id.btn_Update);
        btnCancel = dialog.findViewById(R.id.btn_Cancel);

        edtName.setText(p.getProductName());
        edtBrand.setText(p.getBrand());
        edtPrice.setText(String.valueOf(p.getPrice()));
        edtImage.setText(String.valueOf(p.getImage()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSql("UPDATE " + DatabaseHelper.TBL_NAME + " SET " +
                        DatabaseHelper.COL_NAME + " = '" + edtName.getText().toString() + "', " +
                        DatabaseHelper.COL_BRAND + " = '" + edtBrand.getText().toString() + "', " +
                        DatabaseHelper.COL_PRICE + " = " + edtPrice.getText().toString() + edtImage.getText().toString() +
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
        TextView txtName, txtBrand, txtPrice;
        ImageView imvProduct;

        btnDelete = dialog.findViewById(R.id.btn_Delete);
        btnCancel = dialog.findViewById(R.id.btn_Cancel);
        txtName = dialog.findViewById(R.id.txt_Name);
        txtPrice = dialog.findViewById(R.id.txt_Price);
        txtBrand = dialog.findViewById(R.id.txt_Brand);
        imvProduct = dialog.findViewById(R.id.imv_ProductImage);

        txtName.setText(p.getProductName());
        txtBrand.setText(p.getBrand());
        txtPrice.setText(p.formatPrice(p.getPrice()));
        imvProduct.setImageResource(p.getImage());

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

    //MENU
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

            EditText edtName, edtBrand, edtPrice, edtImage;
            Button btnAdd, btnCancel;

            edtName = dialog.findViewById(R.id.edt_Name);
            edtBrand = dialog.findViewById(R.id.edt_Brand);
            edtPrice = dialog.findViewById(R.id.edt_Price);
            edtImage = dialog.findViewById(R.id.edt_Image);
            btnAdd = dialog.findViewById(R.id.btn_Add);
            btnCancel = dialog.findViewById(R.id.btn_Cancel);

            edtImage.setText(String.valueOf(R.drawable.macbookairm12020silver));

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Insert product info
                    db.execSql("INSERT INTO " + DatabaseHelper.TBL_NAME + " VALUES (NULL, '" +
                            edtName.getText().toString() + "', '" +
                            edtBrand.getText().toString() + "', " +
                            edtPrice.getText().toString() + ", " +
                            edtImage.getText().toString() + ")");
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