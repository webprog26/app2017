package com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations;

import android.support.annotation.NonNull;
import android.util.Log;

import com.androiddeveloper.webprog26.app2017.constants.Constants;
import com.androiddeveloper.webprog26.app2017.dagger.App;
import com.androiddeveloper.webprog26.app2017.engine.commands.GetTwitterTimelineCommand;
import com.androiddeveloper.webprog26.app2017.engine.event_bus.events_handlers.EventsHandler;
import com.androiddeveloper.webprog26.app2017.engine.event_bus.events_handlers.TimelineFragmentsEventsHandler;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.TimelinePresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.views.TimelineView;
import com.androiddeveloper.webprog26.app2017.engine.twitter_app.TwitterGetter;

import javax.inject.Inject;

import twitter4j.Twitter;
import twitter4j.auth.AccessToken;

/**
 * Created by webpr on 22.06.2017.
 */

public class TimelinePresenterImpl implements TimelinePresenter {

    private static final String TAG = "TimelinePresenter";

    private TimelineView mTimelineView;

    @Inject
    TwitterGetter mTwitterGetter;

    public TimelinePresenterImpl() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void setView(TimelineView timelineView) {
        this.mTimelineView = timelineView;
    }

    @Override
    public void loadTimeline() {
        Twitter twitter = mTwitterGetter.getTwitter(getAccessToken());
        Log.i(TAG, "loadTimeline from " + twitter);
        new GetTwitterTimelineCommand(twitter).execute();

    }

    @NonNull
    @Override
    public AccessToken getAccessToken() {

        return new AccessToken(getTimelineView().getSharedPreferences().getString(Constants.PREF_KEY_TOKEN, null),
                               getTimelineView().getSharedPreferences().getString(Constants.PREF_KEY_SECRET, null));
    }

    private TimelineView getTimelineView() {
        return mTimelineView;
    }

    @NonNull
    @Override
    public EventsHandler getEventsHandler() {
        return new TimelineFragmentsEventsHandler(this);
    }
}
