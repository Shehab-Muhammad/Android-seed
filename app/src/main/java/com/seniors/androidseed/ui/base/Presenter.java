package com.seniors.androidseed.ui.base;

/**
 * Created by shehab-develop on 01/02/17.
 */

public interface Presenter<V extends BaseView> {
    void attach(V mvpView);

    void detach(V mvpView);
}
