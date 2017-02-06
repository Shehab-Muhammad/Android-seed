package com.seniors.androidseed.dependency.components;

import com.seniors.androidseed.dependency.ActivityScope;
import com.seniors.androidseed.dependency.modules.ActivityModule;
import com.seniors.androidseed.ui.login.LoginActivity;

import dagger.Component;

/**
 * Created by shehab-develop on 06/02/17.
 */

@ActivityScope
@Component(
        modules = ActivityModule.class,
        dependencies = AppComponent.class
)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
