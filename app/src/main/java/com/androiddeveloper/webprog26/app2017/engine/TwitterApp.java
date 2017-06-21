package com.androiddeveloper.webprog26.app2017.engine;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.constants.Constants;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by webpr on 21.06.2017.
 */

public class TwitterApp implements TwitterGetter{

    private final Configuration configuration;
    private RequestToken mRequestToken;

    public TwitterApp() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey(Constants.CONSUMER_KEY);
        configurationBuilder.setOAuthConsumerSecret(Constants.CONSUMER_SECRET);
        this.configuration = configurationBuilder.build();
    }

    @NonNull
    @Override
    public Twitter getTwitter() {
        return new TwitterFactory(getConfiguration()).getInstance();
    }

    @NonNull
    @Override
    public Twitter getTwitter(AccessToken accessToken) {
        return new TwitterFactory(getConfiguration()).getInstance(accessToken);
    }

    private Configuration getConfiguration() {
        return configuration;
    }

    @NonNull
    @Override
    public RequestToken getRequestToken() {
        return mRequestToken;
    }

    @Override
    public void setRequestToken(RequestToken mRequestToken) {
        this.mRequestToken = mRequestToken;
    }
}
