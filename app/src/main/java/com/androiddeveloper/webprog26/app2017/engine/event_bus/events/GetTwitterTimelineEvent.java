package com.androiddeveloper.webprog26.app2017.engine.event_bus.events;

import twitter4j.Twitter;

/**
 * Created by webpr on 22.06.2017.
 */

public class GetTwitterTimelineEvent {

    private final Twitter mTwitter;

    public GetTwitterTimelineEvent(Twitter twitter) {
        this.mTwitter = twitter;
    }

    public Twitter getTwitter() {
        return mTwitter;
    }
}
