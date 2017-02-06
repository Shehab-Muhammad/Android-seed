package com.seniors.androidseed.auth;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by shehab-develop on 06/02/17.
 */

public class AppAuthenticatorService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        AppAuthenticator authenticator = new AppAuthenticator(this);
        return authenticator.getIBinder();
    }
}
