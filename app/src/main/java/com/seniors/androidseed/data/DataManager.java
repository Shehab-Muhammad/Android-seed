package com.seniors.androidseed.data;

import com.seniors.androidseed.data.Model.ReposResponse;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by shehab-develop on 02/02/17.
 */

public class DataManager {

    private Api apiService;

    public DataManager(Api mApi){
        apiService = mApi;
    }

    public void getRepos(Callback<ReposResponse> callback){
        Call<ReposResponse> reposCall = apiService.getRepos();
        reposCall.enqueue(callback);
    }
}
