package com.example.sailik.contentprovidertask_20_feb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

/**
 * Created by saili.k on 21-02-2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SQLiteExample.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Items";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ALBUM = "Album_name";
    public static final String COLUMN_TRACK = "Track_name";
    Context b;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
        b = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ALBUM + " TEXT NOT NULL, " +
                COLUMN_TRACK + " TEXT NOT NULL)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertMusicItem(String albumName, String trackName) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ALBUM, albumName);
        contentValues.put(COLUMN_TRACK, trackName);
        //contentValues.put(PERSON_COLUMN_AGE, age);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getAllMusicItems() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + TABLE_NAME +" ORDER BY "+ COLUMN_ID +" DESC ", null );

        return res;
    }

    public Integer deleteMusicItem(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,
                COLUMN_ID + " = ? ",
                new String[] { Integer.toString(id) });

    }

    public Cursor getImages(String id, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder sqliteQueryBuilder = new SQLiteQueryBuilder();
        //DbHelper dbObj = new DbHelper(b);
        sqliteQueryBuilder.setTables(TABLE_NAME);

        if(id != null) {
            sqliteQueryBuilder.appendWhere("_id" + " = " + id);
        }

//        if(sortOrder == null || sortOrder == "") {
//            sortOrder = "IMAGETITLE";
//        }
        Cursor cursor = sqliteQueryBuilder.query(getReadableDatabase(),
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);
        return cursor;
    }
}
