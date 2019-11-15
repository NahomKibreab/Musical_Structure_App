package com.nknahom.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songs = new ArrayList<>();
        songs.add(new Song("Deliver Me","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Two","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Three","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Four","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Five","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Six","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Seven","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Eight","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Nine","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Ten","Donald Lawrence",R.drawable.deliver_me));

        SongAdapter songAdapter = new SongAdapter(this,songs);

        GridView gridView = findViewById(R.id.song_list);
        gridView.setAdapter(songAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) parent.getItemAtPosition(position);
                String song_title = song.getSong_title();
                String artist_name = song.getSong_artist();
                int imageID = song.getmImageResourceId();

                Intent intent = new Intent(MainActivity.this, Detail_Song.class);
                intent.putExtra("SONG_TITLE", song_title);
                intent.putExtra("ARTIST_NAME", artist_name);
                intent.putExtra("SONG_THUMBNAIL", imageID);
                intent.putExtra("CURRENT_SONG", position);
                intent.putParcelableArrayListExtra("songs", songs);
                startActivity(intent);
            }
        });
    }

}
