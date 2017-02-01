package com.seniors.androidseed.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.seniors.androidseed.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public void showRepos(List<String> repos) {

    }
}
