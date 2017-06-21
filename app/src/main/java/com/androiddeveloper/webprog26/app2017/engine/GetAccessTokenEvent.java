package com.androiddeveloper.webprog26.app2017.engine;

import twitter4j.Twitter;
import twitter4j.auth.RequestToken;

/**
 * Created by webpr on 21.06.2017.
 */

public class GetAccessTokenEvent {

    private final Twitter mTwitter;
    private final String mVerifier;
    private final RequestToken mRequestToken;

    public GetAccessTokenEvent(Twitter twitter, String verifier, RequestToken requestToken) {
        this.mTwitter = twitter;
        this.mVerifier = verifier;
        this.mRequestToken = requestToken;
    }

    public Twitter getTwitter() {
        return mTwitter;
    }

    public String getVerifier() {
        return mVerifier;
    }

    public RequestToken getRequestToken() {
        return mRequestToken;
    }
}
