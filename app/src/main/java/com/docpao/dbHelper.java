package com.docpao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Reservation.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Res_Table";


    private static final String COL_ID = "ID";
    private static final String COL1 = "RES_NAME";
    private static final String COL2 = "RES_NUMBER_OF_PERSON";
    private static final String COL3 = "RES_DATE";
    private static final String COL4 = "TIMESTAMP";

    public final Context context;

    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ( " +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 + " TEXT NOT NULL, " +
                COL2 + " INTEGER NOT NULL, " +
                COL3 + " TEXT NOT NULL, " +
                COL4 + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP );";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // ADD RESERVATION
    public void addRes(String res_name, String res_no_of_person, String res_date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("RES_NAME",res_name);
        cv.put("RES_NUMBER_OF_PERSON",res_no_of_person);
        cv.put("RES_DATE",res_date);

        long res = db.insert(TABLE_NAME,null,cv);

        if (res==-1){
            Toast.makeText(context, "failed to add", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    // VIEW TABLE

    public Cursor read(){

        Cursor cursor = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
         if (db!=null){
             cursor = db.rawQuery(query,null);
         }
        return cursor;
    }

    public void delRes(String id){
        SQLiteDatabase db = this.getWritableDatabase();

        long res = db.delete(TABLE_NAME,"ID=?",new String[]{id});

        if (res==-1){
            Toast.makeText(context, "failed to delete", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "removed successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public void edtRes(String id, String res_name, String res_no_of_person, String res_date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("RES_NAME",res_name);
        cv.put("RES_NUMBER_OF_PERSON",res_no_of_person);
        cv.put("RES_DATE",res_date);

        long res = db.update(TABLE_NAME,cv,"ID=?",new String[]{id});

        if (res==-1){
            Toast.makeText(context, "failed to update", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "update successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public int sumOfColumnNoOfPerson(){

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT SUM(RES_NUMBER_OF_PERSON) FROM Res_Table";
        Cursor cursor = db.rawQuery(query,null);
        int sum = 0;

        if (cursor.moveToFirst()){
            sum = cursor.getInt(0);
        }
        cursor.close();

        return sum;
    }


}
