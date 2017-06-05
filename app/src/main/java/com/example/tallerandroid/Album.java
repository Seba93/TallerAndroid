package com.example.tallerandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.tallerandroid.Band;

import java.util.ArrayList;

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

    public String getAlbumName() {
        return this.albumName;
    }

    public int getAlbumReleaseDate() {
        return this.albumReleaseDate;
    }

    public static ArrayList<Song> getAlbumSongs(String albumName) {

        return new Select()
                .from(Song.class)
                .join(Album.class)
                .on("Album.Id = Song.Album")
                .where("Album.AlbumName = ?", albumName)
                .orderBy("Song.TrackNumber")
                .execute();
    }
}