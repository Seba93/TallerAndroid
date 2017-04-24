package com.example.tallerandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String BAND_NAME = "com.example.tallerandroid.BAND_NAME";
    public static final String ORIGIN_YEAR = "com.example.tallerandroid.ORIGIN_YEAR";

    @Override
    //Create view elements
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // To display info of a given band (Search button method)
    public void searchBand(View view) {
        // Get band's name and origin year and send data to DisplayBandInfoActivity (Activity)
        Intent intent = new Intent(this, DisplayBandInfoActivity.class);
        // Get band name
        EditText editText = (EditText) findViewById(R.id.editText);
        String band_name = editText.getText().toString();
        // Get band origin year
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String band_origin_year = editText2.getText().toString();

        // Send data to DisplayBandInfoActivity
        intent.putExtra(BAND_NAME, band_name);
        intent.putExtra(ORIGIN_YEAR, band_origin_year);
        startActivity(intent);
    }

    @Override
    protected void onPause() {super.onPause();}

    @Override
    protected void onResume() {super.onResume();}
}