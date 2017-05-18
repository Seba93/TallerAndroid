package com.example.tallerandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.example.tallerandroid.Album;

/**
 * Created by seba on 17-05-17.
 */

@Table(name="Song")
public class Song extends Model {

    @Column(name = "SongName")
    public String songName;

    @Column(name = "Album")
    public Album album;

    public Song() {
        super();
    }

    public Song(String songName, Album album) {
        this.songName = songName;
        this.album = album;
    }
}
