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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Andrei on 2/25/2018.
 */

public class PlaylistActivity extends AppCompatActivity {

    private ListView mPlaylistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        generatePlaylist();

        setListeners();
    }

    private void generatePlaylist(){
        LinearLayout et = findViewById(R.id.search_artist);
        et.setVisibility(View.GONE);

        SongAdapter mAdapter = new SongAdapter(getApplicationContext(), MainActivity.allSongs);

        mPlaylistView = findViewById(R.id.playlistList);

        mPlaylistView.setAdapter(mAdapter);
    }

    private void setListeners(){
        ImageView im = findViewById(R.id.back_arrow);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaylistActivity.super.onBackPressed();
            }
        });

        mPlaylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SongClass item = (SongClass) parent.getItemAtPosition(position);

//                Toast.makeText(getApplicationContext(),String.valueOf(position) , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), SongActivity.class);
                intent.putExtra("object_code", String.valueOf(item));
                startActivity(intent);
            }
        });

    }
}
