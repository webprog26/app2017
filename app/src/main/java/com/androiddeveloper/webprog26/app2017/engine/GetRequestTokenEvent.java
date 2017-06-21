package com.androiddeveloper.webprog26.app2017.engine;

import twitter4j.Twitter;

/**
 * Created by webpr on 21.06.2017.
 */

public class GetRequestTokenEvent {

    private final Twitter mTwitter;

    public GetRequestTokenEvent(Twitter twitter) {
        this.mTwitter = twitter;
    }

    public Twitter getTwitter() {
        return mTwitter;
    }
}
