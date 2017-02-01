package com.seniors.androidseed.ui.main;

import com.seniors.androidseed.data.Model.ReposResponse;
import com.seniors.androidseed.ui.base.BaseView;

/**
 * Created by shehab-develop on 02/02/17.
 */

public interface MainView extends BaseView {
    void showNetworkError();

    void showEmptyRepos();

    void showRepos(ReposResponse repos);
}
