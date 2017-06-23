package com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.engine.event_bus.events_handlers.EventsHandler;
import com.androiddeveloper.webprog26.app2017.engine.mvp.views.TimelineView;

import twitter4j.auth.AccessToken;

/**
 * Created by webpr on 22.06.2017.
 */

public interface TimelinePresenter {

    void setView(TimelineView timelineView);
    void loadTimeline();
    @NonNull
    AccessToken getAccessToken();

    @NonNull
    EventsHandler getEventsHandler();
}
