package com.xyz.searchsample;

import android.app.Application;

/**
 * Application class for this sample.
 */

public class SearchApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CityDataCache.init(getApplicationContext());
    }
}
