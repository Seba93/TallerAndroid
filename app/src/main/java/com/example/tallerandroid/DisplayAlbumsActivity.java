package com.example.tallerandroid;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayAlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_albums);

        // Get albums of selected band
        Intent intent = getIntent();
        Long bandId = Long.valueOf(intent.getStringExtra(DisplayBandInfoActivity.BAND_ID));
        ArrayList<Album> bandAlbums = Band.getBandAlbums(bandId);

        // Display albums on layout
        TextView textViewAlbumName;
        TextView textViewReleaseYear;
        TextView textViewSong;
        LinearLayout albumsLayout = (LinearLayout) this.findViewById(R.id.AlbumsLayout);
        // ArrayList<Song> albumTracklist;

        for (int i = 0; i < bandAlbums.size(); i++) {
            // Display album name and release year
            textViewAlbumName = new TextView(this);
            textViewReleaseYear = new TextView(this);
            textViewAlbumName.setText("Album Name: " + bandAlbums.get(i).getAlbumName());
            textViewReleaseYear.setText("Release Date: " + bandAlbums.get(i).getAlbumReleaseDate());
            albumsLayout.addView(textViewAlbumName);
            albumsLayout.addView(textViewReleaseYear);
            albumsLayout.addView(new TextView(this));

            // Display album tracklist
            Album album = bandAlbums.get(i);
            ArrayList<Song> albumTracklist = Album.getAlbumSongs(album.getAlbumName());
            for (int j = 0; j < albumTracklist.size(); j++) {
                textViewSong = new TextView(this);
                textViewSong.setText("    " +
                                     String.valueOf(albumTracklist.get(j).getTrackNumber()) +
                                     ". " +
                                     albumTracklist.get(j).getSongName());
                albumsLayout.addView(textViewSong);
            }

            albumsLayout.addView(new TextView(this));
        }
    }
}