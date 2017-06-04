package com.example.tallerandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayBandInfoActivity extends AppCompatActivity {

    public ResponseReceiver receiver;
    public static final String BAND_ID = "com.example.tallerandroid.BAND_ID";
    String band_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_band_info);

        // Get intent started by MainActivity and extract data
        Intent intent = getIntent();
        this.band_id = intent.getStringExtra(MainActivity.BAND_ID);
        String band_name = intent.getStringExtra(MainActivity.BAND_NAME);
        String band_country = intent.getStringExtra(MainActivity.BAND_COUNTRY);
        String band_genre = intent.getStringExtra(MainActivity.BAND_GENRE);
        String band_origin_year = intent.getStringExtra(MainActivity.ORIGIN_YEAR);

        // Set Text Views
        TextView textViewName = (TextView) findViewById(R.id.textViewName);
        textViewName.setText("Band: " + band_name);
        TextView textViewCountry = (TextView) findViewById(R.id.textViewCountry);
        textViewCountry.setText("Country: " + band_country);
        TextView textViewGenre = (TextView) findViewById(R.id.textViewGenre);
        textViewGenre.setText("Genre: " + band_genre);
        TextView textViewOriginYear = (TextView) findViewById(R.id.textViewOriginYear);
        textViewOriginYear.setText("Origin Year: " + band_origin_year);

        // Send data to an IntentService
        this.dataToService(band_origin_year);

        // Register the broadcast receiver through a filter
        IntentFilter filter = new IntentFilter(ResponseReceiver.DATA_PROCESSED);
        receiver = new ResponseReceiver();
        registerReceiver(receiver, filter);
    }

    public class ResponseReceiver extends BroadcastReceiver {

        public static final String DATA_PROCESSED = "com.example.tallerandroid.intent.action.MESSAGE_PROCESSED";

        //Prevents instantiation
        private ResponseReceiver() {}

        // Called when the BroadcastReceiver gets an Intent it's registered to receive
        @Override
        public void onReceive(Context context, Intent intent) {

            //Modify DisplayBandInfoActivity layout to display band data
            TextView textViewYearsActive = (TextView) findViewById(R.id.textViewYearsActive);
            String years_active = intent.getStringExtra(RSSPullService.YEARS_ACTIVE);
            textViewYearsActive.setText("Years Active: " + years_active + " years");
        }
    }

    public void dataToService(String band_origin_year) {
        // Send data to IntentService
        Intent intentService = new Intent(this, RSSPullService.class);
        intentService.putExtra(RSSPullService.ORIGIN_YEAR, band_origin_year);
        //Start the IntentService and send band's origin year
        startService(intentService);
    }

    // To view albums of a given bandS
    public void viewAlbums(View view) {
        Intent intent = new Intent(this, DisplayAlbumsActivity.class);
        intent.putExtra(BAND_ID, band_id);
        startActivity(intent);
    }
}