package com.seniors.androidseed.ui.main;

import com.seniors.androidseed.data.DataManager;
import com.seniors.androidseed.data.Model.ReposResponse;
import com.seniors.androidseed.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shehab-develop on 02/02/17.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private DataManager dataManager;

    @Inject
    public MainPresenter(DataManager dm){
        dataManager = dm;
    }

    @Override
    public void attach(MainView mvpView) {
        super.attach(mvpView);
    }

    @Override
    public void detach(MainView mvpView) {
        super.detach(mvpView);
    }

    @Override
    public MainView getView() {
        return super.getView();
    }

    public void loadRepos(){
        Callback<ReposResponse> response = new Callback<ReposResponse>() {
            @Override
            public void onResponse(Call<ReposResponse> call, Response<ReposResponse> response) {
                getView().showRepos(response.body());
            }

            @Override
            public void onFailure(Call<ReposResponse> call, Throwable t) {
                getView().showNetworkError();
            }
        };
        dataManager.getRepos(response);
    }
}
