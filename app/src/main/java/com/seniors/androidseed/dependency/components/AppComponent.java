package com.seniors.androidseed.dependency.components;

import com.seniors.androidseed.data.Api;
import com.seniors.androidseed.data.DataManager;
import com.seniors.androidseed.dependency.modules.DataModule;
import com.seniors.androidseed.helpers.EventBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by shehab-develop on 02/02/17.
 */

@Singleton
@Component(modules = DataModule.class)
public interface AppComponent {
    Api getApi();

    DataManager getManager();

    EventBus getEventBus();
}
