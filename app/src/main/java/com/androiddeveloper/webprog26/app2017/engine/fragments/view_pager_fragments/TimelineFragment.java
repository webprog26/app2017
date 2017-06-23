package com.androiddeveloper.webprog26.app2017.engine.fragments.view_pager_fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.androiddeveloper.webprog26.app2017.dagger.App;
import com.androiddeveloper.webprog26.app2017.dagger.modules.TimelinePresenterModule;
import com.androiddeveloper.webprog26.app2017.engine.fragments.BaseFragment;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.TimelinePresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.views.TimelineView;

import javax.inject.Inject;

/**
 * Created by webpr on 22.06.2017.
 */

public class TimelineFragment extends BaseFragment implements TimelineView{

    @Inject
    TimelinePresenter timelinePresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerEventsHandler();

        timelinePresenter.setView(this);

        timelinePresenter.loadTimeline();
    }

    @Override
    public void onDestroy() {
        unregisterEventsHandler();
        super.onDestroy();
    }

    @Override
    protected void setupFragmentComponent() {
        App.getAppComponent().plus(new TimelinePresenterModule()).inject(this);
    }

    @NonNull
    @Override
    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public void registerEventsHandler() {
        timelinePresenter.getEventsHandler().register();
    }

    @Override
    public void unregisterEventsHandler() {
        timelinePresenter.getEventsHandler().unregister();
    }
}