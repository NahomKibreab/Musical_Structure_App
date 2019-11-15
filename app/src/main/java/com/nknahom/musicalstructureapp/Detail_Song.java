package com.nknahom.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Detail_Song extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Song> mySongs;
    private int position;
    Button previousButton;
    Button nextButton;
    Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__song);

        previousButton = findViewById(R.id.previous_song);
        previousButton.setOnClickListener(this);

        nextButton = findViewById(R.id.next_song);
        nextButton.setOnClickListener(this);

        playButton = findViewById(R.id.play_song);
        playButton.setOnClickListener(this);

        position = getIntent().getIntExtra("CURRENT_SONG",0);
        playSong(position);

        if (position == 0){
            previousButton.setEnabled(false);
        }

        if (position == mySongs.size() - 1){
            nextButton.setEnabled(false);
        }

    }

    private String playSong(int position){
        mySongs = getIntent().getParcelableArrayListExtra("songs");
        Song song = mySongs.get(position);

        TextView song_title = findViewById(R.id.song_title);
        song_title.setText(song.getSong_title());


        TextView artist_name = findViewById(R.id.song_artist);
        artist_name.setText(song.getSong_artist());

        ImageView song_thumbnail = findViewById(R.id.song_thumbnail);
        song_thumbnail.setImageResource(song.getmImageResourceId());
        return song.getSong_title();
    }

    private void checkButton (int position){
        if (position == 0){
            previousButton.setEnabled(false);
            nextButton.setEnabled(true);
        }

        if (position == mySongs.size() -1){
            previousButton.setEnabled(true);
            nextButton.setEnabled(false);
        }

        if (position > 0 && position < mySongs.size() - 1){
            previousButton.setEnabled(true);
            nextButton.setEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.previous_song:
                playSong(position -= 1);
                checkButton(position);
                break;
            case R.id.play_song:
                Toast.makeText(this,playSong(position),Toast.LENGTH_LONG).show();
                break;
            case R.id.next_song:
                playSong(position += 1);
                checkButton(position);
                break;
        }
    }
}
