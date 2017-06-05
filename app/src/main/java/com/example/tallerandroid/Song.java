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
    private String songName;

    @Column(name = "Album")
    private Album album;

    @Column(name = "TrackNumber")
    private int trackNumber;

    public Song() {
        super();
    }

    public Song(String songName, Album album, int trackNumber) {
        this.songName = songName;
        this.album = album;
        this.trackNumber = trackNumber;
        this.save();
    }

    public void doNothing() {

    }

    public String getSongName() {
        return this.songName;
    }

    public int getTrackNumber() {
        return this.trackNumber;
    }
}
