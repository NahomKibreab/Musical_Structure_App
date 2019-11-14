package com.nknahom.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Deliver Me","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Deliver Me","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Deliver Me","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Deliver Me","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Deliver Me","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Deliver Me","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Deliver Me","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Deliver Me","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Deliver Me","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Deliver Me","Donald Lawrence",R.drawable.deliver_me));

        SongAdapter songAdapter = new SongAdapter(this,songs);

        GridView gridView = findViewById(R.id.song_list);
        gridView.setAdapter(songAdapter);
    }
}
