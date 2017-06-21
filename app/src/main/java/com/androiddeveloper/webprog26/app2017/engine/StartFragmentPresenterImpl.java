package com.androiddeveloper.webprog26.app2017.engine;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.androiddeveloper.webprog26.app2017.dagger.App;

import javax.inject.Inject;

/**
 * Created by webpr on 21.06.2017.
 */

public class StartFragmentPresenterImpl implements StartFragmentPresenter {

    private static final String TAG = "StartFragmentPresenter";

    private StartFragmentView startFragmentView;

    @Inject
    TwitterApp mTwitterApp;

    public StartFragmentPresenterImpl() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void setView(StartFragmentView startFragmentView) {
        this.startFragmentView = startFragmentView;
    }

    @Override
    public void askOauth() {
        new GetRequestTokenCommand(mTwitterApp.getTwitter()).execute();
    }

    @NonNull
    @Override
    public EventsHandler getEventsHandler() {
        return new StartFragmentEventsHandler(this);
    }

    @NonNull
    @Override
    public TwitterGetter getTwitterGetter() {
        return mTwitterApp;
    }

    @Override
    public void startAuthBrowserActivity(String authUrl) {
        getStartFragmentView().startAuthBrowserActivity(authUrl);
    }

    private StartFragmentView getStartFragmentView() {
        return startFragmentView;
    }
}
