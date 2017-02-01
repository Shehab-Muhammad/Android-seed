package com.seniors.androidseed.ui.base;

/**
 * Created by shehab-develop on 01/02/17.
 */

public class BasePresenter<T extends BaseView> implements Presenter<T> {
    private T view;

    @Override
    public void attach(T mvpView) {
        view = mvpView;
    }

    @Override
    public void detach(T mvpView) {
        view = null;
    }

    public T getView(){
        return view;
    }
}
