package com.androiddeveloper.webprog26.app2017.engine.event_bus.events_handlers;

import android.util.Log;

import com.androiddeveloper.webprog26.app2017.constants.Constants;
import com.androiddeveloper.webprog26.app2017.engine.event_bus.events.GetTwitterTimelineEvent;
import com.androiddeveloper.webprog26.app2017.engine.helpers.StatusToTwitterPostConverter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.TimelinePresenter;
import com.androiddeveloper.webprog26.app2017.engine.pojo_models.TwitterPost;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import twitter4j.MediaEntity;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * Created by webpr on 22.06.2017.
 */

public class TimelineFragmentsEventsHandler extends EventsHandler {

    private static final String TAG = "TF_EventsHandler";

    private final TimelinePresenter timelinePresenter;

    public TimelineFragmentsEventsHandler(TimelinePresenter timelinePresenter) {
        this.timelinePresenter = timelinePresenter;
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onGetTwitterTimelineEvent(GetTwitterTimelineEvent getTwitterTimelineEvent){
        Log.i(TAG, getTwitterTimelineEvent.getTwitter().toString());

        ArrayList<TwitterPost> twitterPosts = new ArrayList<>();

        try{
            for(Status status: getTwitterTimelineEvent.getTwitter().getHomeTimeline()){

                twitterPosts.add(StatusToTwitterPostConverter.convertStatusToTwitterPost(status));

            }
        } catch (TwitterException e){
            Log.i(TAG, e.getMessage());
        }

        for(TwitterPost twitterPost: twitterPosts){
            Log.i(TAG, twitterPost.toString());
        }
    }

    private TimelinePresenter getTimelinePresenter() {
        return timelinePresenter;
    }
}
