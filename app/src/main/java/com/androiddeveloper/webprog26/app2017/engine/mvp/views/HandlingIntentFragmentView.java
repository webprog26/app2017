package com.androiddeveloper.webprog26.app2017.engine.mvp.views;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * Created by webpr on 21.06.2017.
 */

public interface HandlingIntentFragmentView {

    @NonNull
    SharedPreferences getSharedPreferences();

    void registerEventsHandler();
    void unregisterEventsHandler();
    void startMainActivity();
}
