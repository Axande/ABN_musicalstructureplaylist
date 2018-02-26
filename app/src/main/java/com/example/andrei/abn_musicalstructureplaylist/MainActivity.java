package com.example.andrei.abn_musicalstructureplaylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/*
 ICONS taken from https://material.io/icons/#ic_search
 Dummy img: http://www.openculture.com/2014/07/the-art-of-mapping-music.html
 */

public class MainActivity extends AppCompatActivity {

    //a public array with all the songs. Can be accessed from any other class.
    public static ArrayList<Song> allSongs = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSongs();
        addListeners();
    }

    /**
     * Add random generated songs to the list of songs.
     */
    private void addSongs() {
        for (int i = 0; i <= 100; i++) {
            allSongs.add(new Song("Song number " + i, getRandomArtist()
                    , R.drawable.dummy_img, getRandomInt(100), getRandomBool()));
        }
    }

    /**
     * Generate a random artist from a given list.
     *
     * @return one of the artists
     */
    private String getRandomArtist() {
        ArrayList<String> mList = new ArrayList<String>();
        mList.add("best");
        mList.add("ab");
        mList.add("one");
        mList.add("artist 1");
        mList.add("nobody");

        double val = Math.random();
        val *= 10;
        val /= 6;
        return mList.get((int) val);
    }

    /**
     * Generate a random bool variable
     *
     * @return true or false
     */
    private boolean getRandomBool() {
        double val = Math.random();
        val *= 10;
        val = (int) val;
        if (val % 2 == 0) return false;
        return true;
    }

    /**
     * Generate an int of maximum maxVal value.
     *
     * @param maxVal is the maximum value an element can have
     * @return a random integer
     */
    private int getRandomInt(int maxVal) {
        double val = Math.random();
        val *= (maxVal + 1);
        return (int) val + 1;
    }

    /**
     * Set all the listeners for the current content view.
     */
    private void addListeners() {
        TextView twAllSongs = findViewById(R.id.all_songs_activity);
        TextView twArtist = findViewById(R.id.artist_activity);
        TextView twFavorites = findViewById(R.id.favorites_activity);

        //add listener for the all songs button
        twAllSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(intent);
            }
        });

        //add listener for search by artist
        twArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(intent);
            }
        });

        //add listener for the favorites button
        twFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
                startActivity(intent);
            }
        });
    }
}
