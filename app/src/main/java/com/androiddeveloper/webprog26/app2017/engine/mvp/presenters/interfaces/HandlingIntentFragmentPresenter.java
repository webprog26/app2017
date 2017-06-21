package com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.engine.mvp.views.HandlingIntentFragmentView;
import com.androiddeveloper.webprog26.app2017.engine.event_bus.events_handlers.EventsHandler;

import twitter4j.auth.AccessToken;

/**
 * Created by webpr on 21.06.2017.
 */

public interface HandlingIntentFragmentPresenter {

    void setView(HandlingIntentFragmentView handlingIntentFragmentView);
    @NonNull
    EventsHandler getEventsHandler();
    void askAccessToken(String verifier);
    void saveAccessToken(AccessToken accessToken);
}
