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

    public static final String YEARS_ACTIVE = "com.example.tallerandroid.YEARS_ACTIVE";

    public RSSPullService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        // Gets data from the incoming Intent (band origin year)
        int origin_year = Integer.parseInt(workIntent.getDataString());
        // Calculate the number of years that the band is active
        int actual_year = Calendar.getInstance().get(Calendar.YEAR);
        String years_active = String.valueOf(actual_year - origin_year);

        // Send years_active to DisplayBandInfoActivity
        Intent localIntent = new Intent();
        localIntent.putExtra(YEARS_ACTIVE, years_active);
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);

    }
}
