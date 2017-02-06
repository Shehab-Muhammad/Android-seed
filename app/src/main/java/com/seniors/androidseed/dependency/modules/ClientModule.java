package com.seniors.androidseed.dependency.modules;

import android.app.Activity;
import android.content.Context;

import com.seniors.androidseed.dependency.ApplicationScope;
import com.seniors.androidseed.helpers.AppUtils;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import static com.seniors.androidseed.helpers.AppUtils.AUTH_KEY;

/**
 * Created by shehab-develop on 02/02/17.
 */

@Module(includes = AppModule.class)
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
    public Interceptor getAuth(final Context appContext){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String key = new AppUtils.AuthUtils().getAccountToken(appContext);
                Request request = chain.request().newBuilder().addHeader(AUTH_KEY, key).build();
                return chain.proceed(request);
            }
        };
    }

    @Provides
    @ApplicationScope
    public OkHttpClient getClient(HttpLoggingInterceptor logger, Interceptor authInterceptor){
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.networkInterceptors().add(logger);
        clientBuilder.interceptors().add(authInterceptor);
        return clientBuilder.build();
    }

}
