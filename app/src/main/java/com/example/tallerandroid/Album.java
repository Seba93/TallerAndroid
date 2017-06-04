package com.example.tallerandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.example.tallerandroid.Band;

/**
 * Created by seba on 17-05-17.
 */

@Table(name="Album")
public class Album extends Model {

    @Column(name = "AlbumName")
    private String albumName;

    @Column(name = "Band")
    private Band band;

    @Column(name = "ReleaseDate")
    private int albumReleaseDate;

    public Album() {
        super();
    }

    public Album(String albumName, Band band, int albumReleaseDate) {
        this.albumName = albumName;
        this.band = band;
        this.albumReleaseDate = albumReleaseDate;
        this.save();
    }
}