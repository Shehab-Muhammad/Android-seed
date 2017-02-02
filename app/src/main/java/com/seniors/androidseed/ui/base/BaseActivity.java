package com.seniors.androidseed.ui.base;

import android.app.Activity;
import android.os.Bundle;

import com.seniors.androidseed.dependency.components.AppComponent;
import com.seniors.androidseed.ui.SeedApp;

/**
 * Created by shehab-develop on 02/02/17.
 */

public abstract class BaseActivity extends Activity implements BaseView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SeedApp app = (SeedApp)getApplication();
        setupActivityComponent(app.component());
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);
}
