package com.example.sailik.contentprovidertask_20_feb;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saili.k on 21-02-2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> implements ItemTouchHelperAdapter {

    private List<Music> musicList;
    private DbHelper mdbobj;
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        remove(position);
        //Log.d("onswipe",""+position);
        mdbobj.deleteMusicItem(musicList.get(position).getId());
    }

    public void swap(){
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView albumName,trackName;

        public MyViewHolder(View view) {
            super(view);
            albumName = (TextView) view.findViewById(R.id.albumname_tv);
            trackName = (TextView) view.findViewById(R.id.trackname_tv);

        }
    }


    public MusicAdapter(List<Music> musicList,DbHelper mdbobj) {
        this.musicList = musicList;
        this.mdbobj = mdbobj;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.music_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Music music = musicList.get(position);
        holder.albumName.setText(music.getAlbumName());
        holder.trackName.setText(music.getTrackName());

    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public void remove(int position) {
        notifyItemRemoved(position);
        Cursor cursor = mdbobj.getAllMusicItems();
        musicList.clear();
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            if(cursor.getString(0)==""){
                continue;
            }
            Music obj = new Music(cursor.getString(1), cursor.getString(2),Integer.parseInt(cursor.getString(0)));
                obj.setAlbumName(cursor.getString(1));
                obj.setTrackName(cursor.getString(2));
            musicList.add(obj);
        }
        swap();
    }
}
