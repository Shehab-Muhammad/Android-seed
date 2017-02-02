package com.seniors.androidseed.dependency.components;

import com.seniors.androidseed.data.Api;
import com.seniors.androidseed.dependency.ApplicationScope;
import com.seniors.androidseed.dependency.modules.ApiModule;

import dagger.Component;

/**
 * Created by shehab-develop on 02/02/17.
 */

@ApplicationScope
@Component(modules = ApiModule.class)
public interface AppComponent {
    Api getApi();
}
