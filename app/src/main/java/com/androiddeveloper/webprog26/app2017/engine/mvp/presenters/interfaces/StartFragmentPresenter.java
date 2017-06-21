package com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.engine.mvp.views.StartFragmentView;
import com.androiddeveloper.webprog26.app2017.engine.twitter_app.TwitterGetter;
import com.androiddeveloper.webprog26.app2017.engine.event_bus.events_handlers.EventsHandler;

/**
 * Created by webpr on 21.06.2017.
 */

public interface StartFragmentPresenter {

    void setView(StartFragmentView startFragmentView);
    void askOauth();
    @NonNull
    EventsHandler getEventsHandler();
    void startAuthBrowserActivity(String authUrl);
    @NonNull
    TwitterGetter getTwitterGetter();
}
