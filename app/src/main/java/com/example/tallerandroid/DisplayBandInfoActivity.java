package com.example.tallerandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayBandInfoActivity extends AppCompatActivity {

    String band_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_band_info);

        //Get main activity intent and store band info
        Intent intent = getIntent();
        band_name = intent.getStringExtra(MainActivity.BAND_NAME);
    }

    class ResponseReceiver extends BroadcastReceiver {

        //Prevents instantiation
        private ResponseReceiver() {}

        // Called when the BroadcastReceiver gets an Intent it's registered to receive
        @Override
        public void onReceive(Context context, Intent intent) {

            //Modify layout
            TextView textView = (TextView) findViewById(R.id.textView6);
            String years_active = intent.getDataString();
            textView.setText(band_name + "has been active for" + years_active + "years");
        }
    }
}
