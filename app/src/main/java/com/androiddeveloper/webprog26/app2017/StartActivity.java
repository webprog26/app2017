package com.androiddeveloper.webprog26.app2017;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.androiddeveloper.webprog26.app2017.constants.Constants;
import com.androiddeveloper.webprog26.app2017.dagger.App;
import com.androiddeveloper.webprog26.app2017.dagger.StartPresenterModule;
import com.androiddeveloper.webprog26.app2017.engine.StartPresenter;
import com.androiddeveloper.webprog26.app2017.engine.StartView;

import javax.inject.Inject;

public class StartActivity extends BaseActivity implements StartView{

    private static final String TAG = "StartActivity_TAG";

    @Inject
    StartPresenter mStartPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mStartPresenter.setView(this);

        if(savedInstanceState == null){

            if(isApprovingIntentReceived()){
                Log.i(TAG, "isApprovingIntentReceived");
                mStartPresenter.setHandlingIntentFragment(getContainerViewId(), getIntent().getData());
            } else {
                mStartPresenter.setStartFragment(getContainerViewId());
            }

        }



    }

    @Override
    protected void setupActivityComponent() {
        App.getAppComponent().plus(new StartPresenterModule()).inject(this);
    }


    @NonNull
    @Override
    public FragmentManager _getFragmentManager() {
        return getSupportFragmentManager();
    }

    @Override
    public int getContainerViewId() {
        return R.id.content_frame;
    }

    @Override
    public boolean isApprovingIntentReceived() {
        Uri data = getIntent().getData();

        return data != null && data.toString().startsWith(Constants.CALLBACK_URL);
    }
}
