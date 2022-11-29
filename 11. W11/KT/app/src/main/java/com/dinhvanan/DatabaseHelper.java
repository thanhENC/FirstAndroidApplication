package com.dinhvanan;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.dinhvanan.test.R;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "product.sqlite";
    public static final int DB_VERSION = 1;
    public static final String TBL_NAME = "Product";
    public static final String COL_ID = "ProductId";
    public static final String COL_NAME = "ProductName";
    public static final String COL_BRAND = "Brand";
    public static final String COL_PRICE = "Price";
    public static final String COL_IMAGE = "Image";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " VARCHAR(50), "
                + COL_BRAND + " VARCHAR(50), "
                + COL_PRICE + " REAL, "
                + COL_IMAGE + " INT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }

    //SELECT
    public Cursor getData(String sql){
        try {
            SQLiteDatabase db = getReadableDatabase();
            return db.rawQuery(sql, null);
        }
        catch (Exception e){
            return null;
        }
    }

    //INSERT, UPDATE, DELETE
    public void execSql(String sql){
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sql);
        }
        catch (Exception e){
        }
    }

    //Num of Rows
    public int numbOfRows(){
        Cursor cursor = getData("SELECT * FROM " + TBL_NAME);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    //Create Sample Data
    public void createSampleData(){
        if(numbOfRows() == 0){
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Samsung Galaxy S22', 'Samsung', 20000000, " + R.drawable.galaxy_s22_pink + ")");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Samsung Galaxy A13', 'Samsung', 15000000, " + R.drawable.samsunggalaxya13xanh + ")");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Bluetooth Airpods Pro', 'Apple', 1000000, " + R.drawable.bluetooth_airpods_pro_apple + ")");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'iPhone 13 Pro Max', 'Apple', 20000000, " + R.drawable.iphone13_pro_max_xanh_la + ")");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'iPhone 14 Pro Max', 'Apple', 25000000, " + R.drawable.iphone14promaxbac + ")");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Lenovo Yoga Duet 7', 'Lenovo', 22000000, " + R.drawable.lenovoyogaduet7_13itl6_i7_82ma003uvn + ")");
            //execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Macbook Air M1 2020', 'Apple', 23000000, " + R.drawable.macbookairm12020silver + ")");
        }
    }
}
