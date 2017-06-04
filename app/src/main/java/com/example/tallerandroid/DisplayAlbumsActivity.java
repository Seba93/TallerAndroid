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
        double band_id = Double.valueOf(intent.getStringExtra(DisplayBandInfoActivity.BAND_ID));
        ArrayList<Album> bandAlbums = Band.getBandAlbums(band_id);

        // Display albums on layout
        // TextView[] textViewAlbums = new TextView[bandAlbums.size()];
        TextView textViewAlbumName;
        TextView textViewReleaseYear;
        TextView textViewEmpty;
        LinearLayout albumsLayout = (LinearLayout) this.findViewById(R.id.AlbumsLayout);

        for (int i = 0; i < bandAlbums.size(); i++) {
            textViewAlbumName = new TextView(this);
            textViewReleaseYear = new TextView(this);
            textViewEmpty = new TextView(this);
            textViewAlbumName.setText("Album Name: " + bandAlbums.get(i).getAlbumName());
            textViewReleaseYear.setText("Release Date: " + bandAlbums.get(i).getAlbumReleaseDate());
            albumsLayout.addView(textViewAlbumName);
            albumsLayout.addView(textViewReleaseYear);
            albumsLayout.addView(textViewEmpty);
        }
    }
}
