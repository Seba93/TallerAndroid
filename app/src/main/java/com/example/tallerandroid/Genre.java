package com.example.tallerandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by seba on 17-05-17.
 */

@Table(name="Genre")
public class Genre extends Model {

    @Column(name = "GenreName")
    public String genreName;

    public Genre() {
        super();
    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }
}
