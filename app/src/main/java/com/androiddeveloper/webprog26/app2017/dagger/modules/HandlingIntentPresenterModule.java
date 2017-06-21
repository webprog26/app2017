package com.androiddeveloper.webprog26.app2017.dagger.modules;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.dagger.scopes.FragmentScope;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.HandlingIntentFragmentPresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations.HandlingIntentFragmentPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webpr on 21.06.2017.
 */
@Module
public class HandlingIntentPresenterModule {

    @Provides
    @NonNull
    @FragmentScope
    HandlingIntentFragmentPresenter provideHandlingIntentFragmentPresenter(){
        return new HandlingIntentFragmentPresenterImpl();
    }
}
