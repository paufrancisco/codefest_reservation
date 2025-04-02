package com.example.a6hoursproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME = "Inventory.db";
    private static final String TABLE_NAME = "Inventory_Table";
    private static final String COL0 = "Item_ID";
    private static final String COL1 = "Item_Name";
    private static final String COL2 = "Item_Description";
    private static final String COL3 = "Item_Price";
    private static final String COL4 = "Item_Quantity";
    private static final String COL5 = "Item_TimeStamp";


    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLE_NAME+"("+
                COL0 +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL1 +" TEXT, "+
                COL2 +" TEXT, "+
                COL3 +" TEXT, "+
                COL4 +" TEXT, "+
                COL5 +" TEXT DEFAULT CURRENT_TIMESTAMP);";


        db.execSQL(query,null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void addRes(String name , String des, String price, String qty){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("Item_Name",name);
        cv.put("Item_Description",des);
        cv.put("Item_Price",price);
        cv.put("Item_Quantity",qty);

        long res = db.insert(TABLE_NAME,null,cv);
        if (res==-1) Toast.makeText(context, "add failed", Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "add success", Toast.LENGTH_SHORT).show();
    }

    public void updateRes(String id, String name , String des, String price, String qty){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("Item_Name",name);
        cv.put("Item_Description",des);
        cv.put("Item_Price",price);
        cv.put("Item_Quantity",qty);

        long res = db.update(TABLE_NAME,cv,"Item_ID=?",new String[]{id});
        if (res==-1) Toast.makeText(context, "update failed", Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "update success", Toast.LENGTH_SHORT).show();
    }

    public void delRes(String id){

        SQLiteDatabase db = this.getWritableDatabase();

        long res = db.delete(TABLE_NAME,"Item_ID=?",new String[]{id});
        if (res==-1) Toast.makeText(context, "delete failed", Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "delete success", Toast.LENGTH_SHORT).show();
    }

    public Cursor read(){
        Cursor res = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        if (db!=null){
            db.rawQuery(query,null);
        }
        return res;
    }

}
