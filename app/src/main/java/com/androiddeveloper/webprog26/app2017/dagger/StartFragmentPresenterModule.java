package com.androiddeveloper.webprog26.app2017.dagger;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.engine.StartFragmentPresenter;
import com.androiddeveloper.webprog26.app2017.engine.StartFragmentPresenterImpl;

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
