package com.example.sailik.contentprovidertask_20_feb;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by saili.k on 22-02-2017.
 */

public class MusicTouchHelper extends ItemTouchHelper.Callback {

    private MusicAdapter mMusicAdapter;
    private DbHelper mDbObj;
    private ArrayList<Music> musicList;
    private int direction;

    public MusicTouchHelper(MusicAdapter musicAdapter, DbHelper db, ArrayList<Music> musicList){

        this.mMusicAdapter = musicAdapter;
        this.mDbObj = db;
        this.musicList = musicList;

    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

//    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source,
                          RecyclerView.ViewHolder target) {

        return false;

    }
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        mMusicAdapter.onItemDismiss(viewHolder.getAdapterPosition());
        mMusicAdapter.remove(viewHolder.getAdapterPosition());

    }

}
