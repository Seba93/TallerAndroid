package com.example.tallerandroid;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import java.util.Calendar;

/**
 * Created by seba on 17-04-17.
 */

public class RSSPullService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

    public static final String BAND_NAME = "com.example.tallerandroid.BAND_NAME";
    public static final String ORIGIN_YEAR = "com.example.tallerandroid.ORIGIN_YEAR";
    public static final String YEARS_ACTIVE = "com.example.tallerandroid.YEARS_ACTIVE";

    public RSSPullService() {
        super("RSSPullService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Gets data from the incoming Intent (band's name and origin year)
        String band_name = intent.getStringExtra(BAND_NAME);
        int origin_year = Integer.parseInt(intent.getStringExtra(ORIGIN_YEAR));
        // Calculate the number of years that the band is active
        int actual_year = Calendar.getInstance().get(Calendar.YEAR);
        String years_active = String.valueOf(actual_year - origin_year);

        // Send band_name and years_active back to DisplayBandInfoActivity through a broadcast
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(DisplayBandInfoActivity.ResponseReceiver.DATA_PROCESSED);
        broadcastIntent.putExtra(BAND_NAME, band_name);
        broadcastIntent.putExtra(YEARS_ACTIVE, years_active);
        sendBroadcast(broadcastIntent);
    }
}