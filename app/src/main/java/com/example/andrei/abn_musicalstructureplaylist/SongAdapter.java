package com.example.andrei.abn_musicalstructureplaylist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andrei on 2/25/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(@NonNull Context context, ArrayList<Song> songs) {
        //2nd field is used when populating a single textview
        super(context, 0, songs);
    }

    /**
     * @param position    position of this view in the list of data
     * @param convertView recycled view that needs to be repopulated
     * @param parent      list item will be added to this parent as children.
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Song currentSong = getItem(position);

        View listItem = convertView;
        if (convertView == null) {
            //inflate the list item layout
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //update all details
        ImageView mArt = listItem.findViewById(R.id.item_song_icon);
        mArt.setImageResource(currentSong.getArt());

        TextView mTitle = listItem.findViewById(R.id.item_song_title);
        mTitle.setText(currentSong.getTitle());

        TextView mArtist = listItem.findViewById(R.id.item_song_artist);
        mArtist.setText(currentSong.getArtist());

        //return the created object
        return listItem;
    }
}
