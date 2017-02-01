package com.seniors.androidseed.ui.main;

import com.seniors.androidseed.ui.base.BaseView;

import java.util.List;

/**
 * Created by shehab-develop on 02/02/17.
 */

public interface MainView extends BaseView {
    void showNetworkError();

    void showEmptyRepos();

    void showRepos(List<String> repos);
}
