package com.example.tallerandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.ArrayList;

/**
 * Created by seba on 17-05-17.
 */

@Table(name="Band")
public class Band extends Model {

    @Column(name = "BandName")
    private String bandName;

    @Column(name = "Country")
    private Country country;

    @Column(name = "Genre")
    private Genre genre;

    @Column(name = "OriginYear")
    private int originYear;

    public Band() {
        super();
    }

    public Band(String bandName, Country country, Genre genre, int originYear) {
        super();
        this.bandName = bandName;
        this.country = country;
        this.genre = genre;
        this.originYear = originYear;
        this.save();
    }

    public String getBandName() {
        return this.bandName;
    }

    public int getOriginYear() {return this.originYear;}

    public Country getCountry() {return this.country;}

    public Genre getGenre() {return this.genre;}

    public static ArrayList<Band> getAll() {
        return new Select()
                .from(Band.class)
                .orderBy("BandName")
                .execute();
    }

    public static ArrayList<Album> getBandAlbums(double band_id) {
        return new Select()
                .from(Album.class)
                .join(Band.class)
                .on("Band.Id = Album.Band")
                .where("Band.Id = ?", band_id)
                .orderBy("Album.ReleaseDate")
                .execute();
    }

    @Override
    public String toString() {
        return this.bandName;
    }
}