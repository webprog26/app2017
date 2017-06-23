package com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.constants.Constants;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.MainPresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.views.MainView;

/**
 * Created by webpr on 21.06.2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    @Override
    public void setView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void askLogout() {

        SharedPreferences.Editor editor = getEditor();

        editor.remove(Constants.PREF_KEY_TOKEN);
        editor.remove(Constants.PREF_KEY_SECRET);
        editor.remove(Constants.IS_LOGGED_IN);

        editor.apply();

        getMainView().backToStartActivity();
    }

    @Override
    public void changeTimelineModeToDetailed() {

    }

    @Override
    public void changeTimelineModeToDefault() {



    }

    @Override
    public int getTimelineMode() {
        return getMainView().getSharedPreferences().getInt(Constants.TIMELINE_MODE_TAG, Constants.TIMELINE_MODE_DEFAULT);
    }

    @Override
    @NonNull
    public SharedPreferences.Editor getEditor() {
        return getMainView().getSharedPreferences().edit();
    }

    @Override
    public void saveTimeLineMode(int timeLineMode) {
        getEditor().putInt(Constants.TIMELINE_MODE_TAG, timeLineMode).apply();
    }

    private MainView getMainView() {
        return mainView;
    }
}
