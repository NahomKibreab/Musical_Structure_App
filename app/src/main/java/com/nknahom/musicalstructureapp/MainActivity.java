package com.nknahom.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Array list of songs
    private ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songs = new ArrayList<>();
        songs.add(new Song("Deliver Me","Donald Lawrence",R.drawable.deliver_me));
        songs.add(new Song("Made a Way","Travis Greene",R.drawable.made_a_way));
        songs.add(new Song("Break Every Chain","Tasha Cobbs",R.drawable.break_every_chain));
        songs.add(new Song("Love Theory","Kirk Franklin",R.drawable.love_theory));
        songs.add(new Song("Never Alone","Tori Kelly",R.drawable.never_alone));
        songs.add(new Song("I'm All In","Maranda Curtis",R.drawable.i_am_all_in));
        songs.add(new Song("Mighty God","Joe Praize",R.drawable.wha_a_mighty_god));
        songs.add(new Song("I Smile","Kirk Franklin",R.drawable.i_smile));
        songs.add(new Song("As We Worship You","Don Moen",R.drawable.don_moen));
        songs.add(new Song("God Is Able","Smokie Norful",R.drawable.god_is_able));

        SongAdapter songAdapter = new SongAdapter(this,songs);

        GridView gridView = findViewById(R.id.song_list);
        gridView.setAdapter(songAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Detail_Song.class);
                intent.putExtra("CURRENT_SONG", position);
                intent.putParcelableArrayListExtra("songs", songs);
                startActivity(intent);
            }
        });
    }

}
