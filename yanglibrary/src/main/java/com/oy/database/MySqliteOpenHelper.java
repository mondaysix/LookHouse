package com.oy.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class MySqliteOpenHelper extends SQLiteOpenHelper {
    private String tableName;

    public MySqliteOpenHelper(Context context, String name, String tableName) {
        super(context, name, null, 1);
        this.tableName = tableName;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "create table "+tableName+"(_id primary key,cityId,cityName,type)";
        db.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
