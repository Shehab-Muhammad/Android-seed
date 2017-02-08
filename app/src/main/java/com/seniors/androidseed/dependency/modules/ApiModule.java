package com.seniors.androidseed.dependency.modules;

import com.seniors.androidseed.data.Api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by shehab-develop on 02/02/17.
 */

@Module(includes = ClientModule.class)
public class ApiModule {

    @Provides
    @Singleton
    public Api getApi(OkHttpClient http){
        return Api.Creator.create(http);
    }

}
