package com.example.sailik.contentprovidertask_20_feb;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by saili.k on 23-02-2017.
 */

public class DataProvider extends ContentProvider {


    private static final String PROVIDER_NAME = "com.example.sailik.contentprovidertask_20_feb";
    private static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME );
    private static final int ALBUMS = 1;

    DbHelper dbObj;

    private static final UriMatcher uriMatcher = getUriMatcher();
    private static UriMatcher getUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "albums", ALBUMS);
        return uriMatcher;
    }

    @Override
    public boolean onCreate() {

        Context context = getContext();
        dbObj = new DbHelper(context);
        return true;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String id = null;
        return dbObj.getItems(id, projection, selection, selectionArgs, sortOrder);

    }


    @Override
    public String getType(Uri url) {
        int match = uriMatcher.match(url);
        switch (match) {
            case ALBUMS:
                return "vnd.android.cursor.dir/vnd.com.example.sailik.contentprovidertask_20_feb";
        }
        return null;

    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
