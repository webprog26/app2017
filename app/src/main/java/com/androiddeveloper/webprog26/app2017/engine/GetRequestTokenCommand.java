package com.androiddeveloper.webprog26.app2017.engine;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import twitter4j.Twitter;

/**
 * Created by webpr on 21.06.2017.
 */

public class GetRequestTokenCommand implements Command {

    private static final String TAG = "RequestTokenCom";

    private final Twitter mTwitter;

    public GetRequestTokenCommand(Twitter twitter) {
        this.mTwitter = twitter;
    }

    @Override
    public void execute() {
        Log.i(TAG, "execute " + getTwitter().toString());
        EventBus.getDefault().post(new GetRequestTokenEvent(getTwitter()));
    }

    private Twitter getTwitter() {
        return mTwitter;
    }
}
