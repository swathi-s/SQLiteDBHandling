package com.example.user.sqlitedbhandling;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Contacts;

/**
 * Created by user on 9/12/2016.
 */
public class SwathiHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myDatabase";
    private static final String TABLE_NAME = "myTable";
    private static final int DATABASE_VERSION = 3;
    private static final String UID = "_id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255), "+ADDRESS+" VARCHAR(255) )";
    //private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) )";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
     private Context context;
    public SwathiHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
        Message.message(context,"constructor called");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE myTable (_id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(255));
        try{
            Message.message(context,"onCreate called");
            db.execSQL(CREATE_TABLE);
        } catch (SQLException e){
            Message.message(context,""+e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Message.message(context,"onUpgrade called");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (SQLException e){
            Message.message(context,""+e);
        }

    }
}
