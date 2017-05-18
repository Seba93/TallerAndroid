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
    public String albumName;

    @Column(name = "com.example.tallerandroid.Band")
    public Band band;

    public Album() {
        super();
    }

    public Album(String albumName, Band band) {
        this.albumName = albumName;
        this.band = band;
    }
}