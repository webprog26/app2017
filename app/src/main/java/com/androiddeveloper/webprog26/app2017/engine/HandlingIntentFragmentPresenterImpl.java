package com.androiddeveloper.webprog26.app2017.engine;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.constants.Constants;
import com.androiddeveloper.webprog26.app2017.dagger.App;

import javax.inject.Inject;

import twitter4j.auth.AccessToken;

/**
 * Created by webpr on 21.06.2017.
 */

public class HandlingIntentFragmentPresenterImpl implements HandlingIntentFragmentPresenter {

    private HandlingIntentFragmentView handlingIntentFragmentView;

    @Inject
    TwitterApp mTwitterApp;

    public HandlingIntentFragmentPresenterImpl() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void setView(HandlingIntentFragmentView handlingIntentFragmentView) {
        this.handlingIntentFragmentView = handlingIntentFragmentView;
    }

    @NonNull
    @Override
    public EventsHandler getEventsHandler() {
        return new HandlingIntentFragmentEventsHandler(this);
    }

    @Override
    public void askAccessToken(String verifier) {
        new GetAccessTokenCommand(mTwitterApp.getTwitter(), verifier, mTwitterApp.getRequestToken()).execute();
    }

    @Override
    public void saveAccessToken(AccessToken accessToken) {
        SharedPreferences sharedPreferences = getHandlingIntentFragmentView().getSharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Constants.PREF_KEY_TOKEN, accessToken.getToken());
        editor.putString(Constants.PREF_KEY_SECRET, accessToken.getTokenSecret());
        editor.putBoolean(Constants.IS_LOGGED_IN, true);

        editor.apply();

        getHandlingIntentFragmentView().startMainActivity();
    }

    private HandlingIntentFragmentView getHandlingIntentFragmentView() {
        return handlingIntentFragmentView;
    }
}
