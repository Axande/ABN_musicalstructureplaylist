package com.example.andrei.abn_musicalstructureplaylist;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Andrei on 2/25/2018.
 */

public class SongActivity extends AppCompatActivity {

    private SongClass myElement = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_display);

        updateView();
        setListeners();
    }

    private void updateView(){
        Intent intent = getIntent();
        String code = intent.getStringExtra("object_code");

        ArrayList<SongClass> mList = MainActivity.allSongs;
        int lg = mList.size();
        for(int i = 0 ; i < lg; i++){
            if(String.valueOf(mList.get(i)).compareTo(code) == 0){
                myElement = mList.get(i);
            }
        }
        //the intent was solved

        TextView mTitle = findViewById(R.id.song_display_title);
        mTitle.setText(myElement.getTitle());

        TextView mArtist = findViewById(R.id.song_display_artist);
        mArtist.setText(myElement.getArtist());

        TextView mDuration = findViewById(R.id.song_display_duration);
        mDuration.setText(String.valueOf(myElement.getDuration()));

        ImageView mArt = findViewById(R.id.song_display_art);
        mArt.setImageResource(myElement.getArt());

        ImageView mFav = findViewById(R.id.song_display_favorite);
        if(myElement.isFavorite()) mFav.setImageResource(R.drawable.ic_favorite_black_48dp);
        else mFav.setImageResource(R.drawable.ic_favorite_border_black_48dp);
    }

    private void triggerFavorite(){
        myElement.updateFavorite();
        updateView();
    }

    private void setListeners(){
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
