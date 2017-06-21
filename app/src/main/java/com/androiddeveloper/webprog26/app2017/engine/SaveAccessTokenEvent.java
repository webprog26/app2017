package com.androiddeveloper.webprog26.app2017.engine;

import twitter4j.auth.AccessToken;

/**
 * Created by webpr on 21.06.2017.
 */

public class SaveAccessTokenEvent {

    private final AccessToken mAccessToken;

    public SaveAccessTokenEvent(AccessToken accessToken) {
        this.mAccessToken = accessToken;
    }

    public AccessToken getAccessToken() {
        return mAccessToken;
    }
}
