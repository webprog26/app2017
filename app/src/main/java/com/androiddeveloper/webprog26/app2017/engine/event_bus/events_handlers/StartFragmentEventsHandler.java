package com.androiddeveloper.webprog26.app2017.engine.event_bus.events_handlers;

import android.util.Log;

import com.androiddeveloper.webprog26.app2017.constants.Constants;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.StartFragmentPresenter;
import com.androiddeveloper.webprog26.app2017.engine.event_bus.events.GetRequestTokenEvent;
import com.androiddeveloper.webprog26.app2017.engine.event_bus.events.StartAuthBrowserActivityEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

/**
 * Created by webpr on 21.06.2017.
 */

public class StartFragmentEventsHandler extends EventsHandler {

    private static final String TAG = "S_EventsHandler";

    private final StartFragmentPresenter startFragmentPresenter;

    public StartFragmentEventsHandler(StartFragmentPresenter startFragmentPresenter) {
        this.startFragmentPresenter = startFragmentPresenter;
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onGetRequestTokenEvent(GetRequestTokenEvent getRequestTokenEvent){
        RequestToken requestToken  = null;

        try {
            requestToken = getRequestTokenEvent.getTwitter().getOAuthRequestToken(Constants.CALLBACK_URL);
        } catch (TwitterException e){
            Log.i(TAG, "onGetRequestTokenEvent error " + e.getMessage());
        }

        if(requestToken != null){
            Log.i(TAG, requestToken.toString());
            getStartFragmentPresenter().getTwitterGetter().setRequestToken(requestToken);
            EventBus.getDefault().post(new StartAuthBrowserActivityEvent(requestToken.getAuthenticationURL()));
        } else {
            Log.i(TAG, "requestToken is null");
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStartAuthBrowserActivityEvent(StartAuthBrowserActivityEvent startAuthBrowserActivityEvent){
        getStartFragmentPresenter().startAuthBrowserActivity(startAuthBrowserActivityEvent.getAuthUrl());
    }

    private StartFragmentPresenter getStartFragmentPresenter() {
        return startFragmentPresenter;
    }
}
