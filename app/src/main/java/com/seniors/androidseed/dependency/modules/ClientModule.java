package com.seniors.androidseed.dependency.modules;

import com.seniors.androidseed.dependency.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by shehab-develop on 02/02/17.
 */

@Module
public class ClientModule {
    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor getLogger(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @ApplicationScope
    public OkHttpClient getClient(HttpLoggingInterceptor logger){
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.networkInterceptors().add(logger);
        return clientBuilder.build();
    }

}
