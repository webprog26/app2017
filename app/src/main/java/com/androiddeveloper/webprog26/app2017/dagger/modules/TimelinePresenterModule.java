package com.androiddeveloper.webprog26.app2017.dagger.modules;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.dagger.scopes.FragmentScope;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations.TimelinePresenterImpl;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.TimelinePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webpr on 22.06.2017.
 */
@Module
public class TimelinePresenterModule {

    @Provides
    @NonNull
    @FragmentScope
    TimelinePresenter provideTimelinePresenter(){
        return new TimelinePresenterImpl();
    }
}
