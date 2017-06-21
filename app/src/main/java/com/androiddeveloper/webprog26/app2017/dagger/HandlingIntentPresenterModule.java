package com.androiddeveloper.webprog26.app2017.dagger;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.engine.HandlingIntentFragmentPresenter;
import com.androiddeveloper.webprog26.app2017.engine.HandlingIntentFragmentPresenterImpl;

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
