package com.example.andrei.abn_musicalstructureplaylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andrei on 2/25/2018.
 *
 * Class related to the artist activity.
 */

public class ArtistActivity extends AppCompatActivity {

    private ListView mPlaylistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        generatePlaylist();
        setListeners();

        TextView title = findViewById(R.id.current_activity_title);
        title.setText(R.string.title_artist);
    }

    /**
     * Create a playlist for the artist activity
     */
    private void generatePlaylist(){

        ArrayList<Song> mPlaylist = new ArrayList<Song>();
        ArrayList<Song> mAllSongs = MainActivity.allSongs;

        LinearLayout mLinearLayout = findViewById(R.id.search_artist);
        mLinearLayout.setVisibility(View.VISIBLE);

        EditText et = (EditText) mLinearLayout.getChildAt(0);
        String searchKey = String.valueOf(et.getText());

        //select the right songs
        for(int i = 0; i < mAllSongs.size(); i++){
            if(mAllSongs.get(i).getArtist().toLowerCase().trim()
                    .compareTo(searchKey.toLowerCase().trim()) == 0) {
                mPlaylist.add(mAllSongs.get(i));
            }
        }

        //attach the songs through SongAdapter to the list view
        SongAdapter mAdapter = new SongAdapter(getApplicationContext(), mPlaylist);

        mPlaylistView = findViewById(R.id.playlist_list);

        mPlaylistView.setAdapter(mAdapter);
    }

    /**
     * Set all the listeners for the current content view.
     */
    private void setListeners(){
        ImageView btnSearch = findViewById(R.id.search_btn);

        //set the listener for the search button
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePlaylist();
            }
        });

        ImageView im = findViewById(R.id.back_arrow);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArtistActivity.super.onBackPressed();
            }
        });

        //set the listener for the back button
        mPlaylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the current song
                Song item = (Song) parent.getItemAtPosition(position);
                //create an intent
                Intent intent = new Intent(getApplicationContext(), SongActivity.class);
                //attach the object's memory address as a string to the intent
                intent.putExtra("object_code", String.valueOf(item));
                //start the intent
                startActivity(intent);
            }
        });
    }
}
