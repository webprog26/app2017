package com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.constants.Constants;
import com.androiddeveloper.webprog26.app2017.dagger.App;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.HandlingIntentFragmentPresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.views.HandlingIntentFragmentView;
import com.androiddeveloper.webprog26.app2017.engine.commands.GetAccessTokenCommand;
import com.androiddeveloper.webprog26.app2017.engine.event_bus.events_handlers.EventsHandler;
import com.androiddeveloper.webprog26.app2017.engine.event_bus.events_handlers.HandlingIntentFragmentEventsHandler;
import com.androiddeveloper.webprog26.app2017.engine.twitter_app.TwitterGetter;

import javax.inject.Inject;

import twitter4j.auth.AccessToken;

/**
 * Created by webpr on 21.06.2017.
 */

public class HandlingIntentFragmentPresenterImpl implements HandlingIntentFragmentPresenter {

    private HandlingIntentFragmentView handlingIntentFragmentView;

    @Inject
    TwitterGetter mTwitterGetter;

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
        new GetAccessTokenCommand(mTwitterGetter.getTwitter(), verifier, mTwitterGetter.getRequestToken()).execute();
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
