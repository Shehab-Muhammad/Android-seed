package com.seniors.androidseed.dependency.modules;

import com.seniors.androidseed.data.Api;
import com.seniors.androidseed.data.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shehab-develop on 02/02/17.
 */

@Module(includes = ApiModule.class)
public class DataModule {

    @Provides
    @Singleton
    DataManager getDataManager(Api apiService){
        return new DataManager(apiService);
    }
}
