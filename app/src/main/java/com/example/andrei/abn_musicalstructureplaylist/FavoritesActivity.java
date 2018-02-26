package com.example.andrei.abn_musicalstructureplaylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andrei on 2/25/2018.
 */

public class FavoritesActivity extends AppCompatActivity {

    private ListView mPlaylistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        generatePlaylist();
        setListeners();

        TextView title = findViewById(R.id.current_activity_title);
        title.setText(R.string.title_favorites);
    }

    /**
     * Create a playlist for the favorites activity
     */
    private void generatePlaylist() {
        LinearLayout et = findViewById(R.id.search_artist);
        et.setVisibility(View.GONE);

        //select the songs
        ArrayList<Song> mAllSongs = MainActivity.allSongs;
        ArrayList<Song> mPlaylist = new ArrayList<Song>();
        for (int i = 0; i < mAllSongs.size(); i++) {
            if (mAllSongs.get(i).isFavorite()) {
                mPlaylist.add(mAllSongs.get(i));
            }
        }

        //add the song to the list view
        SongAdapter mAdapter = new SongAdapter(getApplicationContext(), mPlaylist);

        mPlaylistView = findViewById(R.id.playlist_list);

        mPlaylistView.setAdapter(mAdapter);
    }

    /**
     * Set all the listeners for the current content view.
     */
    private void setListeners() {
        ImageView im = findViewById(R.id.back_arrow);
        //add listener for the back button
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavoritesActivity.super.onBackPressed();
            }
        });

        //add listener for the list view to determine the song clicked
        mPlaylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song item = (Song) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), SongActivity.class);
                intent.putExtra("object_code", String.valueOf(item));
                startActivity(intent);
            }
        });
    }
}
