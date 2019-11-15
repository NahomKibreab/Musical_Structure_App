package com.nknahom.musicalstructureapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {

    private String song_title;
    private String song_artist;
    private int mImageResourceId;

    public Song(String song_title, String song_artist, int mImageResourceId) {
        this.song_title = song_title;
        this.song_artist = song_artist;
        this.mImageResourceId = mImageResourceId;
    }

    protected Song(Parcel in) {
        song_title = in.readString();
        song_artist = in.readString();
        mImageResourceId = in.readInt();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public String getSong_title() {
        return song_title;
    }

    public String getSong_artist() {
        return song_artist;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(song_title);
        dest.writeString(song_artist);
        dest.writeInt(mImageResourceId);
    }
}
