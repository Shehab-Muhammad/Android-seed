package com.seniors.androidseed.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.seniors.androidseed.data.Model.ReposResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by shehab-develop on 01/02/17.
 */

public interface Api {
    final String baseUrl = "https://api.github.com";

    @GET("user/repos")
    Call<ReposResponse> getRepos();

    class Creator{

        public static Api create(OkHttpClient client){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit mRetrofit = new Retrofit.Builder()
                    .baseUrl(Api.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();
            return mRetrofit.create(Api.class);
        }
    }
}
