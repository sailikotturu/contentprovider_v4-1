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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentTab3 extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private ListView manasa_lv;
    CursorLoader cursorLoader;
    SimpleCursorAdapter mAdapter;
    private static final String PROVIDER_NAME = "androidcontentproviderdemo.androidcontentprovider.reminders";
    private static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME);

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab3);
        manasa_lv = (ListView)findViewById(R.id.manasa_listview);


        mAdapter = new SimpleCursorAdapter(getBaseContext(),
                R.layout.manasa_list,
                null,
                new String[] { "tasknamecolumn", "tasktimecolumn"},
                new int[] { R.id.event_tv , R.id.time_tv }, 0);
        manasa_lv.setAdapter(mAdapter);// populates the ListView.

        getSupportLoaderManager().initLoader(1, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {  //Log.d(TAG,"called onCreateLoader");
        cursorLoader= new CursorLoader(getApplicationContext(), CONTENT_URI, null, null, null, null);
        return  cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor((Cursor) data);
    }

    @Override//if loader is changed
    public void onLoaderReset(Loader loader) {
        mAdapter.swapCursor(null);

    }


}
