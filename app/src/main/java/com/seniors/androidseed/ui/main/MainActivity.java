package com.seniors.androidseed.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.seniors.androidseed.R;
import com.seniors.androidseed.data.Model.ReposResponse;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter.attach(this);
        mPresenter.loadRepos();
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
