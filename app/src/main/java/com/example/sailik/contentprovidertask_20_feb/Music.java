package com.example.sailik.contentprovidertask_20_feb;

/**
 * Created by saili.k on 20-02-2017.
 */

public class Music {

    private String albumName,trackName;
    int id;

    public Music() {
    }

    public Music(String albumName, String trackName,int id) {
        this.albumName = albumName;
        this.trackName = trackName;
        this.id =id;

    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String name) {
        this.albumName = name;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String name) {
        this.trackName = name;
    }

    public int getId(){
        return id;
    }


}
