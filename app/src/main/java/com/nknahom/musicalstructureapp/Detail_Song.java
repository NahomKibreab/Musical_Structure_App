package com.nknahom.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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

        // When Previous button clicked it'll send you back to the previous index
        previousButton = findViewById(R.id.previous_song);
        previousButton.setOnClickListener(this);

        // When Next button clicked it'll send you to the index
        nextButton = findViewById(R.id.next_song);
        nextButton.setOnClickListener(this);

        // When Play button clicked it'll play the music i.e it'll show text message
        playButton = findViewById(R.id.play_song);
        playButton.setOnClickListener(this);

        // Position value get from the Main Activity base on the user selection
        position = getIntent().getIntExtra("CURRENT_SONG",0);
        playSong(position);

        // If position of the index is zero that means there's no previous button selection
        if (position == 0){
            previousButton.setEnabled(false);
        }

        // If position of the index is equal to the value of last index that means there's no next song
        if (position == mySongs.size() - 1){
            nextButton.setEnabled(false);
        }

    }

    // This method is used for displaying content of song's detail
    private void playSong(int position){
        mySongs = getIntent().getParcelableArrayListExtra("songs");
        Song song = mySongs.get(position);

        TextView song_title = findViewById(R.id.song_title);
        song_title.setText(song.getSong_title());


        TextView artist_name = findViewById(R.id.song_artist);
        artist_name.setText(song.getSong_artist());

        ImageView song_thumbnail = findViewById(R.id.song_thumbnail);
        song_thumbnail.setImageResource(song.getmImageResourceId());
    }

    // CheckButton will enable/disable both previous and next button base of index position
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

    // This method used for the action of the three (Previous, Play/Pause and Next) button when clicked
    @Override
    public void onClick(View v) {
        TextView song_status = findViewById(R.id.song_status);
        switch (v.getId()){
            case R.id.previous_song:
                playSong(position -= 1);
                checkButton(position);
                song_status.setVisibility(View.INVISIBLE);
                playButton.setText("PLAY");
                break;
            case R.id.play_song:
                if (playButton.getText().toString().equalsIgnoreCase("play")){
                    song_status.setVisibility(View.VISIBLE);
                    song_status.setText("Music Playing...");
                    song_status.setBackgroundColor(Color.parseColor("#009688"));
                    playButton.setText("PAUSE");
                } else {
                    song_status.setText("Music Paused");
                    song_status.setBackgroundColor(Color.parseColor("#757575"));
                    playButton.setText("PLAY");
                }

                break;
            case R.id.next_song:
                playSong(position += 1);
                checkButton(position);
                song_status.setVisibility(View.INVISIBLE);
                playButton.setText("PLAY");
                break;
        }
    }
}
