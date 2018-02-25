package com.example.andrei.abn_musicalstructureplaylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;


/*
 ICONS taken from https://material.io/icons/#ic_search
 Dummy img: http://www.openculture.com/2014/07/the-art-of-mapping-music.html
 */

public class MainActivity extends AppCompatActivity {

    public static ArrayList<SongClass> allSongs = new ArrayList<SongClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSongs();
        addListeners();
    }

    private void addSongs(){
        for(int i = 0; i <= 100; i++){
            allSongs.add(new SongClass("Song number " + i, getRandomArtist()
                    , R.drawable.dummy_img, getRandomInt(100), getRandomBool()));
        }
    }

    private String getRandomArtist(){
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

    private boolean getRandomBool(){
        double val = Math.random();
        val *= 10;
        val = (int) val;
        if(val % 2 == 0) return false;
        return true;
    }

    private int getRandomInt(int maxVal){
        double val = Math.random();
        val *= (maxVal+1);
        return (int)val+1;
    }

    private void addListeners(){
        TextView twAllSongs = findViewById(R.id.allSongsActivity);
        TextView twArtist = findViewById(R.id.artistActivity);
        TextView twFavorites = findViewById(R.id.favoritesActivity);

        twAllSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(intent);
            }
        });

        twArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(intent);
            }
        });

        twFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
                startActivity(intent);
            }
        });
    }
}
