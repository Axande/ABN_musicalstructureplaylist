package com.example.andrei.abn_musicalstructureplaylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andrei on 2/25/2018.
 * <p>
 * The class for displaying a song with all its details
 */

public class SongActivity extends AppCompatActivity {

    private Song myElement = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_display);

        updateView();
        setListeners();
    }

    /**
     * Method which will update all the details on the activity_song_display.xml view.
     */
    private void updateView() {
        Intent intent = getIntent();
        String code = intent.getStringExtra("object_code");

        //get the right song from all list by using the intent received
        ArrayList<Song> mList = MainActivity.allSongs;
        int lg = mList.size();
        for (int i = 0; i < lg; i++) {
            if (String.valueOf(mList.get(i)).compareTo(code) == 0) {
                myElement = mList.get(i);
            }
        }

        //update all fields according to the details hold in Song about this specific song
        TextView mTitle = findViewById(R.id.song_display_title);
        mTitle.setText(myElement.getTitle());

        TextView mArtist = findViewById(R.id.song_display_artist);
        mArtist.setText(myElement.getArtist());

        TextView mDuration = findViewById(R.id.song_display_duration);
        mDuration.setText(String.valueOf(myElement.getDuration()));

        ImageView mArt = findViewById(R.id.song_display_art);
        mArt.setImageResource(myElement.getArt());

        ImageView mFav = findViewById(R.id.song_display_favorite);
        if (myElement.isFavorite()) mFav.setImageResource(R.drawable.ic_favorite_black_48dp);
        else mFav.setImageResource(R.drawable.ic_favorite_border_black_48dp);
    }

    /**
     * When favorite button is pressed, it's state is changed.
     */
    private void triggerFavorite() {
        myElement.updateFavorite();
        updateView();
    }

    /**
     * Set all the listeners for this content view.
     */
    private void setListeners() {
        ImageView im = findViewById(R.id.back_arrow);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SongActivity.super.onBackPressed();
            }
        });

        ImageView mFav = findViewById(R.id.song_display_favorite);
        mFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerFavorite();
            }
        });
    }
}
