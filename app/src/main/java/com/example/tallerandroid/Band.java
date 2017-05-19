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
    public String bandName;

    @Column(name = "Country")
    public Country country;

    @Column(name = "Genre")
    public Genre genre;

    @Column(name = "OriginYear")
    public int originYear;

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

    public static ArrayList<Band> getAll() {
        return new Select()
                .from(Band.class)
                .orderBy("BandName")
                .execute();
    }
}