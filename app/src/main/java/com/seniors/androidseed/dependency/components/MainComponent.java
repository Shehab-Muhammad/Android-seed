package com.seniors.androidseed.dependency.components;

import com.seniors.androidseed.dependency.ActivityScope;
import com.seniors.androidseed.dependency.modules.ActivityModule;
import com.seniors.androidseed.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by shehab-develop on 02/02/17.
 */

@ActivityScope
@Component(
        modules = ActivityModule.class,
        dependencies = AppComponent.class
)
public interface MainComponent {

    void inject(MainActivity activity);
}
