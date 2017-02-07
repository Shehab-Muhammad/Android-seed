package com.seniors.androidseed.ui.login;

import android.app.Activity;

import com.seniors.androidseed.helpers.AppUtils;
import com.seniors.androidseed.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by shehab-develop on 06/02/17.
 */

public class LoginPresenter extends BasePresenter<LoginView> {
    final static String CLASS_TAG = "Login Presenter";

    @Inject
    LoginPresenter(){
    }

    boolean hasToken(){
        String token = new AppUtils.AuthUtils().getAccountToken((Activity) getView());
        if(token != null){
            getView().startMainActivity();
            return true;
        }
        return false;
    }

    void login(String username, String password){

    }
}
