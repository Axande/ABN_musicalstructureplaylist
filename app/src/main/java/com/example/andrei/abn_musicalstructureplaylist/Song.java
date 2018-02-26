package com.example.andrei.abn_musicalstructureplaylist;

/**
 * Created by Andrei on 2/25/2018.
 */

public class Song {
    private String title = "";          //the title of the current song
    private String artist = "";         //the artist of the current song
    private int length = 0;             //the duration of the song
    private int artId = 0;              //the id of the art of the song
    private boolean favorite = false;   //mark if the song is favorite

    public Song(String t, String a, int art, int lg, boolean f) {
        this.title = t;
        this.artist = a;
        this.artId = art;
        this.length = lg;
        this.favorite = f;
    }

    /**
     * @return the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the artist of the song
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @return the id of the art of the song
     */
    public int getArt() {
        return artId;
    }

    /**
     * @return the duration of the song
     */
    public int getDuration() {
        return length;
    }

    /**
     * @return true if the song is a favorite, false otherwise
     */
    public boolean isFavorite() {
        return favorite;
    }

    /**
     * Change the favorite status of the song.
     */
    public void updateFavorite() {
        favorite = !favorite;
    }

}
