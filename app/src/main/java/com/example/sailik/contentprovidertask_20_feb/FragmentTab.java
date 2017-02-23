package com.example.sailik.contentprovidertask_20_feb;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentTab extends AppCompatActivity implements View.OnClickListener{


    //private List<Music> musicList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MusicAdapter mAdapter;
    private FloatingActionButton mfabButton;
    DbHelper dbHelper;
//    String albumname;
//    String trackname;
//    Intent intent;
//    int flag =0;
    ItemTouchHelperAdapter ad;
    ArrayList<Music> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab);
        mfabButton = (FloatingActionButton)findViewById(R.id.fab);
        mfabButton.setOnClickListener(this);

        dbHelper = new DbHelper(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

    }

    @Override
    protected void onResume(){
        super.onResume();

        dbHelper = new DbHelper(this);

        final Cursor cursor;


        if(dbHelper.getAllMusicItems()==null) {

        }
        else {
            cursor = dbHelper.getAllMusicItems();
            al = new ArrayList<Music>();
            Music obj;
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                if(cursor.getString(0)==""){
                    continue;
                }
                obj = new Music(cursor.getString(1), cursor.getString(2),Integer.parseInt(cursor.getString(0)));
//                obj.setAlbumName(cursor.getString(1));
//                obj.setTrackName(cursor.getString(2));
                al.add(obj);
            }
            MusicAdapter adapt = new MusicAdapter(al,dbHelper);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapt);


            ItemTouchHelper.Callback callback = new MusicTouchHelper(adapt,dbHelper,al);
            ItemTouchHelper helper = new ItemTouchHelper(callback);
            helper.attachToRecyclerView(recyclerView);
        }

    }
    public void onDelete(){
        //onStart();
        //onResume();
    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fab:
                Intent i = new Intent(FragmentTab.this,AddItem.class);
                startActivity(i);
                break;
        }
    }
}
