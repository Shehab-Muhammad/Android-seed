package com.seniors.androidseed.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.seniors.androidseed.R;
import com.seniors.androidseed.dependency.components.AppComponent;
import com.seniors.androidseed.dependency.components.DaggerLoginComponent;
import com.seniors.androidseed.dependency.modules.ActivityModule;
import com.seniors.androidseed.ui.base.BaseActivity;
import com.seniors.androidseed.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shehab-develop on 06/02/17.
 */

public class LoginActivity extends BaseActivity implements LoginView {

    final static public String ARG_IS_ADDING_NEW_ACCOUNT = "IS_ADDING_ACCOUNT";

    @Inject
    LoginPresenter mPresenter;

    @BindView(R.id.loginButton)
    Button loginButton;

    @BindView(R.id.password)
    EditText userPassword;

    @BindView(R.id.username)
    EditText username;

    @Override
    public void startMainActivity() {
        if(!getIntent().getBooleanExtra(ARG_IS_ADDING_NEW_ACCOUNT, false)){
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
        }
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(mPresenter.hasToken()){
            return;
        }
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.loginButton)
    void login(){
        mPresenter.login(username.getText().toString(), userPassword.getText().toString());
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerLoginComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(this))
                .build().inject(this);
        mPresenter.attach(this);
    }

}
