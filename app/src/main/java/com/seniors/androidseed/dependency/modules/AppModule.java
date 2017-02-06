package com.seniors.androidseed.dependency.modules;

import android.content.Context;

import com.seniors.androidseed.dependency.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shehab-develop on 07/02/17.
 */

@Module
public class AppModule {
    private final Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @ApplicationScope
    Context getAppContext(){
        return appContext;
    }
}
