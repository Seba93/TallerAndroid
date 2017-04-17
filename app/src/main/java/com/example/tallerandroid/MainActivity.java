package com.example.tallerandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    public static final String BAND_NAME = "com.example.tallerandroid.BAND_NAME";
    public static final String BAND_ORIGIN_YEAR = "com.example.tallerandroid.BAND_ORIGIN_YEAR";

    @Override
    //Create view elements
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // To display info of a given band
    public void searchBand(View view) {
        // Get band name and send data to DisplayBandInfoActivity (Activity)
        Intent intent = new Intent(this, DisplayBandInfoActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String band_name = editText.getText().toString();
        intent.putExtra(BAND_NAME, band_name);
        startActivity(intent);

        // Get band origin year and send data to RSSPullService (IntentService)
        Intent mServiceIntent = new Intent(this, RSSPullService.class);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String band_origin_year = editText2.getText().toString();
        intent.putExtra(BAND_ORIGIN_YEAR, band_origin_year);

        //Start the IntentService and send band origin year
        this.startService(mServiceIntent);
    }

    @Override
    protected void onPause() {super.onPause();}

    @Override
    protected void onResume() {super.onResume();}
}