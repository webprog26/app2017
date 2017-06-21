package com.androiddeveloper.webprog26.app2017.engine;

import android.support.annotation.NonNull;

import twitter4j.Twitter;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 * Created by webpr on 21.06.2017.
 */

public interface TwitterGetter {

    @NonNull
    Twitter getTwitter();
    @NonNull
    Twitter getTwitter(AccessToken accessToken);
    @NonNull
    RequestToken getRequestToken();

    void setRequestToken(RequestToken mRequestToken);

}
