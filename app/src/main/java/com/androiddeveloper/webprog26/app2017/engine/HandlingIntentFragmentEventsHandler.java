package com.androiddeveloper.webprog26.app2017.engine;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

/**
 * Created by webpr on 21.06.2017.
 */

public class HandlingIntentFragmentEventsHandler extends EventsHandler {

    private static final String TAG = "HIEventsHandler";

    private final HandlingIntentFragmentPresenter handlingIntentFragmentPresenter;

    public HandlingIntentFragmentEventsHandler(HandlingIntentFragmentPresenter handlingIntentFragmentPresenter) {
        this.handlingIntentFragmentPresenter = handlingIntentFragmentPresenter;
    }


    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onGetAccessTokenEvent(GetAccessTokenEvent getAccessTokenEvent){
        AccessToken accessToken = null;

        try {
            accessToken = getAccessTokenEvent.getTwitter().getOAuthAccessToken(getAccessTokenEvent.getRequestToken(), getAccessTokenEvent.getVerifier());
        } catch (TwitterException e){
            Log.i(TAG, "onGetAccessTokenEvent error " + e.getMessage());
        }

        if(accessToken != null){
            Log.i(TAG, "accessToken " + accessToken.toString());
            EventBus.getDefault().post(new SaveAccessTokenEvent(accessToken));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSaveAccessTokenEvent(SaveAccessTokenEvent saveAccessTokenEvent){
        getHandlingIntentFragmentPresenter().saveAccessToken(saveAccessTokenEvent.getAccessToken());
    }

    private HandlingIntentFragmentPresenter getHandlingIntentFragmentPresenter() {
        return handlingIntentFragmentPresenter;
    }
}
