package com.k20411group03.sqlite_ex2;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "products.sqlite";
    public static final int DB_VERSION = 1;

    public static final String TBL_NAME = "Product";
    public static final String COL_ID = "ProductID";
    public static final String COL_NAME = "ProductName";
    public static final String COL_PRICE = "ProductPrice";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create table
        // tao lenh sql
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " VARCHAR(50), "
                + COL_PRICE + " REAL)";
        // chay lenh sql
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }

    //SELECT
    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    //INSERT, UPDATE, DELETE
    public void execSql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public int numbOfRows(){
        Cursor cursor = getData("SELECT * FROM " + TBL_NAME);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void createSampleData(){
        if(numbOfRows() == 0){
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Heineken', 19000)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Tiger', 18000)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Sapporo', 21000)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Corona Extra', 25000)");
        }
    }

}
