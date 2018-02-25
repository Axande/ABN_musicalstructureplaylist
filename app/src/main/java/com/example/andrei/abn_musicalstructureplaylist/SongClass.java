package com.example.andrei.abn_musicalstructureplaylist;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Andrei on 2/25/2018.
 */

public class SongClass{
    private String title = "";
    private String artist = "";
    private int length = 0;
    private int artId = 0;
    private boolean favorite = false;

    public SongClass(String t, String a, int art, int lg, boolean f){
        this.title = t;
        this.artist = a;
        this.artId = art;
        this.length = lg;
        this.favorite = f;
    }

    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public int getArt(){
        return artId;
    }

    public int getDuration(){
        return length;
    }

    public boolean isFavorite(){
        return favorite;
    }

    public void updateFavorite(){
        favorite = !favorite;
    }

}
