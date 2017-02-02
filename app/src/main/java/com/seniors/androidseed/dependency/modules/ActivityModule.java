package com.seniors.androidseed.dependency.modules;

import android.app.Activity;

import com.seniors.androidseed.dependency.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shehab-develop on 02/02/17.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Activity getActivity(){
        return activity;
    }
}
