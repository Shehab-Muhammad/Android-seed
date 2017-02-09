package com.seniors.androidseed.helpers;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.compat.BuildConfig;
import android.support.v4.app.ActivityCompat;

import java.io.IOException;

/**
 * Created by shehab-develop on 07/02/17.
 */

public class AppUtils {

    public static String AUTH_KEY = "Authorization";
    public static String UNAUTHORIZED_EVENT = "unauthorized user";

    public static class AuthUtils{
        String authToken = null;
        public String getAccountToken(Context context) {
            Account mAccount;
            AccountManager am = AccountManager.get(context);
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                return null;
            }
            Account[] allAccounts = am.getAccountsByType(BuildConfig.APPLICATION_ID);
            if (allAccounts.length == 0){
                return null;
            }
            else {
                mAccount = allAccounts[0];
            }
            final AccountManagerFuture<Bundle> apiKey = am.getAuthToken(mAccount, BuildConfig.APPLICATION_ID, null, false, null, null);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Bundle tokenBundle = apiKey.getResult();
                        authToken = tokenBundle.getString(AccountManager.KEY_AUTHTOKEN);
                    } catch (AuthenticatorException | IOException | OperationCanceledException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            return authToken;
        }
    }
}
