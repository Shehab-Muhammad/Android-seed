package com.seniors.androidseed.data;

import com.seniors.androidseed.data.Model.ReposResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by shehab-develop on 02/02/17.
 */

@Singleton
public class DataManager {

    private Api apiService;

    @Inject
    public DataManager(Api mApi){
        apiService = mApi;
    }

    public void getRepos(Callback<ReposResponse> callback){
        Call<ReposResponse> reposCall = apiService.getRepos();
        reposCall.enqueue(callback);
    }
}
