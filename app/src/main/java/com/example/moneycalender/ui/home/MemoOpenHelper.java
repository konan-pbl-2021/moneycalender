package com.example.moneycalender.ui.home;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MemoOpenHelper extends SQLiteOpenHelper {

    static final private String DBName = "MEMO_DB";
    static  final  private int VERSION = 1;

    public MemoOpenHelper(Context context) {

        super(context,DBName,null,VERSION);
    }



    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE MEMO_TABLE (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, "+"uuid TEXT,"+" body TEXT)");
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS MEMO_TABLE");

        onCreate(db);
    }


}
