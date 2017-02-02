package com.seniors.androidseed.dependency.components;

import com.seniors.androidseed.data.Api;
import com.seniors.androidseed.data.DataManager;
import com.seniors.androidseed.dependency.ApplicationScope;
import com.seniors.androidseed.dependency.modules.DataModule;

import dagger.Component;

/**
 * Created by shehab-develop on 02/02/17.
 */

@ApplicationScope
@Component(modules = DataModule.class)
public interface AppComponent {
    Api getApi();

    DataManager getManager();
}
