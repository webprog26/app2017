package com.androiddeveloper.webprog26.app2017.engine;

import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * Created by webpr on 21.06.2017.
 */

public interface StartFragmentPresenter {

    void setView(StartFragmentView startFragmentView);
    void askOauth();
    @NonNull
    EventsHandler getEventsHandler();
    void startAuthBrowserActivity(String authUrl);
    @NonNull
    TwitterGetter getTwitterGetter();
}
