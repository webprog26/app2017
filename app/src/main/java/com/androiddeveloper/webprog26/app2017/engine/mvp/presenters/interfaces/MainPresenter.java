package com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.engine.mvp.views.MainView;

/**
 * Created by webpr on 21.06.2017.
 */

public interface MainPresenter {

    void setView(MainView mainView);
    void changeTimelineModeToDetailed();
    void changeTimelineModeToDefault();
    void askLogout();
    @NonNull
    SharedPreferences.Editor getEditor();
    int getTimelineMode();
    void saveTimeLineMode(final int timeLineMode);
}
