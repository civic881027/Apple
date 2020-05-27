package com.summer.apple.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RestaurantDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="restaurantlist.db";
    private static final int DATABASE_VERSION=1;
    public RestaurantDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_WAITLIST_TABLE="CREATE TABLE "+RestaurantListContract.TABLE_NAME+" ("+
                RestaurantListContract._ID+" INTERGER PRIMARY KEY AUTOINCREMENT, "+
                RestaurantListContract.COLUMN_REST_NAME+" TEXT NOT NULL, "+
                RestaurantListContract.COLUMN_IMAGE_URL+" TEXT NOT NULL, "+
                RestaurantListContract.COLUMN_RATE+" TEXT NOT NULL )"
                ;

        db.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+RestaurantListContract.TABLE_NAME);
        onCreate(db);
    }
}
