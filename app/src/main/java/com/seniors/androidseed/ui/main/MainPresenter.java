package com.seniors.androidseed.ui.main;

import com.seniors.androidseed.data.DataManager;
import com.seniors.androidseed.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by shehab-develop on 02/02/17.
 */

public class MainPresenter extends BasePresenter<MainView> {

    DataManager dataManager;

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

    }
}
