package com.example.tallerandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayBandInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_band_info);

        //Get main activity intent and store band info
        Intent intent = getIntent();
        String band_name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Modify layout
        TextView textView = (TextView) findViewById(R.id.textView6);
        textView.setText("Info about the band " + band_name + " will be displayed here soon");
    }
}
