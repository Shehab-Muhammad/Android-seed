package com.seniors.androidseed.ui;

import android.app.Application;

import com.seniors.androidseed.dependency.components.AppComponent;
import com.seniors.androidseed.dependency.components.DaggerAppComponent;

/**
 * Created by shehab-develop on 01/02/17.
 */

public class SeedApp extends Application {
    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .build();
    }

    public AppComponent component(){
        return appComponent;
    }
}
