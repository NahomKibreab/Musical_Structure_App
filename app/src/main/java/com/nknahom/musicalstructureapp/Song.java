package com.nknahom.musicalstructureapp;

public class Song {

    private String song_title;
    private String song_artist;
    private int mImageResourceId;

    public Song(String song_title, String song_artist, int mImageResourceId) {
        this.song_title = song_title;
        this.song_artist = song_artist;
        this.mImageResourceId = mImageResourceId;
    }

    public String getSong_title() {
        return song_title;
    }

    public String getSong_artist() {
        return song_artist;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
}
