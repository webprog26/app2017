package com.androiddeveloper.webprog26.app2017.engine.mvp.views;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * Created by webpr on 22.06.2017.
 */

public interface TimelineView {

    @NonNull
    SharedPreferences getSharedPreferences();
    void registerEventsHandler();
    void unregisterEventsHandler();
}
