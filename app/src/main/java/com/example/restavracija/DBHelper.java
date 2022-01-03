package com.example.restavracija;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Narocila(ID TEXT primary key, narocilo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Narocila");
    }

    public Boolean oddajNarocilo(String ID, String narocilo)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", ID);
        contentValues.put("narocilo", narocilo);
        long result = db.insert("Narocila", null, contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean deletedata (String ID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Narocila where ID = ?", new String[]{ID});
        if (cursor.getCount() > 0) {
            long result = db.delete("Narocila", "ID=?", new String[]{ID});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }


    public Cursor getdata ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Narocila", null);
        return cursor;
    }

}
