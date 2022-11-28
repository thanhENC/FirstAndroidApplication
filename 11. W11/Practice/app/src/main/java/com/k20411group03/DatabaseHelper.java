package com.k20411group03;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "library.sqlite";
    public static final int DB_VERSION = 1;
    public static final String TBL_NAME = "Book";
    public static final String COL_ID = "BookId";
    public static final String COL_NAME = "BookName";
    public static final String COL_AUTHOR = "Author";
    public static final String COL_PUBLISHER = "Publisher";
    public static final String COL_REPRINT = "Reprint";
    public static final String COL_PRICE = "Price";
    //public static final String COL_THUMBNAIL = "Thumbnail";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " VARCHAR(50), "
                + COL_AUTHOR + " VARCHAR(50), "
                + COL_PUBLISHER + " VARCHAR(50), "
                + COL_REPRINT + " INTEGER, "
                + COL_PRICE + " REAL)";
                //+ COL_THUMBNAIL + " BLOB)";
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
        try{
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sql);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public int numbOfRows(){
        Cursor cursor = getData("SELECT * FROM " + TBL_NAME);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void createSampleData(){
        if(numbOfRows() == 0){
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'The Lord of the Rings', 'J.R.R. Tolkien', 'Allen & Unwin', 1, 100)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Harry Potter and the Philosopher''s Stone', 'J.K. Rowling', 'Bloomsbury', 1, 100)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'And Then There Were None', 'Agatha Christie', 'Collins Crime Club', 1, 100)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'The Hobbit', 'J.R.R. Tolkien', 'Allen & Unwin', 1, 100)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'The Lion, the Witch and the Wardrobe', 'C.S. Lewis', 'Geoffrey Bles', 1, 100)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'The Little Prince', 'Antoine de Saint-Exupéry', 'Reynal & Hitchcock', 1, 100)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'The Da Vinci Code', 'Dan Brown', 'Doubleday', 1, 100)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'The Catcher in the Rye', 'J.D. Salinger', 'Little, Brown and Company', 1, 100)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'The Hitchhiker''s Guide to the Galaxy', 'Douglas Adams', 'Pan Books', 1, 100)");

        }
    }
}
