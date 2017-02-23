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

//    private static final String PROVIDER_NAME = "androidcontentproviderdemo.androidcontentprovider.images";
    private static final String PROVIDER_NAME = "com.example.sailik.contentprovidertask_20_feb";
//    private static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/images");
    private static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME );
    private static final int IMAGES = 1;
    Context a;
    DbHelper dbObj;
    //private static final int IMAGE_ID = 2;
    private static final UriMatcher uriMatcher = getUriMatcher();
    private static UriMatcher getUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "images", IMAGES);
        //uriMatcher.addURI(PROVIDER_NAME, "images/#", IMAGE_ID);
        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        //a = getContext();
        Context context = getContext();
        dbObj = new DbHelper(context);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String id = null;
//        if(uriMatcher.match(uri) == IMAGE_ID) {
//            //Query is for one single image. Get the ID from the URI.
//            id = uri.getPathSegments().get(1);
//        }
        return dbObj.getImages(id, projection, selection, selectionArgs, sortOrder);
        //return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case IMAGES:
//                return "vnd.android.cursor.dir/vnd.com.androidcontentproviderdemo.androidcontentprovider.provider.images";
                return "vnd.android.cursor.dir/vnd.com.example.sailik.contentprovidertask_20_feb";
//            case IMAGE_ID:
//                return "vnd.android.cursor.item/vnd.com.androidcontentproviderdemo.androidcontentprovider.provider.images";

        }
        return "";
        //return null;
    }

    @Nullable
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
