package com.example.tallerandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayBandInfoActivity extends AppCompatActivity {

    public ResponseReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_band_info);

        // Get intent started by MainActivity and extract data
        Intent intent = getIntent();
        String band_name = intent.getStringExtra(MainActivity.BAND_NAME);
        String band_origin_year = intent.getStringExtra(MainActivity.ORIGIN_YEAR);

        // Send data to an IntentService
        this.dataToService(band_name, band_origin_year);

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
            TextView textView = (TextView) findViewById(R.id.textView);
            String band_name = intent.getStringExtra(RSSPullService.BAND_NAME);
            String years_active = intent.getStringExtra(RSSPullService.YEARS_ACTIVE);
            textView.setText(band_name + " has been active for " + years_active + " years");
        }
    }

    public void dataToService(String band_name, String band_origin_year) {
        // Send data to IntentService
        Intent intentService = new Intent(this, RSSPullService.class);
        intentService.putExtra(RSSPullService.BAND_NAME, band_name);
        intentService.putExtra(RSSPullService.ORIGIN_YEAR, band_origin_year);
        //Start the IntentService and send band's name and origin year
        startService(intentService);
    }

}
