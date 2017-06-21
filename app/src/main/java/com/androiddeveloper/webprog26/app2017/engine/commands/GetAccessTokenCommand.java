package com.androiddeveloper.webprog26.app2017.engine.commands;

import com.androiddeveloper.webprog26.app2017.engine.event_bus.events.GetAccessTokenEvent;

import org.greenrobot.eventbus.EventBus;

import twitter4j.Twitter;
import twitter4j.auth.RequestToken;

/**
 * Created by webpr on 21.06.2017.
 */

public class GetAccessTokenCommand implements Command {

    private final Twitter mTwitter;
    private final String mVerifier;
    private final RequestToken mRequestToken;

    public GetAccessTokenCommand(Twitter twitter, String verifier, RequestToken requestToken) {
        this.mTwitter = twitter;
        this.mVerifier = verifier;
        this.mRequestToken = requestToken;
    }

    @Override
    public void execute() {
        EventBus.getDefault().post(new GetAccessTokenEvent(getTwitter(), getVerifier(), getRequestToken()));
    }

    private Twitter getTwitter() {
        return mTwitter;
    }

    private RequestToken getRequestToken() {
        return mRequestToken;
    }

    private String getVerifier() {
        return mVerifier;
    }
}
