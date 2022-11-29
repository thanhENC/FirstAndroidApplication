package com.k20411group03;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "product.sqlite";
    public static final int DB_VERSION = 1;
    public static final String TBL_NAME = "Product";
    public static final String COL_ID = "ProductId";
    public static final String COL_NAME = "ProductName";
    public static final String COL_BRAND = "ProductBrand";
    public static final String COL_PRICE = "ProductPrice";
    //public static final String COL_IMAGE = "ProductImage";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " VARCHAR(50), "
                + COL_BRAND + " VARCHAR(50), "
                + COL_PRICE + " REAL)";
                //+ COL_IMAGE + " BLOB)";
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

    //get number of rows
    public int numberOfRows(){
        try {
            Cursor cursor = getData("SELECT * FROM " + TBL_NAME);
            int count = cursor.getCount();
            cursor.close();
            return count;
        }
        catch (Exception e){
            return 0;
        }
    }

    //create sample data
    public void createSampleData(){
        execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Cocochanel', 'Chanel', 1000)");
        execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Dior', 'Dior', 2000)");
        execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Gucci', 'Gucci', 3000)");
        execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Louis Vuitton', 'Louis Vuitton', 4000)");
        execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Prada', 'Prada', 5000)");
        execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Versace', 'Versace', 6000)");
    }
}
