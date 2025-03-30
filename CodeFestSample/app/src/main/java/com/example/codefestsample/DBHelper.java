package com.example.codefestsample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.security.IdentityScope;

public class DBHelper extends SQLiteOpenHelper {

    Context context;
    private static final String DATABASE_NAME = "Inventory.db";
    private static final String TABLE_NAME = "tbl_Inventory";

    public static final String COL_ID = "Item_ID";
    public static final String COL_NAME = "Item_Name";
    public static final String COL_DESC = "Item_Desc";
    public static final String COL_PRICE = "Item_Price";
    public static final String COL_QUANTITY = "Item_Quantity";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addItem(String name, String Desc, String Price, String Quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, name);
        cv.put(COL_DESC, Desc);
        cv.put(COL_PRICE, Price);
        cv.put(COL_QUANTITY, Quantity);

        long res = db.insert(TABLE_NAME, null, cv);
        if(res==-1){
            Toast.makeText(context, "Failed Adding Data", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Data Added", Toast.LENGTH_SHORT).show();
        }
    }
    void editItem(String id, String name, String Desc, String Price, String Quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, name);
        cv.put(COL_DESC, Desc);
        cv.put(COL_PRICE, Price);
        cv.put(COL_QUANTITY, Quantity);

        long res = db.update(TABLE_NAME, cv, "Item_ID=?", new String[]{id});
        if(res==-1){
            Toast.makeText(context, "Failed Adding Data", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Data Added", Toast.LENGTH_SHORT).show();
        }
    }
    void viewItems(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if(cursor == null){
            Toast.makeText(context, "Found nothing", Toast.LENGTH_SHORT).show();
        }

    }
    void deleteItem(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "Item_ID=?", new String[]{id});
    }
    void deleteAllItems(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
}
