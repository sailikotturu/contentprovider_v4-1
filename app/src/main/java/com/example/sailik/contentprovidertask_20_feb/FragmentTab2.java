package com.example.sailik.contentprovidertask_20_feb;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;

public class FragmentTab2 extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    CursorLoader cursorLoader;
    private ListView mlistView;
    SimpleCursorAdapter mAdapter;
    private static final String PROVIDER_NAME = "com.example.vinayg.mycontacts.MyContentProvider";
    private static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME);
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab2);

        mlistView = (ListView)findViewById(R.id.vinay_listview);

        mAdapter = new SimpleCursorAdapter(getBaseContext(),
                R.layout.vinay_list,
                null,
                new String[] { "name", "phnumber"},
                new int[] { R.id.name_tv , R.id.ph_tv }, 0);
        mlistView.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(1, null, this);


    }

    //gets the data from the SQLite database.
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {  //Log.d(TAG,"called onCreateLoader");
        cursorLoader= new CursorLoader(getApplicationContext(), CONTENT_URI, null, null, null, null);
        return  cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        //Log.d("onload",""+data.getString(0));
        mAdapter.swapCursor((Cursor) data);
    }



    @Override//if loader is changed
    public void onLoaderReset(Loader loader) { //Log.d(TAG,"called onLoadFinished");
        mAdapter.swapCursor(null);

    }
}
