package com.androiddeveloper.webprog26.app2017.dagger.modules;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.dagger.scopes.FragmentScope;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.StartFragmentPresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations.StartFragmentPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webpr on 21.06.2017.
 */
@Module
public class StartFragmentPresenterModule {

    @Provides
    @NonNull
    @FragmentScope
    StartFragmentPresenter provideStartFragmentPresenter(){
        return new StartFragmentPresenterImpl();
    }
}
