package com.seniors.androidseed.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import com.seniors.androidseed.R;
import com.seniors.androidseed.data.Model.ReposResponse;
import com.seniors.androidseed.dependency.components.AppComponent;
import com.seniors.androidseed.dependency.components.DaggerMainComponent;
import com.seniors.androidseed.dependency.modules.ActivityModule;
import com.seniors.androidseed.ui.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter mPresenter;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(this))
                .build().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter.attach(this);
//        mPresenter.loadRepos();
    }

    @Override
    public void showNetworkError() {
        Toast.makeText(this, R.string.network_error_toast, Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showEmptyRepos() {

    }

    @Override
    public void showRepos(ReposResponse repos) {

    }
}
