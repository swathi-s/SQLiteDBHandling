package com.example.user.sqlitedbhandling;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SwathiHelper swathiHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swathiHelper = new SwathiHelper(this);

        SQLiteDatabase sqLiteDatabase = swathiHelper.getWritableDatabase();

    }
}
