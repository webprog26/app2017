package com.androiddeveloper.webprog26.app2017;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.androiddeveloper.webprog26.app2017.dagger.App;
import com.androiddeveloper.webprog26.app2017.dagger.modules.MainPresenterModule;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.MainPresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.views.MainView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView{

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.btn_logout)
    Button mBtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter.setView(this);

        getBtnLogout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.askLogout();
            }
        });
    }

    @Override
    protected void setupActivityComponent() {
        App.getAppComponent().plus(new MainPresenterModule()).inject(this);
    }

    @NonNull
    @Override
    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(this);
    }

    private Button getBtnLogout() {
        return mBtnLogout;
    }

    @Override
    public void backToStartActivity() {
        startActivity(new Intent(MainActivity.this, StartActivity.class));
        finish();
    }
}
