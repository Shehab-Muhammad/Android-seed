package com.seniors.androidseed.dependency.modules;

import android.content.Context;

import com.seniors.androidseed.helpers.AppUtils;
import com.seniors.androidseed.helpers.EventBus;

import java.io.IOException;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import static com.seniors.androidseed.helpers.AppUtils.AUTH_KEY;
import static com.seniors.androidseed.helpers.AppUtils.UNAUTHORIZED_EVENT;

/**
 * Created by shehab-develop on 02/02/17.
 */

@Module(includes = AppModule.class)
public class ClientModule {
    @Provides
    @Singleton
    public HttpLoggingInterceptor getLogger(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @Singleton
    @Named("authInterceptor")
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
    @Singleton
    @Named("responseInterceptor")
    public Interceptor getResponseInterceptor(final EventBus bus){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                if (response.code() == 403){
                    bus.post(UNAUTHORIZED_EVENT);
                }
                return response;
            }
        };
    }

    @Provides
    @Singleton
    public OkHttpClient getClient(HttpLoggingInterceptor logger, @Named("authInterceptor") Interceptor authInterceptor,
                                  @Named("responseInterceptor") Interceptor responseInterceptor){
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.networkInterceptors().add(logger);
        clientBuilder.interceptors().add(authInterceptor);
        clientBuilder.addInterceptor(responseInterceptor);
        return clientBuilder.build();
    }

}
